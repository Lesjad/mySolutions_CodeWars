//28.05.2020 - my solution for Kata named: Roman Numerals Encoder
public class Conversion {
    public String solution(int n){
        int reminder=n;
        String result="";

        while (reminder>0){
            if (reminder>=1000){
                result+="M";
                reminder-=1000;
            } else if (reminder>=900){
                result+="CM";
                reminder-=900;
            } else if (reminder>=500){
                result+="D";
                reminder-=500;
            } else if (reminder>=400){
                result+="CD";
                reminder-=400;
            } else if (reminder>=100){
                result+="C";
                reminder-=100;
            } else if (reminder>=90){
                result+="XC";
                reminder-=90;
            } else if (reminder>=50){
                result+="L";
                reminder-=50;
            } else if (reminder>=40){
                result+="XL";
                reminder-=40;
            } else if (reminder>=10){
                result+="X";
                reminder-=10;
            } else if (reminder==9){
                return result+"IX";
            } else if (reminder>=5){
                result+="V";
                reminder-=5;
            } else if (reminder==4){
                return result+="IV";
            } else {
                result+="I";
                reminder-=1;
            }
        }
        return result;
    }
}