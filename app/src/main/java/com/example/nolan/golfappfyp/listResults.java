package com.example.nolan.golfappfyp;

public class listResults {
    private String Name;
    private int Score;

    public listResults() {
    }

    public listResults(String name, int score) {
        this.Name = name;
        this.Score = score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        this.Score = score;
    }
}
