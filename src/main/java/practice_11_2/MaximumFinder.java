package practice_11_2;

import java.util.Arrays;

public class MaximumFinder {

    // Метод возвращает максимальное значение из массива целых чисел
    public int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }
}
