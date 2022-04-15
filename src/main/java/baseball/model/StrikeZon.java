package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.model.BaseballConstants.*;

public class StrikeZon {

    private List<Integer> strikeZon;

    public StrikeZon(List<Integer> strikeZon) {
        this.strikeZon = strikeZon;
    }

    public static StrikeZon createStrikeZon() {
        Set<Integer> strikeZon = new HashSet<>();
        while (strikeZon.size() < BALL_LENGTH) {
            strikeZon.add(Randoms.pickNumberInRange(STRIKE_ZON_START, STRIKE_ZON_END));
        }
        return new StrikeZon(new ArrayList<>(strikeZon));
    }

    public List<Integer> getStrikeZon() {
        return this.strikeZon;
    }

    public Map<BaseballScore, Integer> matchUp(List<Integer> ball) {
        Map<BaseballScore, Integer> matchUpResultMap = new HashMap<>();
        for (int index = 0; index < ball.size(); index++) {
            BaseballScore result = this.checkStrike(index, ball.get(index));
            matchUpResultMap.put(result, matchUpResultMap.getOrDefault(result, 0) + 1);
        }

        return matchUpResultMap;
    }

    private BaseballScore checkStrike(int index, Integer ball) {
        if (this.strikeZon.get(index) == ball) {
            return BaseballScore.STRIKE;
        }

        if (this.strikeZon.contains(ball)) {
            return BaseballScore.BALL;
        }

        return BaseballScore.NOTHING;
    }
}
