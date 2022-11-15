package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        List<String> lottoNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            lottoNumbers.add(Integer.toString(number));
        }

        return lottoNumbers.toString();
    }
}
