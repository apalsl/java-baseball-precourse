package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class StrikeZon {
    private final static int STRIKE_ZON_START = 1;
    private final static int STRIKE_ZON_END = 9;
    private final static int STRIKE_ZON_SIZE = 3;

    private final List<Integer> strikeZon;

    public StrikeZon() {
        this.strikeZon = Randoms.pickUniqueNumbersInRange(STRIKE_ZON_START, STRIKE_ZON_END, STRIKE_ZON_SIZE);
    }

    public List<Integer> getStrikeZon() {
        return this.strikeZon;
    }
}
