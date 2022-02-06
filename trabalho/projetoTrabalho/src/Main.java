import classes.Cripto;

import classes.ManipuladorArquivos;
import classes.RSA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        /*gráficos com os tempos de execução da
        geração das chaves,
        da fatoração, do
        processo de criptografia e
        descriptografia da mensagem. O gráfico do processo
        de criptografia deve incluir exemplos até 1024, os tempos devem ser medidos com
        intervalos de chaves de 64 bits*/

        long tempoInicial = System.currentTimeMillis();
        RSA rsa = new RSA(16);
        Cripto cripto = new Cripto(rsa);
        cripto.criptografa();

        /*System.out.println("Precione enter para continuar");
        {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }*/

        cripto.descriptografa();
        long tempoFinal = System.currentTimeMillis();

        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }

}