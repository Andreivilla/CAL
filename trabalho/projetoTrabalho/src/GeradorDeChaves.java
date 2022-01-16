import java.math.BigInteger;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Random;

public class GeradorDeChaves {
    private Random random = new Random(System.currentTimeMillis());
    private MDC mdc = new MDC();
    private int TAMANHO_BIGINT;//tamanho em bits dos numeros primos

    public GeradorDeChaves(int n){
        TAMANHO_BIGINT = n;
    }

    private BigInteger bigN(BigInteger n){
        BigInteger r = new BigInteger(TAMANHO_BIGINT, random);
        while (r.compareTo(n) < 1){
            r = new BigInteger(TAMANHO_BIGINT, random);
        }
        return r;
    }


    //codigo do python


    //totiente se for -1 é falso
    public BigInteger totient(BigInteger n){
        if(n.isProbablePrime(100)){
            return n.subtract(BigInteger.valueOf(1));
        }else{
            return new BigInteger("-1");
        }
    }

    //gera e
    public BigInteger geradorE(BigInteger n){
        while(true){
            BigInteger e = bigN(n);
            if(mdc.mdc(n, e).equals(BigInteger.valueOf(1))){
                return e;
            }
        }
    }

    //gerador numero primo aleatorio
    public BigInteger primoA(){
        while(true){
            BigInteger n = new BigInteger(TAMANHO_BIGINT, random);
            if(n.isProbablePrime(100))
                return n;
        }
    }

    //chave privada
    public BigInteger chavePrivada(BigInteger toti, BigInteger e){
        BigInteger d = new BigInteger("0");
        while(!d.multiply(e).mod(toti).equals(BigInteger.valueOf(1))){
            d.add(BigInteger.valueOf(1));
        }
        return d;
    }

    //cifra
    /*public ArrayList<BigInteger> cifra(String mensagem, BigInteger n, BigInteger d){
        //BigInteger tam = BigInteger.valueOf(mensagem.length());
        ArrayList<BigInteger> mensagemCifrada = new ArrayList<>();
        char[] mensagemChar = mensagem.toCharArray();

        for(int i=0; i<mensagem.length(); i++){
            BigInteger k = BigInteger.valueOf(mensagemChar[i]);
            k.modPow(e);
        }
    }*/

}