public class FibonacciNumber {
    public int toptobottomFib(int []memo,int n){
        if(memo[n]==0){
            if(n<2){
                memo[n]=n;
            }
            else{
                int left = toptobottomFib(memo,n-1);
                int right = toptobottomFib(memo,n-2);
                memo[n]=left+right;
            }
        }
        return memo[n];

    }
    public int fib(int n){
        int[] table = new int[n+1];
        table[0]=0;
        table[1]=1;
        for(int i =2;i<=n;i++){
            table[i]=table[i-1]+table[i-2];
        }
        return table[n];
    }
    public static void main(String[] args) {
        FibonacciNumber fn = new FibonacciNumber();
        System.out.println("The output of  bottom to top approach is - "+fn.fib( 6));
        System.out.println("The output of top to bottom approach is - "+ fn.toptobottomFib(new int[6+1] ,6));


    }
}
