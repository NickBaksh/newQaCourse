package practice_11_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidNumberCheckerTest {

    private ValidNumberChecker validNumberChecker;

    @BeforeEach
    void setUp() {
        validNumberChecker = new ValidNumberChecker();
    }

    //------Проверка что для валидного номера возвращается True--------
    @ParameterizedTest
    @ValueSource(strings = {
            //Корректные номера
            "+1 1234567890", "+7 9991112233", "+234 3231245644"
    })
    @DisplayName("Метод должен вернуть True для валидного номера")
    public void shouldReturnTrueForValidNumber(String initialNumber) {
        Assertions.assertTrue(validNumberChecker.isValidPhoneNumber(initialNumber),
                "Метод не вернул True для валидного номера");
    }


    //------Проверка что для невалидного номера возвращается False--------
    @ParameterizedTest
    @ValueSource(strings = {
            //Некорректные номера (проверка граничных значений)
            "+ 1234567890", "+7 99911122332", "+122 323124564", "+2454 9991112233", "random"
    })
    @DisplayName("Метод должен вернуть False для невалидного номера")
    public void shouldReturnFalseForInvalidNumber(String initialNumber) {
        Assertions.assertFalse(validNumberChecker.isValidPhoneNumber(initialNumber),
                "Метод не вернул False для невалидного номера");
    }
}
