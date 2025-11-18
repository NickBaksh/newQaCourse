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
public class FactorialCalculatorTest {

    private FactorialCalculator factorialCalculator;

    @BeforeEach
    void setUp() {
        factorialCalculator = new FactorialCalculator();
    }

    //-------Проверка вычисления факториала для 0
    Stream<Arguments> factorialFromZero() {
        return Stream.of(
                // Проверяем факториал от нуля
                Arguments.of(0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("factorialFromZero")
    @DisplayName("Метод вычисляет факториал от числа 0")
    public void shouldReturnFactorialFromZero(int initialInt, int expectedResult) {
        Assertions.assertEquals(expectedResult, factorialCalculator.factorial(initialInt),
                "Для факториала 0! вернулся результат != 1");
    }


    //-------Проверка вычисления факториала для маленьких положительных чисел
    Stream<Arguments> factorialFromPositiveInts() {
        return Stream.of(
                // Маленькие положительные целые числа
                Arguments.of(1, 1),
                Arguments.of(5, 120),
                Arguments.of(7, 5040)
        );
    }

    @ParameterizedTest
    @MethodSource("factorialFromPositiveInts")
    @DisplayName("Метод вычисляет факториал от положительных целых чисел")
    public void shouldReturnFactorialFromPositiveInts(int initialInt, int expectedResult) {
        Assertions.assertEquals(expectedResult, factorialCalculator.factorial(initialInt),
                "Для факториала целого положительного числа вернулся некорректный результат вычисления");
    }

    //-------Проверка вычисления факториала для отрицательных чисел
    Stream<Arguments> factorialFromNegativeInts() {
        return Stream.of(
                // Маленькие отрицательные целые числа
                Arguments.of(-5),
                Arguments.of(-7)
        );
    }

    @ParameterizedTest
    @MethodSource("factorialFromNegativeInts")
    @DisplayName("Метод вычисляет факториал от положительных целых чисел")
    public void shouldReturnFactorialFromNegativeInts(int initialInt) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {factorialCalculator.factorial(initialInt);
        }, "Метод не вернул IllegalArgumentException при передаче отрицательного числа в аргумент");
    }

}
