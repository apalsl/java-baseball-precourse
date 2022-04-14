package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}