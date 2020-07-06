package sample;

import java.util.Random;

public class PasswordGenerator {

    private char[] password;
    private int passwordLength;
    private static final int DEFAULT_PASSWORD_LENGTH = 12;

    public PasswordGenerator(int passwordLength) {
        this.passwordLength = passwordLength == 0 ? DEFAULT_PASSWORD_LENGTH : passwordLength < 0 ? Math.abs(passwordLength) : passwordLength;
        this.password = new char[this.passwordLength];
    }

    /**
     * Generates a new password
     *
     * @return The generated password
     */
    public String createPassword() {

        char[] characters = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789^$*.[]{}()?-\"!@#%&/\\,><':;|_~`").toCharArray();
        Random rand = new Random();
        for (int i = 0; i < this.passwordLength; i++) {
            password[i] = characters[rand.nextInt(characters.length)];
        }
        return new String(password);
    }

}
