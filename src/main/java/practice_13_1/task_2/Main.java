package practice_13_1.task_2;

public class Main {
    public static void main(String[] args) {
        User masha = new User("Masha", 18, "krevetka23@gmail.com");

        System.out.println("Включен ли валидатор?");
        System.out.println(UserValidator.isValidationEnabled());
        System.out.println();

        System.out.println("Проверим пользователя: " + masha);
        System.out.println();

        try {
            UserValidator.validate(masha);
        } catch (InvalidUserException e) {
            throw new InvalidUserException(e.getMessage());
        }
    }
}
