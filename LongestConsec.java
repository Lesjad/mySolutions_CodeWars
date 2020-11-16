//27.05.2020 - my solution for Kata named: Consecutive strings

class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        int inputArrLen=strarr.length;

        if (inputArrLen<k || k<=0){
            return "";
        }
        String resultString="";
        int maxLen=0;
        int currLen;

        int[] lengthsOfStrings= new int[inputArrLen];

        for (int i=0; i<inputArrLen; i++){
            lengthsOfStrings[i]=strarr[i].length();
        }

        for (int i=0; i<=inputArrLen-k; i++){
            currLen=0;
            for (int j=0;j<k;j++){
                currLen+=lengthsOfStrings[i+j];
            }
            if (currLen>maxLen){
                maxLen=currLen;
                resultString="";
                for (int j=0;j<k;j++){
                    resultString+=strarr[i+j];
                }
            }
        }

        return resultString;
    }
}