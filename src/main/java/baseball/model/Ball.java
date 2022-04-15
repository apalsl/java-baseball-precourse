package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ball {

    private List<Integer> ball;

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

        this.ball = parseIntegerList(ball);
    }

    private List<Integer> parseIntegerList(String ball) {
        List<Integer> ballNumbers = new ArrayList<>(BaseballConstants.BALL_LENGTH);
        for (int index = 0; index < BaseballConstants.BALL_LENGTH; index++) {
            ballNumbers.add(Character.getNumericValue(ball.charAt(index)));
        }
        return ballNumbers;
    }

    private boolean isBlank(String ball) {
        return Objects.isNull(ball) || ball.isEmpty();
    }

    private boolean isNotMatchSize(String ball) {
        return ball.length() != BaseballConstants.BALL_LENGTH;
    }

    private boolean isNotNumber(String ball) {
        return !ball.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public List<Integer> getBall() {
        return this.ball;
    }
}
