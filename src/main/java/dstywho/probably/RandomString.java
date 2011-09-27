package dstywho.probably;

import java.util.Random;

public class RandomString extends Random {

    public RandomString(long seed)
        {
            super(seed);
        }

    public String nextString(int maxlen)
        {
            int n = nextInt(maxlen + 1);
            char c[] = new char[n];
            for (int i = 0; i < n; i++)
                c[i] = (char) (32 + nextInt(128 - 32));
            return new String(c);
        }

    public static void main(String args[])
        {
            RandomString rs = new RandomString(1000);
            String s = rs.nextString(Integer.parseInt(args[0]));
            System.out.println(s);
        }

}
