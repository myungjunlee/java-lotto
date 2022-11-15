package lotto.service;

import lotto.view.OutputView;

public class GameService {
    private static final int ONE_LOTTO_PRICE = 1000;

    public int getPurchaseCounts(int inputPrice) {
        OutputView.printPurchaseCounts(inputPrice);

        return inputPrice / ONE_LOTTO_PRICE;
    }
}
