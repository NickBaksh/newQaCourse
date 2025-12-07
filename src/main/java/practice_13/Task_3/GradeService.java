package practice_13.Task_3;

import java.util.ArrayList;
import java.util.List;

public class GradeService<T extends Number> {

    private final List<StudentGrade<T>> studentGrades = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> grade) {
        if (grade.getMark().doubleValue() < 0) {
            throw new InvalidGradeException("Оценка не может быть отрицательной");
        }
        studentGrades.add(grade);
    }

    public double calculateAverageGrade(String subject) {
        double sum = 0;
        int count = 0;

        for (StudentGrade<T> g : studentGrades) {
            if (g.getSubject().equalsIgnoreCase(subject)) {
                sum += g.getMark().doubleValue();
                count++;
            }
        }

        if (count == 0) {
            throw new InvalidGradeException("Нет оценок для предмета");
        }

        return sum / count;
    }

    public List<StudentGrade<T>> getAllGrades() {
        return new ArrayList<>(studentGrades);
    }
}
