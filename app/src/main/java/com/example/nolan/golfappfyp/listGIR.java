package com.example.nolan.golfappfyp;

public class listGIR {
    private String CompName;
    private int GIR;

    public listGIR() {
    }

    public listGIR(String compname, int gir) {
        this.CompName = compname;
        this.GIR = gir;
    }

    public String getCompName() {
        return CompName;
    }

    public void setCompName(String compname) {
        this.CompName = compname;
    }

    public int getGIR() {
        return GIR;
    }

    public void setGIR(int gir) {
        this.GIR = gir;
    }
}
