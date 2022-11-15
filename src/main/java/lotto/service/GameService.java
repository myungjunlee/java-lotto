package lotto.service;

import lotto.domain.*;
import lotto.utils.NumberGenerator;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private static final int ONE_LOTTO_PRICE = 1000;

    public int getPurchaseCounts(int inputPrice) {
        int purchasedCounts = inputPrice / ONE_LOTTO_PRICE;
        OutputView.printPurchaseCounts(purchasedCounts);

        return purchasedCounts;
    }

    public Lottos issueLottos(int purchaseCounts) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCounts; i++) {
            Lotto lotto = new Lotto(NumberGenerator.generateRandomNumbers(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER, LOTTO_COUNT));
            lottos.add(lotto);
        }

        OutputView.printPurchaseLottos(lottos);

        return new Lottos(lottos);
    }

    public WinningNumbers getWinningNumbers(List<Integer> inputWinningNumbers) {
        return new WinningNumbers(inputWinningNumbers);
    }

    public BonusNumber getBonusNumber(int inputBonusNumber) {
        return new BonusNumber(inputBonusNumber);
    }

    public GameResult getPrizeResult(Lottos purchasedLottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        GameResult gameResult = new GameResult(purchasedLottos, winningNumbers, bonusNumber);

        OutputView.printStatistics(gameResult);

        return gameResult;
    }

    public void getEarningRate(GameResult gameResult, int inputPrice) {
        float earningRate = gameResult.getEarningRate(inputPrice);

        OutputView.printEarningRate(earningRate);
    }

}
