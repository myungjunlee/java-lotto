package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String MESSAGE_PURCHASE = "개를 구매했습니다.";
    private static final String WINNING_STATISTIC = "당첨 통계";
    private static final String OUTLINE = "---";
    private static final String STATISTICS_PRIZE_MESSAGE = "개 일치 (";
    private static final String STATISTICS_SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (";
    private static final String STATISTICS_WON_MESSAGE = "원) - ";
    private static final String STATISTICS_COUNT_MESSAGE = "개";
    private static final String EARNING_RATE_START_MESSAGE = "총 수익률은 ";
    private static final String EARNING_RATE_END_MESSAGE = "%입니다.";

    public static void printPurchaseCounts(int count) {
        System.out.println();
        System.out.println(count + MESSAGE_PURCHASE);
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printStatistics(GameResult gameResult) {
        System.out.println(System.lineSeparator() + WINNING_STATISTIC);
        System.out.println(OUTLINE);

        Map<Rank, Integer> result = gameResult.getGameResult();

        for (Rank winnerPrice : gameResult.sortedPriceKeySet()) {
            printEachStatistic(winnerPrice, result);
        }
    }

    public static void printEarningRate(float earningRate) {
        System.out.println(EARNING_RATE_START_MESSAGE + earningRate + EARNING_RATE_END_MESSAGE);
    }

    private static void printEachStatistic(Rank winnerPrize, Map<Rank, Integer> result) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        String prize = decFormat.format(winnerPrize.getPrize());

        if (winnerPrize == Rank.SECOND) {
            System.out.print(STATISTICS_SECOND_PRIZE_MESSAGE + prize + STATISTICS_WON_MESSAGE
                    + result.get(winnerPrize) + STATISTICS_COUNT_MESSAGE + System.lineSeparator());
            return;
        }

        System.out.print(winnerPrize.getMatched() + STATISTICS_PRIZE_MESSAGE + prize + STATISTICS_WON_MESSAGE
                + result.get(winnerPrize) + STATISTICS_COUNT_MESSAGE + System.lineSeparator());
    }

}
