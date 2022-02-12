import classes.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TestesGraficos testesGraficos = new TestesGraficos(10);
        testesGraficos.testar();
/*
        ArrayList<Float> processoDeDescriptografia = new ArrayList<>();
        ArrayList<Float> processoDeFatoracao = new ArrayList<>();
        long tempoInicial = 0;
        long tempoFinal = 0;*/

        /*for(int i=10;  i <= 30; i+=10){
            /


            processoDeCriptografia.add((float) ((tempoFinal - tempoInicial) / 1000d));

            tempoInicial = System.currentTimeMillis();
            cripto.descriptografa();
            tempoFinal = System.currentTimeMillis();
            processoDeDescriptografia.add((float) ((tempoFinal - tempoInicial) / 1000d));

            Fatoracao fatoracao = new Fatoracao();
            tempoInicial = System.currentTimeMillis();
            fatoracao.fatoracaoPQ(rsa.getChavePublica()[0]);
            tempoFinal = System.currentTimeMillis();
            processoDeFatoracao.add((float) ((tempoFinal - tempoInicial) / 1000d));
        }*/
        /*ArrayList<Float> vet = new ArrayList<>();
        for(int i=8; i<=36; i+=2 ){

            RSA rsa = new RSA(i);
            Fatoracao fatoracao = new Fatoracao();

            tempoInicial = System.currentTimeMillis();
            BigInteger[] pq = fatoracao.fatoracaoPQ(rsa.getChavePublica()[0]);
            tempoFinal = System.currentTimeMillis();
            System.out.println("certo : p: " + rsa.getP() + " q: " + rsa.getQ());
            System.out.println("pq achado : " + pq[0] + " | " + pq[1]);
            System.out.println("i: " + i + " tempo: " + (tempoFinal - tempoInicial) / 1000d);

            vet.add((float) ((tempoFinal - tempoInicial) / 1000d));
        }*/

        /*tempoInicial = System.currentTimeMillis();
        RSA rsa = new RSA(12);
        Fatoracao fatoracao = new Fatoracao();
        System.out.println(rsa.getP() + " | " + rsa.getQ());

        BigInteger[] pq = fatoracao.fatoracaoPQ(rsa.getChavePublica()[0]);
        tempoFinal = System.currentTimeMillis();
        System.out.print((tempoFinal - tempoInicial) / 1000d);*/

        //processoDeFatoracao.add((float) ((tempoFinal - tempoInicial) / 1000d));
        /*
        //vetores python
        //geracao de chaves
        System.out.print("geracaoDeChaves = [");
        for(int i=0; i<geracaoDeChaves.size(); i++)
            System.out.print(geracaoDeChaves.get(i) + ", ");
        System.out.print("]\n");

        //processo de Criptografia
        System.out.print("processoDeCriptografia = [");
        for(int i=0; i<processoDeCriptografia.size(); i++)
            System.out.print( processoDeCriptografia.get(i) + ", ");
        System.out.print("]\n");

        //processo de Descriptografia
        System.out.print("processoDeDescriptografia = [");
        for(int i=0; i<processoDeDescriptografia.size(); i++)
            System.out.print(processoDeDescriptografia.get(i) + ", ");
        System.out.print("]\n");

        System.out.print("tamanho da chave = [");
        for(int i =64; i<=1024; i+=64)
            System.out.print(i + ", ");
        System.out.print("]\n");
        */
        //fatoracao
        /*
        System.out.printf("processoDeFatoracao = [");
        for(int i=0; i<processoDeFatoracao.size(); i++)
            System.out.printf("%.f, ", processoDeFatoracao.get(i));
        System.out.printf("]\n");*/


        /*System.out.println("Precione enter para continuar");
        {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }*/



        //System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }

}