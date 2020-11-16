//14.06.2020 - my solution for Kata named: Large Factorials

public class BigInt
{

    public static String Factorial(int n) {

        String result="1";
        for (int i=2; i<=n; i++){
            result=mul(result,String.valueOf(i));
        }
        return result;
    }

    public static String mul(String a, String b){
        String count="0";
        String result="0";
        while (!count.equals(b)){
            result=add(result,a);
            count=add(count,"1");
        }
        return result;
    }

    public static String add(String a, String b){

        String longer= a.length()>=b.length()? a : b;
        String shorter= a.length()>=b.length()? b : a;
        int lenA=longer.length();
        int lenB=shorter.length();
        int reminder=0;

        String result="";

        for (int i=1; i<=lenB; i++){
            int digit1=shorter.charAt(shorter.length()-i)-'0';
            int digit2=longer.charAt(longer.length()-i)-'0';

            int tempResult=digit1+digit2+reminder;

            result=tempResult%10+result;
            reminder=tempResult/10;
        }

        for (int i=lenA-lenB-1; i>=0; i--){
            if (reminder>0){
                int digit=longer.charAt(i)-'0';

                int tempResult=digit+reminder;

                result=tempResult%10+result;
                reminder=tempResult/10;
            } else {
                result=longer.substring(0, i+1)+result;
                break;
            }
        }
        return reminder>0? reminder+result : result;
    }
}