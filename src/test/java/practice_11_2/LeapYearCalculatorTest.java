package practice_11_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LeapYearCalculatorTest {

    private LeapYearCalculator leapYearCalculator;

    @BeforeEach
    void setUp() {
        leapYearCalculator = new LeapYearCalculator();
    }


    //-------Проверка получения True при передаче високосного года--------
    @ParameterizedTest
    @ValueSource(ints = {
            // Високосные годы
            2020, 2000, 1600
    })
    @DisplayName("Метод должен вернуть значение true для високосного года")
    public void shouldReturnTrueForLeapYear(int initialYear) {
        Assertions.assertTrue(leapYearCalculator.isLeapYear(initialYear),
                "Метод не вернул True для високосного года");
    }

    //-------Проверка получения False при передаче невисокосного года--------
    @ParameterizedTest
    @ValueSource(ints = {
            // Невисокосные годы
            2031, 1961, 1949, 2023
    })
    @DisplayName("Метод должен вернуть значение false для невисокосного года")
    public void shouldReturnFalseForNonLeapYear(int initialYear) {
        Assertions.assertFalse(leapYearCalculator.isLeapYear(initialYear),
                "Метод не вернул False для невисокосного года");
    }


    //-------Проверка получения False при передаче невисокосных лет, которые делятся на 100, но не на 400------
    @ParameterizedTest
    @ValueSource(ints = {
            // Годы, которые делятся на 100, но не 400
            1900, 2100
    })
    @DisplayName("Метод должен вернуть значение false для невисокосных лет, которые делятся на 100, но не 400")
    public void shouldReturnTrueForYear(int initialYear) {
        Assertions.assertFalse(leapYearCalculator.isLeapYear(initialYear),
                "Метод не вернул False для лет, которые делятся на 100, но не 400");
    }
}
