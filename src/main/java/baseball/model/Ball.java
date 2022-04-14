package baseball.model;

import java.util.Objects;

public class Ball {
    private static final int MATCH_LENGTH = 3;

    private String ball;

    public Ball(String ball) {
        if (isBlank(ball)) {
            throw new IllegalArgumentException("값을 입력하세요.");
        }
        if (isNotMatchSize(ball)) {
            throw new IllegalArgumentException("3자리 수를 입력하세요.");
        }
        if (isNotNumber(ball)) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
        this.ball = ball;
    }

    private boolean isBlank(String ball) {
        return Objects.isNull(ball) || ball.isEmpty();
    }

    private boolean isNotMatchSize(String ball) {
        return ball.length() != MATCH_LENGTH;
    }

    private boolean isNotNumber(String ball) {
        return !ball.matches("[+-]?\\d*(\\.\\d+)?");
    }
}
