package practice_13.Task_3;

public class StudentGrade<T extends Number> {
    private String name;
    private String subject;
    private T mark;

    public StudentGrade(String name, String subject, T mark) {
        this.name = name;
        this.subject = subject;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public T getMark() {
        return mark;
    }
}
