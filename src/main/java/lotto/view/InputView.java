package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

import java.util.List;

public class InputView {
    private static final String MESSAGE_INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public static int getInputPrice() {
        try {
            System.out.println(MESSAGE_INPUT_PRICE);
            return Validator.validatePrice(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> getInputWinningNumbers() {
        try {
            System.out.println();
            System.out.println(MESSAGE_INPUT_WINNING_NUMBERS);
            return Validator.validateWinningNumbers(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

}
