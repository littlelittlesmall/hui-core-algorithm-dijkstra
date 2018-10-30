package com.hui.algorithm.data;

import com.hui.algorithm.core.DijkstraUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * <b><code>DistanceBuilder</code></b>
 * <p/>
 * Description: 初始化数据-相邻地铁站距离
 * <p/>
 * <b>Creation Time:</b> 2018/7/23 14:43.
 *
 * @author huweihui
 * @since metro-dev 0.1.0
 */
public class DistanceBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceBuilder.class);


    private final static String FILE_PATH = System.getProperty("user.dir") + File.separator +
            "src\\main\\resources\\distance.txt";
    private static HashMap<String, Double> distanceMap = new HashMap<>();

    private DistanceBuilder() {

    }

    public static Double getDistance(String key) {
        return distanceMap.get(key);
    }

    static {
        BufferedReader reader = null;
        try {

            reader = new BufferedReader(new FileReader(FILE_PATH));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String texts[] = line.split("\t");
                String key = texts[0];
                Double value = Double.valueOf(texts[1]);
                distanceMap.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    public static void main(String[] args) {
        Double a = DistanceBuilder.getDistance("石壁:谢村");
        LOGGER.info("test distance : {}", a);
    }
}
