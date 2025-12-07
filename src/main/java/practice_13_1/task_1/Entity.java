package practice_13_1.task_1;

public class Entity {
    private int age;
    private String name;
    private boolean isActive;

    public Entity(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Entities{name= " + name + ", age= "+ age + ", isActive= "+ isActive + "}";
    }
}
