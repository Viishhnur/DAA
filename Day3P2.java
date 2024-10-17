import java.util.Scanner;
public class Day3P2{
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return;
    }
    private static void moveZerosToEnd(int[] arr,int n){
        // first find the first zero index
        int j = -1;
        for(int i=0;i<n;i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        
        if(j == -1) return; // no zero index found
        
        // Now start iterating from this zero Index+1
        
        for(int i=j+1;i<n;i++){
            if(arr[i] != 0){
                // swap arr[i] and arr[j]\
                swap(arr,i,j);
                j++; // increase the non-zero pointer to the right
            }
        }
        
        return;
        
        
    }
    
    // T.C:- O(N+N)=> O(2*N) ~ O(N)
    // S.C:- O(1)
        
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        moveZerosToEnd(arr,n);
        
        for(int num : arr){
            System.out.print(num + " ");
        }

        sc.close();
    }
}