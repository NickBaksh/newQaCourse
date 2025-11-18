package practice_11_2;

public class WordsCounter {

    // Метод возвращает количество слов в строке в виде целого числа
    public int countWords(String sentence) {
        return sentence.trim().isEmpty() ? 0 : sentence.split("\\s+").length;
    }
}
