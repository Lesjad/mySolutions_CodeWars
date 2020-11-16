import java.util.Arrays;

public class RunClass {
    public static void main(String[] args){
        BigInt mInstance=new BigInt();
        int x=5;
        System.out.println("funkcja Factorial: "+x+": "+mInstance.Factorial(x));

        String a="12";
        String b="9";
        System.out.println("funkcja add: "+a+" + "+b+": "+mInstance.add(a,b));
        System.out.println("funkcja mul: "+a+" x "+b+": "+mInstance.mul(a,b));
    }
}

// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
