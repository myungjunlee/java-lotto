package lotto.view;

public class OutputView {
    private static final String MESSAGE_PURCHASE = "개를 구매했습니다.";

    public static void printPurchaseCounts(int count) {
        System.out.println(count + MESSAGE_PURCHASE);
    }

}
