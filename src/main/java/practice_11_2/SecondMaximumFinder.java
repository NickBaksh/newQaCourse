package practice_11_2;

import java.util.Arrays;

public class SecondMaximumFinder {

    // Метод вычисляет второе максимальное число в массиве
    public int findSecondMax(int[] numbers) {
        return Arrays.stream(numbers).distinct().sorted().skip(numbers.length - 2).findFirst().orElseThrow();
    }
}
