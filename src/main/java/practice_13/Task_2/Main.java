package practice_13.Task_2;

public class Main {
    public static void main(String[] args) {
        User user = new User("Ivan", 999, "ivan@mail.com");

        try {
            UserValidator.validate(user);
            System.out.println("Пользователь валиден!");
        } catch (InvalidUserException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Выключим валидацию
        UserValidator.setValidationEnabled(false);

        User invalidUser = new User("ivan", 5, "wrong email");
        UserValidator.validate(invalidUser); // не проверит и не выбросит исключение
    }
}
