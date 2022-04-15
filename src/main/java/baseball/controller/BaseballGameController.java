package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballResultDTO;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private InputView inputView;
    private OutputView outputView;
    private BaseballGame baseballGame;

    public BaseballGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        baseballGame = new BaseballGame();
    }

    public void start() {
        BaseballResultDTO baseballResult = BaseballResultDTO.from(baseballGame.pitch(inputView.inputNumber()));
        outputView.showResult(baseballResult);

        if (baseballResult.isPerfectGame()) {
            outputView.showPerfect();
            this.selectNewGame();
            return;
        }

        this.start();
    }

    private void selectNewGame() {
        String isNewGame = inputView.inputNewGame();
        if (isNewGame.equals("1")) {
            restart();
            return;
        }

        outputView.showEnd();
    }

    private void restart() {
        this.baseballGame.reset();
        this.start();
    }

}
