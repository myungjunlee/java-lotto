package lotto.utils;

public class Validator {
    private static final int UNIT_PRICE = 1000;
    private static final String ERROR_INPUT_PRICE_INTEGER = "[ERROR] 구입 금액은 정수여야 합니다.";
    private static final String ERROR_INPUT_PRICE_POSITIVE = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String ERROR_INPUT_PRICE_THOUSAND = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    public static int validatePrice(String inputPrice) {
        int convertedPrice = checkInteger(inputPrice);
        checkPositive(convertedPrice);
        checkThousand(convertedPrice);

        return convertedPrice;
    }

    private static int checkInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_PRICE_INTEGER);
        }
    }

    private static void checkPositive(int number) {
        if (number > 0) {
            throw new IllegalArgumentException(ERROR_INPUT_PRICE_POSITIVE);
        }
    }

    private static void checkThousand(int number) {
        if (number % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INPUT_PRICE_THOUSAND);
        }
    }

}
