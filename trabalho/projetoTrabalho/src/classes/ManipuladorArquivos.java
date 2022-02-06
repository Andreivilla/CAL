package classes;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class ManipuladorArquivos {
    public void salvarCifrada(BigInteger[] caracteres) throws IOException {
        try {
            OutputStream os = new FileOutputStream(System.getProperty("user.dir") + "\\src\\arquivos\\menssagem.txt"); // nome do arquivo que será escrito
            Writer wr = new OutputStreamWriter(os); // criação de um escritor
            BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

            for(int i=0; i< caracteres.length; i++) {
                br.write(String.valueOf(caracteres[i]));
                br.newLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void salvarDecifrada(String mensagem){
        try {
            OutputStream os = new FileOutputStream(System.getProperty("user.dir") + "\\src\\arquivos\\menssagem.txt"); // nome do arquivo que será escrito
            Writer wr = new OutputStreamWriter(os); // criação de um escritor
            BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

            br.write(mensagem);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String lerDecifrada(){
        Scanner sc;
        try {
            sc = new Scanner(new File(System.getProperty("user.dir") + "\\src\\arquivos\\menssagem.txt"));
        } catch (FileNotFoundException e) {
            sc = new Scanner(System.in);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(sc.hasNext()){

            stringBuilder.append(sc.nextLine());

            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public BigInteger[] lerCifrada(){
        Scanner sc;
        try {
            sc = new Scanner(new File(System.getProperty("user.dir") + "\\src\\arquivos\\menssagem.txt"));
        } catch (FileNotFoundException e) {
            sc = new Scanner(System.in);
        }

        ArrayList<BigInteger> arrayList = new ArrayList<>();
        while (sc.hasNext() == true){
            arrayList.add(new BigInteger(sc.nextLine()));
        }

        BigInteger[] retorno = new BigInteger[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++){
            retorno[i] = arrayList.get(i);
        }

        return retorno;
    }
}