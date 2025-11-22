package practice_12;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DebugTask8 {
    public static void main(String[] args) {
        // значение a = 0.30000000000004, поэтому не равно b
        double a = 0.1 * 3;
        //Округляем через BigDecimal до 1 знака после запятой
        a = BigDecimal.valueOf(a).setScale(1, RoundingMode.HALF_UP).doubleValue();
        double b = 0.3;
        if (a == b) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
