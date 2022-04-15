package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class BaseballGameTest {

    @DisplayName("결과가 항상 STRIKE, BALL, NOTHING 중 나타나는 것을 확인")
    @ParameterizedTest
    @ValueSource(strings = {"123","129","789","531","237","951"})
    void pitch_result_containsAnyOfBaseballScore(String input) {
        BaseballGame baseballGame = new BaseballGame();
        Map<BaseballScore, Integer> pitchResult = baseballGame.pitch(input);

        assertThat(pitchResult).isNotEmpty();
        assertThat(pitchResult.keySet())
                .containsAnyOf(BaseballScore.STRIKE, BaseballScore.BALL, BaseballScore.NOTHING);
    }

}