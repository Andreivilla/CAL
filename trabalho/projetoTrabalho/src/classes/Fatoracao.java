package classes;

import javax.swing.text.StyledEditorKit;
import java.math.BigInteger;
import java.util.ArrayList;

public class Fatoracao {
    public BigInteger[] fatoracaoPQ(BigInteger n){
        BigInteger[] fatores = new BigInteger[2];
        int nFator=0;
        BigInteger fator = new BigInteger("2");
        while (true){
            System.out.println(fator);
            if(n.mod(fator).equals(BigInteger.valueOf(0))){
                fatores[nFator] = fator;
                nFator++;
                if(nFator == 2)
                    return fatores;
            }
            fator = fator.nextProbablePrime();
        }
    }
}
