package practice_13_1.task_1;


public class Main {
    public static void main(String[] args) {
        EntityManager<Entity> students = new EntityManager<>();

        students.add(new Entity("Pasha", 24, true));
        students.add(new Entity("Olga", 14, true));
        Entity petya = new Entity("Petya", 53, false);
        students.add(petya);
        System.out.println(students.getAll());

//        System.out.println(students.remove(petya));
//        System.out.println(students.remove(petya));
        System.out.println(students.getAll());

        System.out.println(students.filterByAge(24, 25));
        System.out.println(students.filterByName("Olga"));
        System.out.println(students.filterByActive());
    }
}
