package sample;

import java.util.Random;

public class PasswordGenerator {

    private static final int DEFAULT_PASSWORD_LENGTH = 12;

    /**
     * Creates a new password
     *
     * @param pwordLength The length of the password
     * @return The created password
     */
    private static String createPassword(int pwordLength) {

        Random rng = new Random();
        int passwordLength = pwordLength == 0 ? DEFAULT_PASSWORD_LENGTH : pwordLength < 0 ? Math.abs(pwordLength) : pwordLength;
        char[] password = new char[passwordLength];
        char[] characters = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789^$*.[]{}()?-\"!@#%&/\\,><':;|_~`").toCharArray();

        for (int i = 0; i < passwordLength; i++) {
            password[i] = characters[rng.nextInt(characters.length)];
        }
        return new String(password);
    }

    /**
     * Obtains a created password
     *
     * @param pwordLength The length of the password
     * @return The password
     */
    public static String getPassword(int pwordLength) {
        return createPassword(pwordLength);
    }
}


