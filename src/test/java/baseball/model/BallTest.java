package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234"})
    @DisplayName("3자리가 아닌 숫자를 입력 시 예외 발생")
    void notMatchLength_ShouldReturnIllegalArgumentException(String input) {
        assertThatThrownBy(() -> new Ball(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 수를 입력하세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("입력하지 않거나 공백 입력 시 예외 발생")
    void isBlank_ShouldReturnIllegalArgumentException(String input) {
        assertThatThrownBy(() -> new Ball(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값을 입력하세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "ab1", "a1b", "1ab", "12a", "1 3", " 34", "   "})
    @DisplayName("숫자가 아닌 값을 입력 시 예외 발생")
    void notNumber_ShouldReturnIllegalArgumentException(String input) {
        assertThatThrownBy(() -> new Ball(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력하세요.");
    }

    @Test
    @DisplayName("입력한 값이 IntegerList로 저장됐는지 확인")
    void getBall_isIntegerList() {
        Ball ball = new Ball("159");
        List<Integer> integers = ball.getBall();

        assertThat(integers.size()).isEqualTo(3);
        assertThat(integers.get(0)).isEqualTo(1);
        assertThat(integers.get(1)).isEqualTo(5);
        assertThat(integers.get(2)).isEqualTo(9);
    }
}