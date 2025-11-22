package practice_12;

public class DebugTask5 {
    public static void main(String[] args) {
        Person person = new Person("Alice", 25);
        // Можно решить 2 способами: либо через setter и передавать значение нового возраста.
        // Либо по аналогии с изначальной логикой присваивать полю age новое значение this.age = age + 1
        person.updateAge(26);
        System.out.println("Updated age: " + person.getAge());
    }

}
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void updateAge(int newAge) {
        //Второй вариант:
        // this.age = age + 1
        this.age = newAge;
    }
}
