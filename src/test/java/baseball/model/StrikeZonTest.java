package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeZonTest {

    @Test
    @DisplayName("스트라이크존 범위가 1~9이며 사이즈가 3인것을 확인함")
    void strikeZon_valid() {
        StrikeZon strikeZon = StrikeZon.createStrikeZon();
        List<Integer> integers = strikeZon.getStrikeZon();

        assertThat(integers.size()).isEqualTo(3);
        assertThat(integers).doesNotContain(0,10);
        assertThat(integers).doesNotHaveDuplicates();
    }

}