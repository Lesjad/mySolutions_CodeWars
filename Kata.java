//31.5.2020 - my solution for Kata named: Next bigger number with the same digits

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kata
{
    public static long nextBiggerNumber(long n)
    {
        ArrayList<Integer> digits=new ArrayList<Integer>();
        long result=0;

        String strN=String.valueOf(n);
        System.out.println(n);


        for (int i=0; i<strN.length();i++){
            digits.add(Integer.valueOf(strN.substring(i,i+1)));
        }

        System.out.println(digits);
        Collections.reverse(digits);
        System.out.println(digits);

        for (int i=1; i<digits.size(); i++){
            if (Collections.max(digits.subList(0,i))>digits.get(i)){
                List partDigits = digits.subList(0,i);
                Collections.sort(partDigits);
                for (int j=0; j<partDigits.size(); j++){
                    int z=j;
                    if ((int)(partDigits.get(j))>digits.get(i)){
                        while (j+1<partDigits.size() && (int)partDigits.get(j)==(int)partDigits.get(j+1)){
                            j++;
                        }
                        Collections.swap(digits,i,j);
                        Collections.sort(partDigits);
                        Collections.reverse(partDigits);
                        for (int k=0; k<digits.size();k++){
                            result+=(long)(Math.pow(10,k)*digits.get(k));
                        }
                        return result;
                    }
                }
            }
        }

        /*for (int i=1; i<digits.size(); i++){
            List partDigits = digits.subList(0,i);
            int maxDigit= (int) Collections.max(partDigits);
            System.out.println("maxDigit:"+maxDigit);
            if(maxDigit>digits.get(i)){
                result+=Math.pow(10,i)*maxDigit;
                partDigits.remove(Integer.valueOf(maxDigit));
                Collections.sort(partDigits);
            };
            System.out.println("partDigits: "+partDigits);
            System.out.println("digits: "+digits);
            System.out.println("result: "+result);
        }*/
/*
        int tempInt=(int)n;
        long number=0;
        int power=1;

        while (number<n){
            digits.add((int)(tempInt%Math.pow(10,power)));
            number+=(long)(Math.pow(10,power-1)*digits.get(digits.size()-1));
            tempInt=(int)(n-number);
            System.out.println("number: "+number+"\n"+digits);
            power++;
        }
*/
        //System.out.println("number n: "+n+" as a string: "+sNum+" as charArray: "+digits[0]+digits[1]);
        return -1l;
    }
/*
    private long useDigits(List digits, int pow){
        long result=0;
        while (digits.size()>0){
            Collections.max(digits);
        }
    }*/
}
/*
Jeśli zmiana jednostki z dziesiątkami zapewni
 */