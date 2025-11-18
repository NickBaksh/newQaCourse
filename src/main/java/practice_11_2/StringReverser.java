package practice_11_2;

public class StringReverser {

    // Метод возвращает переданную строку в обратном порядке
    public String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }
}
