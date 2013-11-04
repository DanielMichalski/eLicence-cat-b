package model;

/**
 * Author: Daniel
 * Date: 03.11.13
 */
public class StandardQuestion {
    private String question;
    private YesOrNoAnswer anser;
    private int points;

    public StandardQuestion(String question, YesOrNoAnswer anser, int points) {
        this.question = question;
        this.anser = anser;
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public YesOrNoAnswer getAnser() {
        return anser;
    }

    public int getPoints() {
        return points;
    }
}
