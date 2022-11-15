package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.service.GameService;
import lotto.view.InputView;

import java.util.List;

public class GameController {
    public static void gameStart() {
        GameService gameService = new GameService();

        int inputPrice = InputView.getInputPrice();
        int purchasedCounts = gameService.getPurchaseCounts(inputPrice);
        Lottos purchasedLottos = gameService.issueLottos(purchasedCounts);

        List<Integer> inputWinningNumbers = InputView.getInputWinningNumbers();
        WinningNumbers winningNumbers = gameService.getWinningNumbers(inputWinningNumbers);

        int inputBonusNumber = InputView.getInputBonusNumber();
        BonusNumber bonusNumber = gameService.getBonusNumber(inputBonusNumber);
    }

}
