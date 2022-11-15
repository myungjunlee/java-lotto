package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private static final int UNIT_PRICE = 1000;
    private static final String LOTTO_NUMBER_DELIMITER = ", |,";
    private static final String ERROR_INPUT_PRICE_INTEGER = "[ERROR] 구입 금액은 정수여야 합니다.";
    private static final String ERROR_INPUT_PRICE_POSITIVE = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String ERROR_INPUT_PRICE_THOUSAND = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String ERROR_INPUT_WINNING_NUMBER_COUNT = "[ERROR] 로또 번호는 6개의 번호를 입력해줘야 합니다.";
    private static final String ERROR_INPUT_BONUS_NUMBER_COUNT = "[ERROR] 보너스 번호는 1개의 번호를 입력해줘야 합니다.";
    private static final String ERROR_INPUT_NUMBER_INTEGER = "[ERROR] 로또 번호는 정수여야 합니다.";
    private static final String ERROR_INPUT_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_INPUT_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

    public static int validatePrice(String inputPrice) {
        int convertedPrice = checkInteger(inputPrice, ERROR_INPUT_PRICE_INTEGER);
        checkPositive(convertedPrice);
        checkThousand(convertedPrice);

        return convertedPrice;
    }

    public static List<Integer> validateWinningNumbers(String inputNumbers) {
        List<String> splitNumbers = Arrays.asList(inputNumbers.split(LOTTO_NUMBER_DELIMITER));
        List<Integer> convertedNumbers = checkIntegers(splitNumbers);
        checkCounts(convertedNumbers);
        checkRange(convertedNumbers);

        return convertedNumbers;
    }

    private static int checkInteger(String number, String message) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void checkPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_INPUT_PRICE_POSITIVE);
        }
    }

    private static void checkThousand(int number) {
        if (number % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INPUT_PRICE_THOUSAND);
        }
    }

    private static List<Integer> checkIntegers(List<String> numbers) {
        return numbers.stream()
                .map(number -> checkInteger(number, ERROR_INPUT_NUMBER_INTEGER))
                .collect(Collectors.toList());
    }

    private static void checkCounts(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ERROR_INPUT_WINNING_NUMBER_COUNT);
        }
    }

    private static void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if ((number < MINIMUM_NUMBER) || (number > MAXIMUM_NUMBER)) {
                throw new IllegalArgumentException(ERROR_INPUT_NUMBER_RANGE);
            }
        }
    }


}
