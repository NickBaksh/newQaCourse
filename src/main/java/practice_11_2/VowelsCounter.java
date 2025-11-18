package practice_11_2;

public class VowelsCounter {

    // Метод считает количество гласных в строках на латинице и выбрасывает IllegalArgumentException при передаче null
    public int countVowels(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return (int) input.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
    }
}