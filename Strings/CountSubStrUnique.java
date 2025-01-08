
import java.util.*;
public class CountSubStrUnique{
    private static int countLetters(String s){
        int sum = 1 , count = 1;

        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else{
                count = 1;
            }

            sum += count;
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "aaaaaaaaaa";

        System.out.println(countLetters(s));
        
        sc.close();
    }   
}