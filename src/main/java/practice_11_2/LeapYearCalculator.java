package practice_11_2;

public class LeapYearCalculator {

    // Метод для определения является ли год високосным
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
