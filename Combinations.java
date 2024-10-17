import java.util.Scanner;

public class Combinations {
    private static void backtrack(String s){
        if(s.length() == 0) {
            System.out.println();
            return;
        }
        
        // Recursive case: consider the first character and the rest of the string
        System.out.print(s.charAt(0));
        backtrack(s.substring(1));
        
        // Recursive case: consider the rest of the string without the first character
        backtrack(s.substring(1));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        backtrack(s);
        sc.close();
    }
}
