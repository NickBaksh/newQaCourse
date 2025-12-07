package practice_13_1.task_2;

public class UserValidator {
    private static boolean validationEnabled = true;

    public static void setValidation(boolean state) {
        validationEnabled = state;
    }

    public static boolean isValidationEnabled() {
        return validationEnabled;
    }

    public static void validate(User user) {
        if (!isValidationEnabled()) {
            return;
        }

        validateName(user.getName());
        validateAge(user.getAge());
        validateEmail(user.getEmail());
    }

    private static void validateName(String name) {

        if (name.isBlank() || !Character.isUpperCase(name.charAt(0))) {
            throw new InvalidUserException("Имя должно быть не пустым и должно начинаться с заглавной буквы.");
        }
    }

    private static void validateAge(int age) {
        if (age < 18 || age > 100) {
            throw new InvalidUserException("Возраст должен быть в пределах от 18 до 100 лет.");
        }
    }

    private static void validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (email == null || email.isBlank()) {
            throw new InvalidUserException("Email не может быть пустым или содержать пробелы.");
        }

        if (!email.matches(regex)) {
            throw new InvalidUserException("Email должен соответствовать стандартному формату электронной почты.");
        }
    }
}
