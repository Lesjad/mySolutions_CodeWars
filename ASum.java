// This is my solution for Kata named: Build a pile of Cubes

public class ASum {

    public static long findNb(long m) {
        int used_volume=0;
        int n=1;

        while (used_volume<m){
            used_volume+=n*n*n;
            n+=1;
        }
        if (used_volume==m){
            return n;
        } else {
            return -1;
        }
    }
}