package classes;

import java.io.IOException;
import java.util.ArrayList;

public class TestesGraficos {
    private int NUMERO_DE_TESTES;

    public TestesGraficos(int n){
        this.NUMERO_DE_TESTES = n;
    }

    public void testar() throws IOException {
        ArrayList<Float> geracaoDeChaves = allocaArrayZero(1024/64);
        ArrayList<Float> processoDeCriptografia = allocaArrayZero(1024/64);
        ArrayList<Float> processoDeDescriptografia = allocaArrayZero(1024/64);


        for (int i=0; i<NUMERO_DE_TESTES; i++){
            ArrayList<Float> aux0 = new ArrayList<>();
            ArrayList<Float> aux1 = new ArrayList<>();
            ArrayList<Float> aux2 = new ArrayList<>();
            for(int j=64; j<=1024; j+=64) {

                //gerar chaves
                long tempoInicial = System.currentTimeMillis();
                RSA rsa = new RSA(j);
                long tempoFinal = System.currentTimeMillis();
                aux0.add((float) ((tempoFinal - tempoInicial) / 1000d));

                //processoDeCriptografia
                Cripto cripto = new Cripto(rsa);
                tempoInicial = System.currentTimeMillis();
                cripto.criptografa();
                tempoFinal = System.currentTimeMillis();
                aux1.add((float) ((tempoFinal - tempoInicial) / 1000d));

                //processoDeDescriptografia
                tempoInicial = System.currentTimeMillis();
                cripto.descriptografa();
                tempoFinal = System.currentTimeMillis();
                aux2.add((float) ((tempoFinal - tempoInicial) / 1000d));

            }
            geracaoDeChaves = somaArrays(geracaoDeChaves, aux0);
            processoDeCriptografia = somaArrays(geracaoDeChaves, aux1);
            processoDeDescriptografia = somaArrays(geracaoDeChaves, aux2);
        }

        //calculo estatisto de testes
        for(int i=0; i< geracaoDeChaves.size(); i++){
            geracaoDeChaves.set(i, geracaoDeChaves.get(i)/NUMERO_DE_TESTES);
        }

        for(int i=0; i< processoDeCriptografia.size(); i++){
            processoDeCriptografia.set(i, processoDeCriptografia.get(i)/NUMERO_DE_TESTES);
        }

        for(int i=0; i< processoDeDescriptografia.size(); i++){
            processoDeDescriptografia.set(i, processoDeDescriptografia.get(i)/NUMERO_DE_TESTES);
        }


        System.out.print("geracaoDeChaves = ");
        printaTeste(geracaoDeChaves);
        System.out.println();

        System.out.print("processoDeCriptografia = ");
        printaTeste(processoDeCriptografia);
        System.out.println();

        System.out.print("processoDeDescriptografia = ");
        printaTeste(processoDeDescriptografia);
        System.out.println();

    }

    public void testarFatoracao(){
        System.out.print("fatoracao = ");
        printaTeste(fatoracao());
        System.out.println();
    }

    private ArrayList<Float> fatoracao(){
        ArrayList<Float> retorno = allocaArrayZero(32/2);
        for (int i=0; i<NUMERO_DE_TESTES; i++){
            ArrayList<Float> aux = new ArrayList<>();
            for(int j=8; j<=32; j+=2) {
                //gerar chaves
                RSA rsa = new RSA(j);
                long tempoInicial = System.currentTimeMillis();
                new Fatoracao().fatoracaoPQ(rsa.getChavePublica()[0]);
                long tempoFinal = System.currentTimeMillis();
                System.out.println("J: " + j + " aux: " + (tempoFinal - tempoInicial) / 1000d);
                aux.add((float) ((tempoFinal - tempoInicial) / 1000d));
            }
            System.out.print("aux: ");
            printaTeste(aux);
            retorno = somaArrays(retorno, aux);
        }

        for(int i=0; i< retorno.size(); i++){
            retorno.set(i, retorno.get(i)/NUMERO_DE_TESTES);
        }
        return retorno;
    }

    private ArrayList<Float> somaArrays(ArrayList<Float> a, ArrayList<Float> b){
        ArrayList<Float> retorno = new ArrayList<>();
        for(int i=0; i<a.size(); i++){
            retorno.add(a.get(i) + b.get(i));
        }
        return retorno;
    }
    private void printaTeste(ArrayList<Float> teste){
        System.out.print("[");
        for(int i=0; i<teste.size(); i++){
            if(i == teste.size()-1)
                System.out.print(teste.get(i));
            else
                System.out.print(teste.get(i) + ", ");
        }
        System.out.print("]");
    }
    private ArrayList<Float> allocaArrayZero(int n){
        ArrayList<Float> retorno = new ArrayList<>();
        for (int i=0; i<n;i++){
            retorno.add((float) 0);
        }
        return retorno;
    }
}
