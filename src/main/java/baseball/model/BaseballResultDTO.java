package baseball.model;

import java.util.Map;

public class BaseballResultDTO {

    private int strikeCount;

    private int ballCount;

    private int nothingCount;

    public BaseballResultDTO(Integer strikeCount, Integer ballCount, Integer nothingCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.nothingCount = nothingCount;
    }

    public static BaseballResultDTO from(Map<BaseballScore, Integer> baseballScoreIntegerMap) {
        return new BaseballResultDTO(
                baseballScoreIntegerMap.getOrDefault(BaseballScore.STRIKE, 0),
                baseballScoreIntegerMap.getOrDefault(BaseballScore.BALL, 0),
                baseballScoreIntegerMap.getOrDefault(BaseballScore.NOTHING, 0)
        );
    }

    public int getNothingCount() {
        return this.nothingCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isPerfectGame() {
        return this.strikeCount == BaseballConstants.BALL_LENGTH;
    }
}
