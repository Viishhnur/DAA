import java.util.*;
public class ValidAbbr{
    private static boolean validWordAbbreviation(String word, String abbr){
        if(word == null || abbr == null) return false;
        int i = 0 , j = 0;
        int m = word.length();
        int n = abbr.length();
    
        while(i < m && j < n){
            
            if(Character.isDigit(abbr.charAt(j))){
                // if leading zero return 0
                if(abbr.charAt(j) == '0') return false;

                int total = 0;

                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))){
                    total = total * 10 + abbr.charAt(j) - '0';
                    j++;
                }

                i += total;
            }
            else{
                // check if chars are equal
                if(word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }

        return i == m && j == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = "internationalization";
        String abbr = "i12iz4n";
        
        System.out.println(validWordAbbreviation(s, abbr));
        sc.close();
    }
}
