package com.hui.algorithm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <b><code>Station</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/7/19 16:40.
 *
 * @author huweihui
 * @since metrodev2 0.1.0
 */
public class Station {
    private String name;
    private String line;
    private List<Station> linkStations = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public List<Station> getLinkStations() {
        return linkStations;
    }

    public void setLinkStations(List<Station> linkStations) {
        this.linkStations = linkStations;
    }

    public Station(String name, String line) {
        this.name = name;
        this.line = line;
    }

    public Station(String name) {
        this.name = name;
    }

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
