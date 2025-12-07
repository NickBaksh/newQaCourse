package practice_13.Task_1;

public class Main {
    public static void main(String[] args) {

        EntityManager<User> userManager = new EntityManager<>();

        userManager.add(new User(24, "Ivan", true));
        userManager.add(new User(42, "Renata", true));
        userManager.add(new User(14, "Peter", false));

        User alex = new User(22, "Alex", false);
        userManager.add(alex);
        System.out.println(userManager.getAll());

        System.out.println("Выше список с добавленным Алексом");

        System.out.println("Удаляем Алекса");
        userManager.remove(alex);

        System.out.println("Проверяем, что Алекс удален");
        System.out.println(userManager.getAll());

        System.out.println(userManager.filterByActive());
        System.out.println(userManager.filterByAge(7, 15));
        System.out.println(userManager.filterByName("Renata"));
        System.out.println(userManager.remove(new User(24, "Ivan", true)));
        System.out.println(userManager.getAll());
        System.out.println(userManager.remove(new User(24, "Ivan", true)));
    }
}
