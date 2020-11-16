//30.5.2020 - my solution for Kata named: Stop gninnipS My sdroW!

public class SpinWords {

    public String spinWords(String sentence) {
        int currSpaceIndex=-1;
        int prevSpaceIndex=-1;
        String result="";

        currSpaceIndex=sentence.indexOf(" ",0);

        while (currSpaceIndex!=-1){
            String word=sentence.substring(prevSpaceIndex+1,currSpaceIndex);
            if (word.length()>=5){
                if (prevSpaceIndex==-1){
                    result+=spin(word);
                }else {
                    result = result + " "+spin(word);
                }
            } else{
                if (prevSpaceIndex == -1) {
                    result+=word;
                } else{
                    result = result + " "+word;
                }
            }
            prevSpaceIndex=currSpaceIndex;
            currSpaceIndex=sentence.indexOf(" ",prevSpaceIndex+1);
        }
        String word=sentence.substring(prevSpaceIndex+1);
        if (word.length()>=5){
            if (prevSpaceIndex==0){
                result+=spin(word);
            }else {
                result = result + " "+spin(word);
            }
        } else{
            if (prevSpaceIndex == 0) {
                result+=word;
            } else{
                result = result + " "+word;
            }
        }
        while (result.startsWith(" ")){
            result=result.substring(1);
        }
        return result;
    }
    private String spin(String word){
        String newWord="";
        for (int i=0;i<word.length();i++){
            newWord=word.charAt(i)+newWord;
        }
        return newWord;
    }
}