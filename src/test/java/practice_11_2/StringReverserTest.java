package practice_11_2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringReverserTest {

    private StringReverser stringReverser;

    // Инициализация нового экземпляра класса перед каждым тестом
    @BeforeEach
    void setUp() {
        stringReverser = new StringReverser();
    }

    //----------Проверка сценария с обычными строками----------
    Stream<Arguments> regularString() {
        return Stream.of(
                // Проверка строки из заглавных букв
                Arguments.of("SASHA", "AHSAS"),
                Arguments.of("Nikita", "atikiN"),
                // Проверка строки с пробелом
                Arguments.of("Coca Cola", "aloC acoC"),
                Arguments.of("a", "a")
        );
    }

    @ParameterizedTest
    @MethodSource("regularString")
    @DisplayName("Метод должен вернуть исходную строку в обратном порядке")
    public void shouldReturnReversedString(String initialString, String expectedString) {
        Assertions.assertEquals(expectedString, stringReverser.reverse(initialString),
                "Метод не вернул строку в обратном порядке");
    }


    //-------Проверка сценария с пустой строкой---------
    Stream<Arguments> emptyString() {
        return Stream.of(
                // Проверка с пустой строкой
                Arguments.of("", "")
        );
    }

    @ParameterizedTest
    @MethodSource("emptyString")
    @DisplayName("Метод должен вернуть пустую строку при передаче пустой строки")
    public void shouldReturnEmptyString(String initialString, String expectedString) {
        Assertions.assertEquals(expectedString, stringReverser.reverse(initialString),
                "Метод вернул не пустую строку при передаче пустой строки");
    }

    //-------Проверка сценария с null---------
    @Test
    @DisplayName("Метод должен вернуть null при передаче null вместо строки")
    public void shouldReturnNull() {
        Assertions.assertNull(stringReverser.reverse(null),
                "При передаче null вместо строки метод вернул не null");
    }
}
