package practice_12;

public class DebugTask4 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("hah"));
    }
    public static boolean isPalindrome(String str)
    {
        if(str == null) {
            throw new NullPointerException("Ожидается строка вместо null в аргументе метода isPalindrome");
        }
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
