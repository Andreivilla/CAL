import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        BigInteger n1 = new BigInteger("120");
        BigInteger n2 = new BigInteger("14");

        //System.out.println(util.mdc(n1, n2));
        //System.out.println(util.mdcAKS(n1, n2));

        ArrayList lista = util.mdcEuclidesEstendido(n1, n2);

        System.out.println(lista);

    }

}