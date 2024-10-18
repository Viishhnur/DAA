import java.util.*;
public class Day6P2IsStrobo {
    private static boolean isStroboGrammatic(String num,HashMap<Character,Character>mp){
        
        // first reverse the number is strobogrammatic way
        String rev = "";
        for (int i=0 ; i<num.length() ; i++) {
            char ch = num.charAt(i);
            if(!mp.containsKey(ch)) return false;
            rev = mp.get(ch) + rev;
        }
        return rev.equals(num);
    }
    public static void main(String[] args){
    
        String num = "61819";
        HashMap<Character,Character> mp = new HashMap<>();
        mp.put('0','0');
        mp.put('1','1');
        mp.put('8','8');
        mp.put('6','9');
        mp.put('9','6');
        System.out.println(isStroboGrammatic(num,mp));
    }
}
