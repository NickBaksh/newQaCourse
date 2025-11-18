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
public class WordsCounterTest {

    private WordsCounter wordsCounter;

    @BeforeEach
    void setUp() {
        wordsCounter = new WordsCounter();
    }

    //-----Проверка подсчета количества слов в строке с пробелами-------
    Stream<Arguments> stringWithWordsAndSpace() {
        return Stream.of(
                Arguments.of("Hello, word!", 2),
                Arguments.of("Какой прекрасный день!", 3),
                Arguments.of("Допустим будет    по несколько    пробелов", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithWordsAndSpace")
    @DisplayName("Метод должен вернуть количество слов в строке с пробелами")
    public void shouldReturnCountOfWordsInStringWithSpaces(String initialString, int expectedCount) {
        Assertions.assertEquals(expectedCount, wordsCounter.countWords(initialString),
                "Метод вернул некорректное значение количества слов в строке с пробелами");
    }

    //-----Проверка подсчета количества слов в пустой строке-------
    Stream<Arguments> emptyString() {
        return Stream.of(
                Arguments.of("", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("emptyString")
    @DisplayName("Метод должен вернуть 0 для пустой строки")
    public void shouldReturnZeroForEmptyString(String initialString, int expectedCount) {
        Assertions.assertEquals(expectedCount, wordsCounter.countWords(initialString),
                "Метод не вернул 0 для пустой строки");
    }

    //-----Проверка подсчета количества слов для null вместо строки-------
    Stream<Arguments> nullString() {
        return Stream.of(
                Arguments.of((Object) null)
        );
    }

    @ParameterizedTest
    @MethodSource("nullString")
    @DisplayName("Метод должен вернуть NullPointerException для Null вместо строки")
    public void shouldReturnZeroForNullString(String initialString) {
        Assertions.assertThrows(NullPointerException.class, () -> {wordsCounter.countWords(initialString);
            },"Метод не вернул NullPointerException для Null вместо строки");
    }
}
