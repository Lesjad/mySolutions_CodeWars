//09.06.2020 - my solution for Kata named: Product of consecutive Fib numbers

import java.util.Arrays;

public class ProdFib { // must be public for codewars

    public static long[] productFib(long prod) {

        long n_0=0l;
        long n_1=0l;
        long k=1l;

        while (n_0*n_1<prod){
            n_0=n_1;
            n_1=fib(k);
            k++;
        }
        long[] result =new long[] {n_0, n_1, (n_0*n_1==prod)? 1l : 0l};
        return result;
    }

    public static long fib(long n){
        if (n<=2){
            return 1l;
        } else{
            long num0=1;
            long num1=1;
            long k=3;
            while (k<n){
                if (num0>=num1){
                    num1+=num0;
                } else {
                    num0+=num1;
                }
                k++;
            }
            return num0+num1;
        }
    }
}