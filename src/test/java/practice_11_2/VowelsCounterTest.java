package practice_11_2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VowelsCounterTest {

    private VowelsCounter vowelsCounter;

    @BeforeEach
    void setUp() {
        vowelsCounter = new VowelsCounter();
    }


    //----Проверка сценария со строками, содержащими гласные буквы-----
    Stream<Arguments> StringsWithVowels() {
        // Параметры для проверки кейса, где строки содержат гласные буквы
        return Stream.of(
                Arguments.of("hello", 2),
                Arguments.of("java", 2),
                //Строка из заглавных букв, в строке все буквы гласные
                Arguments.of("AEIOU", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("StringsWithVowels")
    @DisplayName("Метод должен вернуть количество гласных для строки с гласными буквами")
    public void shouldReturnVowelsCountForStringWithVowels(String initialString, int expectedCount) {
        Assertions.assertEquals(expectedCount, vowelsCounter.countVowels(initialString),
                "Количество гласных в строке не соответствует ожидаемому");
    }

    //----Проверка сценария со строками, содержащими только согласные буквы-----
    Stream<Arguments> StringsWithOutVowels() {
        // Параметры для проверки кейса (строка только с согласными)
        return Stream.of(
                // Строки из согласных букв
                Arguments.of("crt", 0),
                Arguments.of("LV", 0),
                // Строка из согласных разного регистра и символа "!"
                Arguments.of("MRb!", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("StringsWithOutVowels")
    @DisplayName("Метод должен вернуть значение 0 для строки из согласных букв")
    public void shouldReturnZeroForStringWithOutVowels(String initialString, int expectedCount) {
        Assertions.assertEquals(expectedCount, vowelsCounter.countVowels(initialString),
                "Метод не вернул число 0 для строки из согласных букв");
    }


    //-------Проверка сценария где передан null----------
    @Test
    @DisplayName("Метод должен вернуть IllegalArgumentException если передан null")
    public void shouldReturnIllegalArgumentExceptionForNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {vowelsCounter.countVowels(null);
        }, "Передача null вместо строки должна привести к выбрасыванию IllegalArgumentException");
    }

    //----Проверка сценария с пустой строкой-----
    Stream<Arguments> EmptyString() {
        // Параметры для проверки кейса (строка только с согласными)
        return Stream.of(
                // Пустая строка
                Arguments.of("", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("EmptyString")
    @DisplayName("Метод должен вернуть значение 0 для строки из согласных букв")
    public void shouldReturnZeroForEmptyString(String initialString, int expectedCount) {
        Assertions.assertEquals(expectedCount, vowelsCounter.countVowels(initialString),
                "Метод не вернул число 0 для пустой строки");
    }
}
