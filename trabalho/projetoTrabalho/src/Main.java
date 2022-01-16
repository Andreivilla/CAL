import java.math.BigInteger;


public class Main {
    public static void main(String[] args) {
        MDC mdc = new MDC();
        GeradorDeChaves geradorDeChaves = new GeradorDeChaves(128);

        BigInteger b = new BigInteger("2");
        BigInteger a = new BigInteger("3");

        System.out.println(a.modPow(b,a));




    }

}