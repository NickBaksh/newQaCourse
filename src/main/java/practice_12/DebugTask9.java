package practice_12;

public class DebugTask9 {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");
        // Сравниваем не ссылки на объекты, а по-символьно каждый символ в строке hello
        if (str1.equals(str2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
