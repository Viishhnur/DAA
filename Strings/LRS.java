import java.util.*;
// Longest Repeating Substring  
public class LRS{

    private static int getLRSLen(String s,int n){

        for(int j = n - 1 ; j >= 1 ; j--){
            HashSet<String> st = new HashSet<>();

            for(int i = 0 ; i <= (n - j) ; i++){
                String subs = s.substring(i,i+j);
                System.out.print(subs + " ");

                if(st.contains(subs)) return j;
                st.add(subs);
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "abbaba";

        System.out.println(getLRSLen(s,s.length()));

        
        sc.close();
    }
}