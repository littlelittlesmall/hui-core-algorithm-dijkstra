package com.hui.algorithm.data;


import com.hui.algorithm.model.Station;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * <b><code>com.richstonedt.metro.app.DataBuilder</code></b>
 * <p/>
 * Description:初始化地铁站点
 * <p/>
 * <b>Creation Time:</b> 2018/7/10 12:36.
 *
 * @author huweihui
 * @since metro-dev 0.1.0
 */
public class DataBuilder {

    public static List<Station> line1 = new ArrayList<Station>();
    public static List<Station> line2 = new ArrayList<Station>();
    public static List<Station> line3 = new ArrayList<Station>();
    public static List<Station> line3N = new ArrayList<Station>();
    public static List<Station> line4 = new ArrayList<Station>();
    public static List<Station> line5 = new ArrayList<Station>();
    public static List<Station> line6 = new ArrayList<Station>();
    public static List<Station> line7 = new ArrayList<Station>();
    public static List<Station> line8 = new ArrayList<Station>();
    public static List<Station> line9 = new ArrayList<Station>();
    public static List<Station> line13 = new ArrayList<Station>();
    public static List<Station> line14 = new ArrayList<Station>();
    public static List<Station> lineAPM = new ArrayList<Station>();//APM
    public static List<Station> lineGF = new ArrayList<Station>();//广佛线

    public static LinkedHashSet<List<Station>> lineSet = new LinkedHashSet<>();//所有线集合


    public static int totalStaion = 0;//总的站点数量


    private DataBuilder(){

    }

    public static void init (String lineStr,List<Station> line,String lineName){
    }


    private static void getLine(String lineStr,List<Station> line,String lineName){
        String[] lineArr = lineStr.split("，");
        for (String s : lineArr) {
            line.add(new Station(s,lineName));
        }
    }

    static {
        String line1Str = "西朗，坑口，花地湾，芳村，黄沙，长寿路，陈家祠，西门口，公园前，农讲所，烈士陵园，东山口，杨箕，体育西路，体育中心，广州东站";
        String line2Str = "广州南站，石壁，会江，南浦，洛溪，南洲，东晓南，江泰路，昌岗，江南西，市二宫，海珠广场，公园前，纪念堂，越秀公园，广州火车站，三元里，飞翔公园，白云公园，白云文化广场，萧岗，江夏，黄边，嘉禾望岗";
        String line3Str = "番禺广场，市桥，汉溪长隆，大石，厦滘，沥滘，大塘，客村，广州塔，珠江新城，体育西路，石牌桥，岗顶，华师，五山，天河客运站";
        String line3NStr = "体育西路，林和西，广州东站，燕塘，梅花园，京溪南方医院，同和，永泰，白云大道北，嘉禾望岗，龙归，人和，高增，机场南，机场北";
        String line4Str = "南沙客运港，南横，塘坑，大涌，广隆，飞沙角，金洲，蕉门，黄阁，黄阁汽车城，庆盛，东涌，低涌，海傍，石碁，新造，大学城南，大学城北，官洲，万胜围，车陂南，车陂，黄村";
        String line5Str = "滘口，坦尾，中山八，西场，西村，广州火车站，小北，淘金，区庄，动物园，杨箕，五羊邨，珠江新城，猎德，潭村，员村，科韵路，车陂南，东圃，三溪，鱼珠，大沙地，大沙东，文冲";
        String line6Str = "浔峰岗，横沙，沙贝，河沙，坦尾，如意坊，黄沙，文化公园，一德路，海珠广场，北京路，团一大广场，团一大广场，东湖，东山口，区庄，黄花岗，沙河顶，天平架，燕塘，天河客运站，长湴，植物园，龙洞，柯木塱，高塘石，黄陂，金峰，暹岗，苏元，萝岗，香雪";
        String line7Str = "广州南站，石壁，谢村，钟村，汉溪长隆，南村万博，员岗，板桥，大学城南";
        String line8Str = "凤凰新村，沙园，宝岗大道，昌岗，晓港，中大，鹭江，客村，赤岗，磨碟沙，新港东，琶洲，万胜围";
        String line9Str = "飞鹅岭，花都汽车城，广州北站，花城路，花果山公园，花都广场，马鞍山公园，莲塘，清布，清塘，高增";
        String line13Str = "鱼珠，裕丰围，双岗，南海神庙，夏园，南岗，沙村，白江，新塘，官湖，新沙";
        String line14Str = "新和，红卫，新南，枫下，知识城，何棠下，旺村，汤村，镇龙北，镇龙";
        String lineAPMStr = "广州塔，海心沙，大剧院，花城大道，妇儿中心，黄埔大道，天河南，体育中心南，林和西";
        String lineGFStr = "新城东，东平，世纪莲，澜石，魁奇路，季华园，同济路，祖庙，普君北路，朝安，桂城，南桂路，礌岗，千灯湖，金融高新区，龙溪，菊树，西朗，鹤洞，沙涌，沙园，燕岗";

        getLine(line1Str,line1,"1");
        getLine(line2Str,line2,"2");
        getLine(line3Str,line3,"3");
        getLine(line3NStr,line3N,"3N");
        getLine(line4Str,line4,"4");
        getLine(line5Str,line5,"5");
        getLine(line6Str,line6,"6");
        getLine(line7Str,line7,"7");
        getLine(line8Str,line8,"8");
        getLine(line9Str,line9,"9");
        getLine(line13Str,line13,"13");
        getLine(line14Str,line14,"14");
        getLine(lineAPMStr,lineAPM,"APM");
        getLine(lineGFStr,lineGF,"GF");

        lineSet.add(line1);
        lineSet.add(line2);
        lineSet.add(line3);
        lineSet.add(line3N);
        lineSet.add(line4);
        lineSet.add(line5);
        lineSet.add(line6);
        lineSet.add(line7);
        lineSet.add(line8);
        lineSet.add(line9);
        lineSet.add(line13);
        lineSet.add(line14);
        lineSet.add(lineAPM);
        lineSet.add(lineGF);

        totalStaion = line1.size() + line2.size() + line3.size() + line4.size() + line5.size() + line6.size()
        + line7.size()+line8.size()+line9.size()+line13.size()+line14.size()+lineAPM.size()+lineGF.size();
        System.out.println("总的站点数量：" + totalStaion);
    }


}
