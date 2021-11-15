package innovative.bots.lman.utils;

import org.springframework.lang.NonNull;

public class StringManipulationUtility {
    public static String getFirstWordFrom(@NonNull String word) {
        return word.split(" ")[0];
    }
}
