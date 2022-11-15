package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {
    private static final String MESSAGE_INPUT_PRICE = "구입금액을 입력해 주세요.";

    public static int getInputPrice() {
        try {
            System.out.println(MESSAGE_INPUT_PRICE);
            return Validator.validatePrice(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

}
