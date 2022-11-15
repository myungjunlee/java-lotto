package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.GameService;
import lotto.view.InputView;

public class GameController {
    public static void gameStart() {
        GameService gameService = new GameService();

        int inputPrice = InputView.getInputPrice();
        int purchasedCounts = gameService.getPurchaseCounts(inputPrice);
        Lottos purchasedLottos = gameService.issueLottos(purchasedCounts);
    }

}
