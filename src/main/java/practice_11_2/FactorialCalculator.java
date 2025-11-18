package practice_11_2;

public class FactorialCalculator {

    // Метод возвращает факториал положительного целого числа
    public int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        return (n == 0) ? 1 : n * factorial(n - 1);
    }
}
