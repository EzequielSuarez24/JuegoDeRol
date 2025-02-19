package utils;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static int getRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
