package com.hui.algorithm.core;


import com.hui.algorithm.data.DataBuilder;
import com.hui.algorithm.data.DistanceBuilder;
import com.hui.algorithm.model.Result;
import com.hui.algorithm.model.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * <b><code>DijkstraUtil</code></b>
 * <p/>
 * Description:迪杰斯特拉算法的实例 。 计算地铁两点间最短距离
 * <p/>
 * <b>Creation Time:</b> 2018/7/24 15:02.
 *
 * @author huweihui
 * @since metrodev2 0.1.0
 */
public class DijkstraUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DijkstraUtil.class);
    /**
     * 结果集.
     *
     * @since hui_project 1.0.0
     */
    private static HashMap<Station, Result> resultMap = new HashMap<>();
    /**
     * 分析过的站点集合.
     *
     * @since hui_project 1.0.0
     */
    private static List<Station> analysisList = new ArrayList<>();

    /**
     * 迪杰斯特拉算法应用在地铁的实现.
     *
     * @param star the star
     * @param end  the end
     * @return the result
     * @since hui_project 1.0.0
     */
    public static Result calculate(Station star, Station end) {
        if (!analysisList.contains(star)) {
            analysisList.add(star);
        }
        if (star.equals(end)) {
            Result result = new Result();
            result.setDistance(0.0D);
            result.setEnd(star);
            result.setStar(star);
            resultMap.put(star, result);
            return resultMap.get(star);
        }
        if (resultMap.isEmpty()) {
            List<Station> linkStations = getLinkStations(star);
            for (Station station : linkStations) {
                Result result = new Result();
                result.setStar(star);
                result.setEnd(station);
                String key = star.getName() + ":" + station.getName();
                Double distance = DistanceBuilder.getDistance(key);
                result.setDistance(distance);
                result.getPassStations().add(station);
                resultMap.put(station, result);
            }
        }
        Station parent = getNextStation();
        if (parent == null) {
            Result result = new Result();
            result.setDistance(0.0D);
            result.setStar(star);
            result.setEnd(end);
            return resultMap.put(end, result);
        }
        if (parent.equals(end)) {
            return resultMap.get(parent);
        }
        List<Station> childLinkStations = getLinkStations(parent);
        for (Station child : childLinkStations) {
            if (analysisList.contains(child)) {
                continue;
            }
            String key = parent.getName() + ":" + child.getName();
            Double distance = DistanceBuilder.getDistance(key);
            if (parent.getName().equals(child.getName())) {
                distance = 0.0D;
            }
            Double parentDistance = resultMap.get(parent).getDistance();
            distance = doubleAdd(distance, parentDistance);
            List<Station> parentPassStations = resultMap.get(parent).getPassStations();
            Result childResult = resultMap.get(child);
            if (childResult != null) {
                if (childResult.getDistance() > distance) {
                    childResult.setDistance(distance);
                    childResult.getPassStations().clear();
                    childResult.getPassStations().addAll(parentPassStations);
                    childResult.getPassStations().add(child);
                }
            } else {
                childResult = new Result();
                childResult.setDistance(distance);
                childResult.setStar(star);
                childResult.setEnd(child);
                childResult.getPassStations().addAll(parentPassStations);
                childResult.getPassStations().add(child);
            }
            resultMap.put(child, childResult);
        }
        analysisList.add(parent);
        calculate(star, end);
        return resultMap.get(end);
    }


    /**
     * 获取所有相邻节点.
     *
     * @param station the station
     * @return the link stations
     * @since hui_project 1.0.0
     */
    private static List<Station> getLinkStations(Station station) {
        List<Station> linkedStaions = new ArrayList<Station>();
        for (List<Station> line : DataBuilder.lineSet) {
            for (int i = 0; i < line.size(); i++) {
                if (station.equals(line.get(i))) {
                    if (i == 0) {
                        linkedStaions.add(line.get(i + 1));
                    } else if (i == (line.size() - 1)) {
                        linkedStaions.add(line.get(i - 1));
                    } else {
                        linkedStaions.add(line.get(i + 1));
                        linkedStaions.add(line.get(i - 1));
                    }
                }
            }
        }
        return linkedStaions;
    }

    /**
     * 通过计算最小权值 计算下一个需要分析的点
     *
     * @return the next station
     * @since hui_project 1.0.0
     */
    private static Station getNextStation() {
        Double min = Double.MAX_VALUE;
        Station rets = null;
        Set<Station> stations = resultMap.keySet();
        for (Station station : stations) {
            if (analysisList.contains(station)) {
                continue;
            }
            Result result = resultMap.get(station);
            if (result.getDistance() < min) {
                min = result.getDistance();
                rets = result.getEnd();
            }
        }
        return rets;
    }

    /**
     * Double相加方法（防止丢失精度）.
     *
     * @param v1 the v 1
     * @param v2 the v 2
     * @return the double
     * @since hui_project 1.0.0
     */
    private static double doubleAdd(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 结果写到文件里面.
     * 这个方法写的比较乱，因为需求变了 为了快速拿出来前后站点分析出站所属线路 直接用的for循环。储存结构用LinkedHashMap会快很多。
     * @param filePath the file path
     * @throws IOException the io exception
     * @since hui_project 1.0.0
     */
    public static void getResultToText(String filePath) throws IOException {
        if (filePath == null) {
            throw new FileNotFoundException("兄弟来个路径保存路径吧");
        }
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(filePath, true));
        Set<List<Station>> lineSet = DataBuilder.lineSet;
        for (List<Station> stations : lineSet) {
            for (Station station : stations) {
                for (List<Station> stations2 : lineSet) {
                    for (Station stationTarget : stations2) {
                        LOGGER.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
                        DijkstraUtil dijkstraUtil = new DijkstraUtil();

                        Result result = dijkstraUtil.calculate(station, stationTarget);
                        resultMap = new HashMap<>();
                        analysisList = new ArrayList<>();
                        for (Station s : result.getPassStations()) {
                            if (s.getName().equals(stationTarget.getName())) {
                                String text = station.getName() + "\t" + stationTarget.getName() + "\t" + result.getPassStations().size() + "\t" + result.getDistance() + "\t";
                                for (Station test : result.getPassStations()) {
                                    LOGGER.info(test.getName() + ",");
                                    text = text + test.getName() + ",";
                                }
                                LOGGER.info("{}" , text);
                                LOGGER.info("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n");
                                writer.write(text);
                                writer.newLine();
                            }
                        }
                    }
                }
            }
        }
        writer.flush();
        writer.close();

    }
}
