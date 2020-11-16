//31.5.2020 - my solution for Kata named: Josephus Survivor

import java.util.ArrayList;

public class JosephusSurvivor {
    public static int josephusSurvivor(final int n, final int k) {
        ArrayList<Integer> lstOfN= new ArrayList<Integer> ();
        for (int i=0; i<n; i++){
            lstOfN.add(i);
        }

        int currentPos=-1;
        while (lstOfN.size()>1){
            currentPos=(currentPos+k)%(lstOfN.size());
            System.out.println(lstOfN);
            System.out.println("removing item on pos: "+currentPos);
            lstOfN.remove(currentPos);
            currentPos--;
        }
        return lstOfN.get(0)+1;
    }
}