package classes;

import java.math.BigInteger;

public class Fatoracao {
    public BigInteger[] fatoracaoPQ(BigInteger n){
        BigInteger[] fatores = new BigInteger[2];
        BigInteger fator = new BigInteger("3");

        while (true){
            if(n.mod(fator).equals(BigInteger.valueOf(0))){
                fatores[0] = fator;
                fatores[1] = n.divide(fator);
                return fatores;
            }
            fator = fator.add(BigInteger.valueOf(2));
        }
    }
}
