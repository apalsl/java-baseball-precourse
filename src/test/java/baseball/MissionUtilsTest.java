package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MissionUtilsTest {

    @Test
    @DisplayName("미션유틸의 랜덤숫자 생성 동작 테스트")
    void pickNumberInRangeTest() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        assertThat(randomNumber).isLessThan(10);
        assertThat(randomNumber).isGreaterThan(0);
    }

}
