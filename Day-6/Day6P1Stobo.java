import java.util.*;

public class Day6P1Stobo {
    private static List<String> findStrobogrammatic(int n,int length){
        List<String> res = new ArrayList<>();
        if(n == 0){
            res.add("");
            return res;
        }
        if(n == 1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        List<String> prev = findStrobogrammatic(n-2,length);
        for(String str : prev){
            if(n!=length){
                res.add("0"+str+"0");
            }
            res.add("1"+str+"1");
            res.add("6"+str+"9");
            res.add("8"+str+"8");
            res.add("9"+str+"6");
        }
        return res;
    }
    public static void main(String[] args){
        // return all the N digit strobo nums
        int N = 4;
        List<String>lst = findStrobogrammatic(N,N);
        Collections.sort(lst);
        System.out.println(lst);
    }
}
