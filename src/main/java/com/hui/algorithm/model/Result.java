package com.hui.algorithm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <b><code>Result</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/7/24 14:56.
 *
 * @author huweihui
 * @since hui_project 1.0.0
 */
public class Result {
    /**
     * 开始站点.
     *
     * @since hui_project 1.0.0
     */
    private Station star;
    /**
     * 结束站点.
     *
     * @since hui_project 1.0.0
     */
    private Station end;
    /**
     * 两个站点距离.
     *
     * @since hui_project 1.0.0
     */
    private Double distance = 0.0D;
    /**
     * 中间经过站点.
     *
     * @since hui_project 1.0.0
     */
    private List<Station> passStations = new ArrayList<>();


    /**
     * Gets star.
     *
     * @return the star
     * @since hui_project 1.0.0
     */
    public Station getStar() {
        return star;
    }

    /**
     * Sets star.
     *
     * @param star the star
     * @since hui_project 1.0.0
     */
    public void setStar(Station star) {
        this.star = star;
    }

    /**
     * Gets end.
     *
     * @return the end
     * @since hui_project 1.0.0
     */
    public Station getEnd() {
        return end;
    }

    /**
     * Sets end.
     *
     * @param end the end
     * @since hui_project 1.0.0
     */
    public void setEnd(Station end) {
        this.end = end;
    }

    /**
     * Gets distance.
     *
     * @return the distance
     * @since hui_project 1.0.0
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * Sets distance.
     *
     * @param distance the distance
     * @since hui_project 1.0.0
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * Gets pass stations.
     *
     * @return the pass stations
     * @since hui_project 1.0.0
     */
    public List<Station> getPassStations() {
        return passStations;
    }

    /**
     * Sets pass stations.
     *
     * @param passStations the pass stations
     * @since hui_project 1.0.0
     */
    public void setPassStations(List<Station> passStations) {
        this.passStations = passStations;
    }

    /**
     * Instantiates a new Result.
     *
     * @param star     the star
     * @param end      the end
     * @param distance the distance
     */
    public Result(Station star, Station end, Double distance) {
        this.star = star;
        this.end = end;
        this.distance = distance;
    }

    /**
     * Instantiates a new Result.
     */
    public Result() {

    }

    @Override
    public String toString() {
        return "Result{" +
                "star=" + star +
                ", end=" + end +
                ", distance=" + distance +
                ", passStations=" + passStations +
                '}';
    }
}
