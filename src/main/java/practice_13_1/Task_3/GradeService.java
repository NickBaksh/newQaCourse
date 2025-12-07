package practice_13_1.Task_3;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class GradeService<T extends Number> {

    private final List<StudentGrade<T>> studentGrades = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> grades) {
        if (grades.getGrade().doubleValue() < 0) {
            throw new InvalidGradeException("Оценка не может быть отрицательной");
        }
        studentGrades.add(grades);
    }

    public double calculateAverageGrade(String subject) {
        int count = 0;
        double gradesSum = 0;

        for (StudentGrade<T> g : studentGrades) {
            if (g.getSubject().equalsIgnoreCase(subject)) {
                gradesSum += g.getGrade().doubleValue();
                count++;
            }

            if (count == 0) {
                throw new InvalidGradeException("Отсутствуют оценки по предмету");
            }
        }
        return gradesSum / count;
    }

    public List<StudentGrade<T>> getAllGrades() {
        return new ArrayList<>(studentGrades);
    }
}
