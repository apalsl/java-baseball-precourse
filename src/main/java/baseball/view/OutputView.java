package baseball.view;

import baseball.model.BaseballResultDTO;

public class OutputView {
    private final static int PULL_COUNT = 3;
    public void showResult(BaseballResultDTO baseballResultDTO) {
        if (baseballResultDTO.getNothingCount() == PULL_COUNT) {
            System.out.println("낫싱");
            return;
        }
        if (baseballResultDTO.getBallCount() != 0) {
            System.out.print(baseballResultDTO.getBallCount() + "볼 ");
        }
        if (baseballResultDTO.getStrikeCount() != 0) {
            System.out.print(baseballResultDTO.getStrikeCount() + "스트라이크");
        }
        System.out.println();
    }

    public void showPerfect() {
        System.out.println("3개의 숫자르 모두 맞히셨습니다! 게임 종료");
    }

    public void showEnd() {
        System.out.println("게임 종료");
    }
}
