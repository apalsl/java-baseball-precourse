package baseball.controller;

import baseball.model.BaseballGame;
import baseball.view.InputView;

public class BaseballGameController {

    private InputView inputView;
    private BaseballGame baseballGame;

    public BaseballGameController() {
        inputView = new InputView();
        baseballGame = new BaseballGame();
    }

    public void start() {
        String userInput = inputView.inputNumber();

        baseballGame.pitch(userInput);
    }
}
