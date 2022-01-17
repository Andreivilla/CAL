import java.math.BigInteger;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Random;

public class GeradorDeChaves {
    private Random random = new Random();
    private MDC mdc = new MDC();
    private int TAMANHO_BIGINT;
    private MillerRabin millerRabin = new MillerRabin();
    private BigInteger p, q, n, phi, e, d;

    public GeradorDeChaves(int n){
        this.TAMANHO_BIGINT = n;
    }

    public void gerarChaves(){
        //define 2 provaveis primos aleatorios de tamanho TAMANHO_BIGINT
        this.p = primoBigInteger();
        this.q = primoBigInteger();
        this.n = p.multiply(q);
        this.phi = define_phi(p, q);
        do {
            this.e = new BigInteger(phi.bitLength(), random);
        }while (!e.gcd(phi).equals(BigInteger.ONE) || e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0);
        this.d  = e.modInverse(phi);
    }

    private BigInteger define_phi(BigInteger p, BigInteger q){
        return this.p.subtract(BigInteger.valueOf(1)).multiply(this.q.subtract(BigInteger.ONE));
    }

    public BigInteger[] cifrando(String mensagem, BigInteger n, BigInteger e){
        char[] msg = mensagem.toCharArray();
        BigInteger[] msgCifrada = new BigInteger[mensagem.length()];
        for(int i=0; i<mensagem.length(); i++){
            msgCifrada[i] = BigInteger.valueOf((int) msg[i]).modPow(e, n);
        }
        return msgCifrada;
    }

    public String decifrando(BigInteger[] mensagem, BigInteger n, BigInteger d){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<mensagem.length; i++){
            stringBuilder.append((char) mensagem[i].modPow(d, n).intValue());
        }
        return stringBuilder.toString();
    }

    private BigInteger primoBigInteger(){//gera um provavel primo do tipo NigInteger
        while (true){
            BigInteger primo = new BigInteger(TAMANHO_BIGINT, random);
            if(millerRabin.isProbablePrime(primo, 100)){
                return primo;
            }
        }

    }

    //getters
    public BigInteger[] getChavePublica(){
        BigInteger[] chave = new BigInteger[2];
        chave[0] = getN();
        chave[1] = getE();
        return chave;
    }

    public BigInteger getChavePrivada(){
        return getD();
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getN() {
        return n;
    }

    /*
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
    }*/

    //cifra
    /*public ArrayList<BigInteger> cifra(String mensagem, BigInteger n, BigInteger d){
        //BigInteger tam = BigInteger.valueOf(mensagem.length());
        ArrayList<BigInteger> mensagemCifrada = new ArrayList<>();
        char[] mensagemChar = mensagem.toCharArray();

        for(int i=0; i<mensagem.length(); i++){
            BigInteger k = BigInteger.valueOf(mensagemChar[i]);

        }
    }*/

}