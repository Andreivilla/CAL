package classes;

import java.math.BigInteger;

public class Fatoracao {
    public BigInteger[] fatoracaoPQ(BigInteger n){
        BigInteger[] fatores = new BigInteger[2];
        int nFator=0;
        BigInteger fator = new BigInteger("3");
        while (true){

            if(n.mod(fator).equals(BigInteger.valueOf(0))){
                fatores[nFator] = fator;
                nFator++;
                if(nFator == 2)
                    return fatores;
            }
            fator = fator.add(BigInteger.valueOf(2));//fator.nextProbablePrime();
        }
    }
}
