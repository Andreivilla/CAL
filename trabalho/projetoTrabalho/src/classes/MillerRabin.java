package classes;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabin {

    public boolean isProbablePrime(BigInteger n, int k) {
        if (n.compareTo(BigInteger.valueOf(1)) == 0)
            return false;
        if (n.compareTo(BigInteger.valueOf(3)) < 0)
            return true;
        int s = 0;
        BigInteger d = n.subtract(BigInteger.valueOf(1));
        while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
            s++;
            d = d.divide(BigInteger.valueOf(2));
        }
        for (int i = 0; i < k; i++) {
            BigInteger a = uniformRandom(BigInteger.valueOf(2), n.subtract(BigInteger.valueOf(1)));
            BigInteger x = a.modPow(d, n);
            if (x.equals(BigInteger.valueOf(1)) || x.equals(n.subtract(BigInteger.valueOf(1))))
                continue;
            int r = 0;
            for (; r < s; r++) {
                x = x.modPow(BigInteger.valueOf(2), n);
                if (x.equals(BigInteger.valueOf(1)))
                    return false;
                if (x.equals(n.subtract(BigInteger.valueOf(1))))
                    break;
            }
            if (r == s) // None of the steps made x equal n-1.
                return false;
        }
        return true;
    }

    private BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
        Random rnd = new Random();
        BigInteger res;
        do {
            res = new BigInteger(top.bitLength(), rnd);
        } while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
        return res;
    }
}
