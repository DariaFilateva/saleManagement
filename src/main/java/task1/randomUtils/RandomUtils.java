package task1.randomUtils;

import java.util.Random;

public class RandomUtils {

    public static int getRandom(int min, int max){
         Random rnd = new Random();
        return min + rnd.nextInt(max - min + 1);
    }
}
