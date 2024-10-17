public class demo {
    private static int func(int n){
        System.out.print(n + " ");
        if(n > 100){
            return n - 10;
        }

        return func(func(n+11));
    }
    static int count = 1;
    private static void f(int n){
        count++;
        if(n > 0)
            System.out.println(n+" ");
        f(n-1);
        f(n-1);    
        return;
    }
    public static void main(String[] args){
        int res = func(99);
        System.out.println(res);

        f(4);
        System.out.println(count);
    
    }
}
