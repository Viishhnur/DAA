import java.util.Scanner;
public class Day1P1{
    
    private static void searchTemp(String[] temps,String target){
        int a = -1 , b = -1;
        for(int i=0;i<temps.length;i++){
            // check in forward direction
            if(temps[i].equals(target)){
                a = i;
                break;
            }
        }
        
        for(int i=temps.length-1;i>=0;i--){
            if(temps[i].equals(target)){
                b = i;
                break;
            }
        }
        
        System.out.printf("[%d,%d]",a,b);
        return;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] temps = sc.nextLine().split(",");
        
        int target = sc.nextInt();
        
        searchTemp(temps,String.valueOf(target));

        sc.close();
    }
}