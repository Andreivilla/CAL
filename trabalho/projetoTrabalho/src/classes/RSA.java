package classes;

import java.math.BigInteger;
import java.util.Random;

public class RSA {
    private Random random = new Random();
    private MDC mdc = new MDC();
    private int TAMANHO_BIGINT;
    private MillerRabin millerRabin = new MillerRabin();
    private BigInteger p, q, n, phi, e, d;

    //construtores
    //construtor onde n define o numero de bits e tamnaho dos intieros
    public RSA(int precisao){
        this.TAMANHO_BIGINT = precisao;
        gerarChaves();
    }
    //construtor com chaves
    public RSA(BigInteger[] chavePublica, BigInteger chavePrivada){
        this.n = chavePublica[0];
        this.e = chavePublica[1];
        this.d = chavePrivada;
    }

    public void gerarChaves(){
        //define 2 provaveis primos aleatorios de tamanho TAMANHO_BIGINT
        this.p = primoBigInteger();
        this.q = primoBigInteger();
        this.n = p.multiply(q);//n é definido por n = pq
        this.phi = phi(p, q);//define o valor de phi para p e q

        while(true){// repete até encotrar um co primo de n
            this.e = BigIntegerInRange(phi);//gera um primo menor que n
            if(mdc.mdcSimples(e, phi).equals(BigInteger.valueOf(1))){// verifica coprimaridade
                break;
            }
        }

        this.d  = e.modInverse(phi);// d = (2phi(n) + 1)/e
    }

    //phi(n) = (p-1)(q-1)
    private BigInteger phi(BigInteger p, BigInteger q){
        return this.p.subtract(BigInteger.valueOf(1)).multiply(this.q.subtract(BigInteger.ONE));
    }

    public BigInteger[] cifrando(String mensagem, BigInteger n, BigInteger e){
        char[] msg = mensagem.toCharArray();
        BigInteger[] msgCifrada = new BigInteger[mensagem.length()];
        for(int i=0; i<mensagem.length(); i++){//cifra caracter por caracter baseado no valor da tabela ascii
            msgCifrada[i] = BigInteger.valueOf((int) msg[i]).modPow(e, n);//c = m^(e mod m)
        }
        return msgCifrada;
    }

    public String decifrando(BigInteger[] mensagem, BigInteger n, BigInteger d){
        //os caracteres são convertidos me tabela ascii dps char e adicionados em um stringbuilder e retornando a string
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<mensagem.length; i++){
            stringBuilder.append((char) mensagem[i].modPow(d, n).intValue());//m = c^(d mod n)
        }
        return stringBuilder.toString();
    }

    private BigInteger primoBigInteger(){//gera um provavel primo do tipo BigInteger através do teste de miller rabin
        while (true){
            BigInteger primo = new BigInteger(TAMANHO_BIGINT, random);
            if(millerRabin.isProbablePrime(primo, 100)){
                return primo;
            }
        }
    }

    private BigInteger BigIntegerInRange(BigInteger n){
        while (true){
            BigInteger r = primoBigInteger();
            if(n.compareTo(r) > 0){
                return r;
            }
        }
    }

    //getters
    public BigInteger[] getChavePublica(){
        BigInteger[] chave = new BigInteger[2];
        chave[0] = n;
        chave[1] = e;
        return chave;
    }

    public BigInteger getChavePrivada(){
        return d;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }
}