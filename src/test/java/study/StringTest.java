package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String 스플릿 동작 테스트")
    void splitMethodTest() {
        String case1 = "1,2";
        String[] splitResult = case1.split(",");
        assertThat(splitResult).contains("1","2");
        assertThat(splitResult).containsExactly("1","2");

        String case2 = "1";
        String[] splitResult2 = case2.split(",");
        assertThat(splitResult2).contains("1");
        assertThat(splitResult2).containsExactly("1");
    }

    @Test
    @DisplayName("String substring 동작 테스트")
    void substringMethodTest() {
        //given
        String input = "(1,2)";

        //when
        String substringResult = input.substring(1, input.length() - 1);

        //then
        assertThat(substringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt 동작 테스트")
    void charAtMethodTest() {
        //given
        String input = "abc";

        //when
        char index = input.charAt(0);

        //then
        assertThat(index).isEqualTo('a');
    }

    @Test
    @DisplayName("String chatAt 예외 테스트")
    void charAtExceptionTest() {
        //given
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }

}
