package com.example.nolan.golfappfyp;

public class listPutts {
    private String CompName;
    private int Putts;

    public listPutts() {
    }

    public listPutts(String compname, int putts) {
        this.CompName = compname;
        this.Putts = putts;
    }

    public String getCompName() {
        return CompName;
    }

    public void setCompName(String compname) {
        this.CompName = compname;
    }

    public int getPutts() {
        return Putts;
    }

    public void setPutts(int putts) {
        this.Putts = putts;
    }
}
