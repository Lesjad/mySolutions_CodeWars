// my solution for Kata named Tortoise racing

public class Tortoise {
    public static int[] race(int v1, int v2, int g) {

        if (v2<v1) return null;

        double v1PerSec= v1/3600.0;
        double v2PerSec= v2/3600.0;

        int resultInSec = (int) (g/(v2PerSec-v1PerSec));

        int[] result = {resultInSec/3600, resultInSec%3600/60, resultInSec%3600%60};
        return result;
    }
}