package io.bloc.android.blocly.api;

import java.util.Random;

/**
 * Created by tonyk_000 on 6/5/2015.
 */
public class UIUtils {

    public static int generateRandomColor(int baseColor) {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        int baseRed = (baseColor & 0xFF0000) >> 16;
        int baseGreen = (baseColor & 0xFF00) >> 8;
        int baseBlue = baseColor & 0xFF;

        red = (red + baseRed) / 2;
        green = (green + baseGreen) / 2;
        blue = (blue + baseBlue) / 2;
        return 0xFF000000 | (red << 16) | (green << 8) | blue;
    }
}
