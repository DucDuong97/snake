package de.unikl.seda.snake.highscore;

import java.io.Serializable;

public class HighScore implements Serializable {
    private String playerName;
    private int ranking;
    private int achievedPoints;
    private String date;
    private int speed;
    private String level;

    public HighScore(String playerName, int ranking, int achievedPoints, String date, int speed, String level) {
        this.playerName = playerName;
        this.ranking = ranking;
        this.achievedPoints = achievedPoints;
        this.date = date;
        this.speed = speed;
        this.level = level;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getAchievedPoints() {
        return achievedPoints;
    }

    public void setAchievedPoints(int achievedPoints) {
        this.achievedPoints = achievedPoints;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
