package lotto.utils;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public static List<Integer> generateRandomNumbers(int startInclusive, int endInclusive, int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);

        return numbers;
    }
}
