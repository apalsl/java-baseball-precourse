package baseball.model;


import java.util.Map;

public class BaseballGame {

    private Ball ball;

    private StrikeZon strikeZon;

    public BaseballGame() {
        this.strikeZon = StrikeZon.createStrikeZon();
    }

    public Map<BaseballScore, Integer> pitch(String ball) {
        this.ball = new Ball(ball);

        return matchUp();
    }

    private Map<BaseballScore, Integer> matchUp() {
        return this.strikeZon.matchUp(this.ball.getBall());
    }

    public void reset() {
        this.strikeZon = StrikeZon.createStrikeZon();
    }
}
