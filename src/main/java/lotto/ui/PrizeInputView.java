package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrizeInputView {
    private String value;

    public PrizeInputView(String inputValue) {
        validation(inputValue);
        this.value = inputValue;
    }

    private void validation(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException("Input value must not null");
        }

        if (inputValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Input value must not empty");
        }
    }

    public static PrizeInputView create(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new PrizeInputView(scanner.nextLine());
    }

    public List<Integer> convertToIntCollection() {
        return Arrays.asList(this.value.split(","))
                .stream()
                .map(inputValue -> Integer.parseInt(inputValue.trim()))
                .collect(Collectors.toList());
    }
}
