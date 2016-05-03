package edu.missouriwestern.aambrosius.retrobejewled;

/**
 * Created by Ambrosius on 3/1/2016.
 */
public class HighScores {
    int score;
    String initial;

    public HighScores() {

    }

    public HighScores(int score, String initial) {
        this.score = score;
        this.initial = initial;
    }

    public int getScore() {
        return this.score;
    }

    public String getInitial() {
        return this.initial;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }
}
