package practice_13.Task_2;

public class UserValidator {
    private static boolean validationEnabled = true;

    public static void setValidationEnabled(boolean enabled) {
        validationEnabled = enabled;
    }

    public static boolean isValidationEnabled() {
        return validationEnabled;
    }

    public static void validate(User user) {
        if (!validationEnabled) {
            return;
        }

        validateName(user.getName());
        validateEmail(user.getEmail());
        validateAge(user.getAge());
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidUserException("Имя пользователя не может быть пустым");
        }

        if (!Character.isUpperCase(name.charAt(0))) {
            throw new InvalidUserException("Имя пользователя должно начинаться с заглавной буквы");
        }
    }

    private static void validateAge(int age) {
        if (age < 18 || age > 100) {
            throw new InvalidUserException("Возраст должен быть в диапазоне от 18 до 100 лет");
        }
    }

    private static void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new InvalidUserException("Email не может быть пустым");
        }

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!email.matches(regex)) {
            throw new InvalidUserException("Некорректный формат email");
        }
    }
}
