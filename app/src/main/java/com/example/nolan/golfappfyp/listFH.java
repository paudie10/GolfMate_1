package com.example.nolan.golfappfyp;

public class listFH {
    private String CompName;
    private int FH;

    public listFH() {
    }

    public listFH(String compname, int fh) {
        this.CompName = compname;
        this.FH = fh;
    }

    public String getCompName() {
        return CompName;
    }

    public void setCompName(String compname) {
        this.CompName = compname;
    }

    public int getFH() {
        return FH;
    }

    public void setFH(int fh) {
        this.FH = fh;
    }
}
