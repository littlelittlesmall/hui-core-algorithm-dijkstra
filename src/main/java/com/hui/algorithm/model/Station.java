package com.hui.algorithm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <b><code>Station</code></b>
 * <p/>
 * Description:站点距离
 * <p/>
 * <b>Creation Time:</b> 2018/7/19 16:40.
 *
 * @author huweihui
 * @since metrodev2 0.1.0
 */
public class Station {
    /**
     * 站点名字.
     *
     * @since hui_project 1.0.0
     */
    private String name;
    /**
     * 所属线路.
     *
     * @since hui_project 1.0.0
     */
    private String line;
    /**
     * 相邻连接站点.
     *
     * @since hui_project 1.0.0
     */
    private List<Station> linkStations = new ArrayList<>();

    /**
     * Gets name.
     *
     * @return the name
     * @since hui_project 1.0.0
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @since hui_project 1.0.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets line.
     *
     * @return the line
     * @since hui_project 1.0.0
     */
    public String getLine() {
        return line;
    }

    /**
     * Sets line.
     *
     * @param line the line
     * @since hui_project 1.0.0
     */
    public void setLine(String line) {
        this.line = line;
    }

    /**
     * Gets link stations.
     *
     * @return the link stations
     * @since hui_project 1.0.0
     */
    public List<Station> getLinkStations() {
        return linkStations;
    }

    /**
     * Sets link stations.
     *
     * @param linkStations the link stations
     * @since hui_project 1.0.0
     */
    public void setLinkStations(List<Station> linkStations) {
        this.linkStations = linkStations;
    }

    /**
     * Instantiates a new Station.
     *
     * @param name the name
     * @param line the line
     */
    public Station(String name, String line) {
        this.name = name;
        this.line = line;
    }

    /**
     * Instantiates a new Station.
     *
     * @param name the name
     */
    public Station(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Station.
     */
    public Station (){

    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if(obj instanceof Station){
            Station s = (Station) obj;
            if(s.getName().equals(this.getName())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", line='" + line + '\'' +
                ", linkStations=" + linkStations +
                '}';
    }
}
