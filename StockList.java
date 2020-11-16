//30.5.2020 - my solution for Kata named: Help the bookseller !
//

public class StockList {

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        boolean allZeros=true;
        String[] result=new String[lstOf1stLetter.length];
        for (int i=0; i<lstOf1stLetter.length; i++){
            int number=0;
            for (int j=0;j<lstOfArt.length; j++){
                if (lstOfArt[j].startsWith(lstOf1stLetter[i])){
                    String[] code=lstOfArt[j].split(" ");
                    number+= Integer.valueOf(code[1]);
                }
            }
            if (number!=0) allZeros=false;
            result[i]="("+lstOf1stLetter[i]+" : "+number+")";
        }
        if (allZeros){
            return "";
        } else{
            String output = String.join(" - ", result);
            return output;
        }
    }
}
