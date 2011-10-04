package dstywho.probably;

import java.util.Random;

public class RandomString extends Random {
    private static String characters = "ABCDEFGHIJKLMNOPabcdefghijklmnop123";

    public RandomString(long seed) {
        super(seed);
    }

    public String nextString(int maxlen) {
        char[] text = new char[maxlen];
        for (int i = 0; i < maxlen; i++) {
            text[i] = characters.charAt(this.nextInt(characters.length()));
        }
        return new String(text);

    }

    public static void main(String args[]) {
        RandomString rs = new RandomString(1000);
        String s = rs.nextString(123);

        System.out.println(s);
        System.out.println(rs.nextString(123));
    }

}
