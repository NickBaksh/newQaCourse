package practice_11_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MaximumFinderTest {

    private MaximumFinder maximumFinder;

    @BeforeEach
    void setUp() {
        maximumFinder = new MaximumFinder();
    }

    //----Проверка кейса с массивом из положительных целых чисел-------
    Stream<Arguments> regularArray() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4}, 4),
                Arguments.of(new int[] {7, 12, 1, 9}, 12),
                Arguments.of(new int[] {5, 0, 13, 4}, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("regularArray")
    @DisplayName("Метод должен вернуть максимальное значение из массива с целыми положительными числами")
    public void shouldFindMaxValueInRegularArray(int[] initialArray, int expectedResult) {
        Assertions.assertEquals(expectedResult, maximumFinder.findMax(initialArray),
                "Метод не вернул максимальное целое число из массива положительных чисел");
    }

    //----Проверка кейса с массивом из одного целого числа-------
    Stream<Arguments> arrayWithOneValue() {
        return Stream.of(
                Arguments.of(new int[] {4}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayWithOneValue")
    @DisplayName("Метод должен вернуть максимальное значение из массива состоящим из одного целого числа")
    public void shouldFindMaxValueInArrayWithOneInt(int[] initialArray, int expectedResult) {
        Assertions.assertEquals(expectedResult, maximumFinder.findMax(initialArray),
                "Метод не вернул максимальное значение для массива из одного целого числа");
    }

    //----Проверка кейса с массивом из отрицательных чисел-------
    Stream<Arguments> arrayWithNegativeValues() {
        return Stream.of(
                Arguments.of(new int[] {-15, -543, -112, -1}, -1),
                Arguments.of(new int[] {-25, -23, -112, -1412}, -23),
                Arguments.of(new int[] {-94, -12, -543, -221}, -12)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayWithNegativeValues")
    @DisplayName("Метод должен вернуть максимальное значение из массива с целыми отрицательными числами")
    public void shouldFindMaxValueInArrayWithNegativeInts(int[] initialArray, int expectedResult) {
        Assertions.assertEquals(expectedResult, maximumFinder.findMax(initialArray),
                "Метод не вернул максимальное значение для массива из отрицательных целых чисел");
    }


    //----Проверка кейса с пустым массивом (выброс исключения)-------
    static Stream<Arguments> emptyArray() {
        return Stream.of(
                Arguments.of((Object) new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("emptyArray")
    @DisplayName("Метод должен вернуть максимальное значение из массива с целыми отрицательными числами")
    public void shouldFindMaxValueInEmptyArray(int[] initialArray) {
        Assertions.assertThrows(NoSuchElementException.class, () -> {maximumFinder.findMax(initialArray);
            }, "При вызове метода с пустым массивом не вернулся NoSuchElementException");
    }
}
