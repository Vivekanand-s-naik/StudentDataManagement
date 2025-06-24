package com.main.models;

public class stData {
    private int stId;
    private String name;
    private int percent;
    private String cource;
    
    public stData(int stId, String name, int percent, String cource) {
        this.stId = stId;
        this.name = name;
        this.percent = percent;
        this.cource = cource;
    }

    // Getters and Setters
    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    @Override
    public String toString() {
        return "stData [stId=" + stId + ", name=" + name + ", percent=" + percent + ", cource=" + cource + "]";
    }

    
}
