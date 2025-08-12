package support;

import runner.RunCucumber;
import java.util.concurrent.ThreadLocalRandom;

public class Utils extends RunCucumber {

    public static String getRandomEmail() {
        String emailInit = "robson";
        String emailDomain = "@gmail.com";

        int min = 1;
        int max = 9999;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        return emailInit + randomNum + emailDomain;
    }
}