package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class GameResult {
    private static final int BONUS_CONFIRMATION_CRITERIA = 5;

    private final Map<Rank, Integer> gameResult;

    public GameResult(Lottos lottos, WinningNumbers winningNumber, BonusNumber bonusNumber) {
        this.gameResult = new HashMap<>();
        initResult();
        calculateResult(lottos, winningNumber, bonusNumber);
    }

    public Map<Rank, Integer> getGameResult() {
        return gameResult;
    }

    public List<Rank> sortedPriceKeySet() {
        return gameResult.keySet().stream()
                .filter(winnerPrice -> winnerPrice != Rank.FAIL)
                .sorted(Comparator.comparing(Rank::getPrize))
                .collect(Collectors.toList());
    }

    public float getEarningRate(int inputMoney) {
        float earningRate = (float) totalPrize() / inputMoney * 100;

        return (float) (Math.round(earningRate * 10) / 10.0);
    }

    private void initResult() {
        Rank.getWinnerPrizes()
                .forEach(winnerPrize -> gameResult.put(winnerPrize, 0));
    }

    private void calculateResult(Lottos lottos, WinningNumbers winningNumber, BonusNumber bonusNumber) {
        List<Lotto> multipleLottos= lottos.getLottos();

        for (Lotto lotto : multipleLottos) {
            Rank winnerPrice = calculateRank(lotto, winningNumber, bonusNumber);
            updatePrizeResult(winnerPrice);
        }
    }

    private Rank calculateRank(Lotto lotto, WinningNumbers winningNumber, BonusNumber bonusNumber) {
        final int matched = matchedRegularNumbers(lotto, winningNumber);
        boolean hasBonus = false;

        if (matched == BONUS_CONFIRMATION_CRITERIA) {
            hasBonus = hasMatchedNumber(lotto, bonusNumber.getBonusNumber());
        }

        return Rank.getWinnerPrizeByMatched(matched, hasBonus);
    }

    private int matchedRegularNumbers(Lotto lotto, WinningNumbers winningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        return (int) winningNumber.getWinningNumbers().stream()
                .filter(lottoNumbers::contains).count();
    }

    private boolean hasMatchedNumber(Lotto lotto, int number) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        return lottoNumbers.contains(number);
    }

    private void updatePrizeResult(Rank winnerPrice) {
        gameResult.put(winnerPrice, gameResult.get(winnerPrice) + 1);
    }

    private int totalPrize() {
        int totalPrize = 0;

        for (Rank winnerPrice : gameResult.keySet()) {
            totalPrize += winnerPrice.getPrize() * gameResult.get(winnerPrice);
        }

        return totalPrize;
    }

}
