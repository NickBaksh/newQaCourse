package practice_13_1.task_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice_13_1.Task_3.GradeService;
import practice_13_1.Task_3.InvalidGradeException;
import practice_13_1.Task_3.StudentGrade;

public class GradeServiceTest {

    private GradeService<Double> gradeService;

    @BeforeEach
    void setUp() {
        gradeService = new GradeService<>();
    }

    //Добавление валидной оценки в GradeService
    //Добавление отрицательной оценки
    //Расчет средней оценки
    //Расчет средней оценки при отсутствии оценок

    @Test
    @DisplayName("Добавление валидной оценки в GradeService")
    public void shouldAddValidGrade() {
        StudentGrade<Double> petyaGrade = new StudentGrade<>("Petya", "Math", 4.0);
        gradeService.addGrade(petyaGrade);

        Assertions.assertEquals(1, gradeService.getAllGrades().size());
        Assertions.assertTrue(gradeService.getAllGrades().contains(petyaGrade));
    }

    @Test
    @DisplayName("Добавление отрицательной оценки в GradeService")
    public void shouldReturnExceptionForNegativeGrade() {
        StudentGrade<Double> alexGrade = new StudentGrade<>("Alex", "Math", -3.5);
        Exception e = Assertions.assertThrows(InvalidGradeException.class, () -> gradeService.addGrade(alexGrade));

        Assertions.assertEquals("Оценка не может быть отрицательной", e.getMessage());
    }

    @Test
    @DisplayName("Расчет средней оценки")
    public void shouldReturnAverageGrade() {
        StudentGrade<Double> petyaGrade = new StudentGrade<>("Petya", "Math", 4.0);
        StudentGrade<Double> vovaGrade = new StudentGrade<>("Vova", "Math", 5.0);
        StudentGrade<Double> viktorGrade = new StudentGrade<>("Viktor", "Chemistry", 4.0);
        gradeService.addGrade(petyaGrade);
        gradeService.addGrade(vovaGrade);
        gradeService.addGrade(viktorGrade);

        Assertions.assertEquals(4.5, gradeService.calculateAverageGrade("Math"));
    }

    @Test
    @DisplayName("Должен вернуть ошибку если по предмету отсутствуют оценки")
    public void shouldReturnExceptionForZeroGrades() {
        StudentGrade<Double> petyaGrade = new StudentGrade<>("Petya", "Math", 4.0);
        gradeService.addGrade(petyaGrade);

        Exception e = Assertions.assertThrows(InvalidGradeException.class,
                () -> gradeService.calculateAverageGrade("Chemistry"));

        Assertions.assertEquals("Отсутствуют оценки по предмету", e.getMessage());
    }
}
