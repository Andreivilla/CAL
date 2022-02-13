import classes.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Scanner sc = new Scanner(System.in);
        RSA rsa = new RSA(256);
        Cripto cripto = new Cripto(rsa);

        Integer op = -1;
        while (true) {
            System.out.println("1- Criptografa");
            System.out.println("2- Descriptografa");
            System.out.println("3- Mostrar componentes RSA");
            System.out.println("0- fechar programa");

            op = sc.nextInt();
            switch (op) {
                case 1:
                    cripto.criptografa();
                    System.out.println("Arquivo criptografado");
                    break;
                case 2:
                    cripto.descriptografa();
                    System.out.println("Arquivo Descriptografado");
                    break;
                case 3:
                    System.out.println("n: " + rsa.getChavePublica()[0]);
                    System.out.println("e: " + rsa.getChavePublica()[1]);
                    System.out.println("d: " + rsa.getChavePrivada());
                    System.out.println("q: " + rsa.getQ());
                    System.out.println("p: " + rsa.getP());
                    break;
                case 0:
                    System.out.println("programa encerrado");
                    return;
                default:
                    System.out.println("opção invalida");
            }
        }*/



        TestesGraficos testesGraficos = new TestesGraficos(10);
        //testesGraficos.testar();
        testesGraficos.testarFatoracao();
        /*RSA rsa = new RSA(32);*/
    }

}