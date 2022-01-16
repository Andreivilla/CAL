import java.math.BigInteger;
import java.util.ArrayList;

public class MDC {
    /*Algortimo de euclides estendido baseado na versão de seu artigo na wikipedia disponivel em:
    https://pt.wikipedia.org/wiki/Algoritmo_de_Euclides_estendido */
    public ArrayList<BigInteger> mdc(BigInteger a, BigInteger b){
        ArrayList<BigInteger> retorno = new ArrayList<>();

        BigInteger u = BigInteger.valueOf(1);
        BigInteger v = BigInteger.valueOf(0);
        BigInteger u1 = BigInteger.valueOf(0);
        BigInteger v1 = BigInteger.valueOf(1);

        BigInteger rs, us, vs, q;

        while(!b.equals(BigInteger.valueOf(0))){
            q = a.divide(b);
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

    public Boolean primoAKS(BigInteger a){
        BigInteger b = BigInteger.valueOf(1);

        return true;
    }
}