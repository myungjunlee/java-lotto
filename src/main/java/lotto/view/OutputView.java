package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class OutputView {
    private static final String MESSAGE_PURCHASE = "개를 구매했습니다.";

    public static void printPurchaseCounts(int count) {
        System.out.println();
        System.out.println(count + MESSAGE_PURCHASE);
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
