package lotto.utils;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public static List<Integer> generateRandomNumbers(int minNumber, int maxNumber, int digit) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, digit);

        return numbers;
    }
}
