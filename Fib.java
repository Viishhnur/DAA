public class Fib {
    static int sum = 0;
    private static int fib(int n){
        if(n<=1) return n;
        
        System.out.print(fib(n-1) + fib(n-2));  // Print the sum of previous two numbers
        return 0;
    }
    public static void main(String[] args){
        
        System.out.println(fib(4));
    
    }   
}
