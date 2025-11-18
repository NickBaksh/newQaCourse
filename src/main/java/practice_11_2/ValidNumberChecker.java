package practice_11_2;

public class ValidNumberChecker {

    // Метод проверяет, является ли номер валидным
    public boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\+\\d{1,3} \\d{10}");
    }
}
