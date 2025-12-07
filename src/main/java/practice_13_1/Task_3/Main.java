package practice_13_1.Task_3;

public class Main {
    public static void main(String[] args) {

        GradeService<Double> gradeService = new GradeService<>();
        gradeService.addGrade(new StudentGrade<>("Pasha", "Physics", 5.0));
        gradeService.addGrade(new StudentGrade<>("Petya", "Physics", 4.5));
        gradeService.addGrade(new StudentGrade<>("Alex", "Math", 4.0));

        System.out.println(gradeService.calculateAverageGrade("Physics"));

        System.out.println(gradeService.getAllGrades());
    }
}
