package classes;

import java.math.BigInteger;
import java.util.ArrayList;

public class fatoracao {
    public BigInteger[] fatoracaoPQ(BigInteger n){
        ArrayList<BigInteger> fatores = new ArrayList<>();
        fatores.add(BigInteger.valueOf(2));
        BigInteger[] retorno = new BigInteger[2];

        //loop identifica todos os valores primos que dividem o fator n
        BigInteger i = new BigInteger("2");
        while(i.compareTo(n) < 0){
            if(proxPrimo(fatores, i)){
                fatores.add(i);
            }
            i = i.add(BigInteger.ONE);
        }

        //testa a multiplicação p e q
        for(BigInteger p : fatores){
            for(BigInteger q : fatores){
                if(!p.equals(q) && p.multiply(q).equals(n)){
                    retorno[0] = p;
                    retorno[1] = q;
                    return retorno;
                }
            }
        }
        return retorno;
    }

    private boolean proxPrimo(ArrayList<BigInteger> primos, BigInteger testar){
        for(BigInteger primo : primos) {
            if(testar.mod(primo).equals(BigInteger.valueOf(0)))
                return false;
        }
        return true;
    }
}
