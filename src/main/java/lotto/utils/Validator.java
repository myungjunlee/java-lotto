package lotto.utils;

public class Validator {
    private static final int UNIT_PRICE = 1000;
    private static final String ERROR_INPUT_PRICE_INTEGER = "가격은 정수만 입력 가능합니다.";
    private static final String ERROR_INPUT_PRICE_THOUSAND = "가격은 1,000원 단위만 입력 가능합니다.";

    public static int validatePrice(String inputPrice) {
        int convertedPrice = checkInteger(inputPrice);
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

    private static void checkThousand(int number) {
        if (number % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INPUT_PRICE_THOUSAND);
        }
    }

}
