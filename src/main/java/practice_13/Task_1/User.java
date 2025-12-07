package practice_13.Task_1;

public class User {
    private int age;
    private String name;
    private boolean isActive;

    public User(int age, String name, boolean isActive) {
        this.age = age;
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getAge() {
        return age;
    }

//    @Override
//    public void equals() {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (age != user.age) return false;
//        if (active != user.active) return false;
//        return name != null ? name.equals(user.name) : user.name == null;
//    }

//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + age;
//        result = 31 * result + (isActive ? 1 : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return "User{name=" + name + ", age=" + age + ", active=" + isActive + "}";
    }
}
