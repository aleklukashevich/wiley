package util;

import java.util.Random;

/**
 * Created by Alek on 08.05.2018.
 */
public final class RandomUtil {

    private RandomUtil() {
    }

    public static int getRandomByNumber(int num){
        return new Random().nextInt(num);
    }

    public static boolean coin(){
        int i = new Random().nextInt(2);
        return i == 1;
    }
}
