package com.example.demo.Domain;

import org.springframework.data.annotation.Id;

/**
 * Created by XingLM on 2019/8/30.
 */
public class History {

    @Id
    private Long id;

    private String startTimestampt;

    private String endTimestampt;

    private String times;

    private String ip;

    private String domin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTimestampt() {
        return startTimestampt;
    }

    public void setStartTimestampt(String startTimestampt) {
        this.startTimestampt = startTimestampt;
    }

    public String getEndTimestampt() {
        return endTimestampt;
    }

    public void setEndTimestampt(String endTimestampt) {
        this.endTimestampt = endTimestampt;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDomin() {
        return domin;
    }

    public void setDomin(String domin) {
        this.domin = domin;
    }
}
