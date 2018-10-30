package com.hui.algorithm.app;

import com.hui.algorithm.core.DijkstraUtil;
import com.hui.algorithm.model.Result;
import com.hui.algorithm.model.Station;

import java.io.File;
import java.io.IOException;

/**
 * <b><code>DijkstraApp</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/10/30 23:25.
 *
 * @author Hu Weihui
 */
public class DijkstraApp {
    private static final String filePath = System.getProperty("user.dir")+ File.separator+
            "src\\main\\resources\\result.txt";
    public static void main(String[] args) throws IOException {
        DijkstraUtil.getResultToText(filePath);
//        DijkstraApp.test();
    }

    /**
     * Test.
     *
     * @since hui_project 1.0.0
     */
    public static void test() {
        Result result = DijkstraUtil.calculate(new Station("市二宫"), new Station("广州南站"));

        for (Station station : result.getPassStations()) {
            System.out.print(station.getName() + ",");
        }
        System.out.println("\n总共经过距离" + result.getDistance());
        System.out.println("\n经过站点数：" + result.getPassStations().size());
    }
}
