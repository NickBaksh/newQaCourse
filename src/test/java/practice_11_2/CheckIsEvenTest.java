package practice_11_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CheckIsEvenTest {

    private CheckIsEven checkIsEven;


    //Инициализация нового экземпляра класса перед каждым тестом
    @BeforeEach
    void setUp() {
        checkIsEven = new CheckIsEven();
    }


    //-----Проверка на чётность целых четных чисел (положительные, отрицательные, нулевое значение)------
    @ParameterizedTest
    @ValueSource(ints = {
            //Целые положительные чётные числа
            2, 6, 10, 144,
            //Максимальное целое отрицательное число
            Integer.MIN_VALUE,
            //Целые отрицательные чётные числа
            -6, - 18, -244,
            //Нулевое значение (тоже относится к четному)
            0
    })
    @DisplayName("Метод должен вернуть значение True для чётных целых чисел")
    public void shouldReturnTrueForEvenNumbers(int initialInt) {
        boolean actualResult = checkIsEven.isEven(initialInt);
        Assertions.assertTrue(actualResult);
    }




    //-----Проверка на чётность целых нечетных чисел (положительные, отрицательные)------
    @ParameterizedTest
    @ValueSource(ints = {
            //Целые положительные нечётные числа
            1, 7, 11, 145,
            //Максимальное целое положительное число
            Integer.MAX_VALUE,
            //Целые отрицательные нечётные числа
            -7, - 19, -543
    })
    @DisplayName("Метод должен вернуть значение False для нечётных целых чисел")
    public void shouldReturnFalseForOddNumbers(int initialInt) {
        boolean actualResult = checkIsEven.isEven(initialInt);
        Assertions.assertFalse(actualResult);
    }
}
