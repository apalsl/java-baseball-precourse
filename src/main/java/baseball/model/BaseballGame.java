package baseball.model;

public class BaseballGame {

    private Ball ball;

    public String pitch(String ball) {
        this.ball = new Ball(ball);

        return "";
    }


}
