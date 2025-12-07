package practice_13_1.task_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserValidatorTest {

    @BeforeEach
    void setUp() {
        UserValidator.setValidation(true);
    }

    //Должен пройти валидацию при корректных данных
    @Test
    @DisplayName("Должен пройти валидацию при передаче валидных данных")
    public void shouldNotReturnExceptionForValidUser() {
        User user = new User("Petya", 25, "kmail@gmail.com");

        Assertions.assertDoesNotThrow(() -> UserValidator.validate(user));
    }

    //Должен вернуть исключение если имя не с заглавной буквы
    @Test
    @DisplayName("Должен вернуть исключение для пользователя с именем не с загловной буквы")
    public void shouldReturnExceptionForNonUpperCaseInFirstCharOfName() {
        User user = new User("kolya", 43, "somemail@gmail.com");

        Exception e = Assertions.assertThrows(InvalidUserException.class, () -> UserValidator.validate(user));

        Assertions.assertEquals("Имя должно быть не пустым и должно " +
                "начинаться с заглавной буквы.", e.getMessage());
    }

    //Должен вернуть исключение если имя пустое
    @Test
    @DisplayName("Должен вернуть исключение если имя пользователя пустое")
    public void shouldReturnExceptionForUserWithBlankName() {
        User user = new User(" ", 43, "somemail@gmail.com");

        Exception e = Assertions.assertThrows(InvalidUserException.class, () -> UserValidator.validate(user));

        Assertions.assertEquals("Имя должно быть не пустым и должно " +
                "начинаться с заглавной буквы.", e.getMessage());
    }

    //Должен вернуть исключение если возраст пользователя больше 100 и меньше 18
    @Test
    @DisplayName("Должен вернуть исключение возраст больше 100 и меньше 18")
    public void shouldReturnExceptionForAgeLessThan18AndMoreThan100() {
        User user = new User("Grisha", 130, "dodo_somemail@gmail.com");

        Exception e = Assertions.assertThrows(InvalidUserException.class, () -> UserValidator.validate(user));

        Assertions.assertEquals("Возраст должен быть в пределах от 18 до 100 лет.", e.getMessage());
    }

    //Должен вернуть исключение если поле email пустое
    @Test
    @DisplayName("Должен вернуть исключение если поле email пустое")
    public void shouldReturnExceptionForEmptyEmail() {
        User user = new User("Grisha", 80, "");

        Exception e = Assertions.assertThrows(InvalidUserException.class, () -> UserValidator.validate(user));

        Assertions.assertEquals("Email не может быть пустым или содержать пробелы.", e.getMessage());
    }

    //Должен вернуть исключение если поле email не соответствует формату
    @Test
    @DisplayName("Должен вернуть исключение если поле email не соответствует формату")
    public void shouldReturnExceptionForIncorrectEmail() {
        User user = new User("Grisha", 80, "//12@gmail.pok");

        Exception e = Assertions.assertThrows(InvalidUserException.class, () -> UserValidator.validate(user));

        Assertions.assertEquals("Email должен соответствовать стандартному формату электронной почты.", e.getMessage());
    }

    @Test
    @DisplayName("Не должен вернуть исключение при выключенной валидации")
    public void shouldNotReturnExceptionForDisabledValidation() {
        UserValidator.setValidation(false);

        User user = new User("petya", 15, "//kmail@gmail.com");

        Assertions.assertDoesNotThrow(() -> UserValidator.validate(user));
    }
}
