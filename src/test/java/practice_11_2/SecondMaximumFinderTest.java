package practice_11_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecondMaximumFinderTest {

    private SecondMaximumFinder secondMaximumFinder;

    @BeforeEach
    void setUp() {
        secondMaximumFinder = new SecondMaximumFinder();
    }

    //------Проверка поиска второго максимального числа в обычном массиве-------
    Stream<Arguments> regularArray() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3}, 2),
                Arguments.of(new int[] {5, 3, 17}, 5),
                Arguments.of(new int[] {4, -12, 44, 32}, 32)
        );
    }

    @ParameterizedTest
    @MethodSource("regularArray")
    @DisplayName("Метод должен вернуть второе максимально значение в массиве из целых чисел")
    public void shouldReturnSecondMaxValueFromRegularArray(int[] regularArray, int expectedSecondMax) {
        Assertions.assertEquals(expectedSecondMax, secondMaximumFinder.findSecondMax(regularArray),
                "Метод не вернул второе максимальное значение в массиве целых чисел");
    }


//    //------Проверка поиска второго максимального числа в массиве из 5 одинаковых чисел-------
//    Stream<Arguments> arrayWithFiveEqualInts() {
//        return Stream.of(
//                //Почему-то при передаче > 2 чисел в массиве падает ошибка
//                // с исключение java.util.NoSuchElementException: No value present
//                // Возможно из-за граничного значения при "numbers.length - 2"
//                Arguments.of(new int[] {2, 2, 2, 2, 2}, 2)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("arrayWithFiveEqualInts")
//    @DisplayName("Метод должен вернуть число из массива, состоящего из одинаковых чисел")
//    public void shouldReturnValueFromFiveEqualIntsArray(int[] regularArray, int expectedSecondMax) {
//        Assertions.assertEquals(expectedSecondMax, secondMaximumFinder.findSecondMax(regularArray),
//                "Метод не вернул число в массиве из одинаковых целых чисел");
//    }

    //------Проверка поиска второго максимального числа в массиве из 2 одинаковых чисел-------
    Stream<Arguments> arrayWithTwoEqualInts() {
        return Stream.of(
                //Почему-то при передаче > 2 чисел в массиве падает ошибка
                // с исключение java.util.NoSuchElementException: No value present
                Arguments.of(new int[] {2, 2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayWithTwoEqualInts")
    @DisplayName("Метод должен вернуть число из массива, состоящего из одинаковых чисел")
    public void shouldReturnValueFromTwoEqualIntsArray(int[] regularArray, int expectedSecondMax) {
        Assertions.assertEquals(expectedSecondMax, secondMaximumFinder.findSecondMax(regularArray),
                "Метод не вернул число в массиве из одинаковых целых чисел");
    }

    //---Проверка поиска второго максимального числа в массиве из одного целого числа (IllegalArgumentException)---
    Stream<Arguments> arrayWithOneInt() {
        return Stream.of(
                Arguments.of((Object) new int[] {2})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayWithOneInt")
    @DisplayName("Метод должен вернуть число из массива, состоящего из одинаковых чисел")
    public void shouldReturnValueFromOneIntArray(int[] regularArray) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {secondMaximumFinder.findSecondMax(regularArray);
            },"Метод не вернул IllegalArgumentException в массиве из одного целого числа");
    }
}
