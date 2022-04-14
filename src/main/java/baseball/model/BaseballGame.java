package baseball.model;


public class BaseballGame {

    private Ball ball;

    private StrikeZon strikeZon;

    public BaseballGame() {
        this.strikeZon = new StrikeZon();
    }

    public String pitch(String ball) {
        this.ball = new Ball(ball);

        return "";
    }


}
