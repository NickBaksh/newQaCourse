package practice_11_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class EmailValidatorTest {

    private EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }


    //---------Проверка получения True для валидного email--------
    @ParameterizedTest
    @ValueSource(strings = {
            // Валидные email
            "sravniEmail@gmail.com", "nick.basksh@gg.bz", "vovan1993@mail.ru"
    })
    @DisplayName("Метод должен вернуть значение true для валидного email")
    public void shouldReturnTrueForValidEmail(String initialEmail) {
        Assertions.assertTrue(emailValidator.isValidEmail(initialEmail),
                "Метод не вернул true для валидного email");
    }


    //---------Проверка получения False для невалидного email--------
    @ParameterizedTest
    @ValueSource(strings = {
            // Невалидные email
            "12@dd.1", "//blick@sssravni.dd", "Peetr.@ds"
    })
    @DisplayName("Метод должен вернуть значение false для невалидного email")
    public void shouldReturnFalseForInvalidEmail(String initialEmail) {
        Assertions.assertFalse(emailValidator.isValidEmail(initialEmail),
                "Метод не вернул false для невалидного email");
    }


    //---------Проверка получения False при передаче null вместо email-------
    @Test
    @DisplayName("Метод должен вернуть значение false при передаче null")
    public void shouldReturnExceptionForInvalidEmail() {
        Assertions.assertFalse(emailValidator.isValidEmail(null),
                "Метод не вернул false при передаче null");
    }
}
