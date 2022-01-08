import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Util {
    /*Algortimo de euclides estendido baseado na versão disponivel no artigo da wikipedia disponivel em:
    https://pt.wikipedia.org/wiki/Algoritmo_de_Euclides_estendido */
    public ArrayList<BigInteger> mdcEuclidesEstendido(BigInteger a, BigInteger b){
        ArrayList<BigInteger> retorno = new ArrayList<BigInteger>();

        BigInteger u = BigInteger.valueOf(1);
        BigInteger v = BigInteger.valueOf(0);
        BigInteger u1 = BigInteger.valueOf(0);
        BigInteger v1 = BigInteger.valueOf(1);

        BigInteger rs, us, vs, q;

        while(!b.equals(BigInteger.valueOf(0))){
            q = a.divide(b);
            System.out.println(a + "/" + b + "=" + q);
            rs = a;
            us = u;
            vs = v;
            a = b;
            u = u1;
            v = v1;
            b = rs.subtract(q.multiply(b));
            u1 = us.subtract(q.multiply(u));
            v1 = vs.subtract(q.multiply(v1));
        }

        retorno.add(a);
        retorno.add(u);
        retorno.add(v);
        return retorno;//[maior divisor comum, coeficidente maior numero, coeficiente menor numero]
    }

    public BigInteger mdcAKS(BigInteger a, BigInteger b){

        return a;
    }

}
