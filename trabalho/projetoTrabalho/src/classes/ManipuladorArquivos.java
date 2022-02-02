package classes;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class ManipuladorArquivos {
    public void salvarCifrada(BigInteger[] caracteres) throws IOException {
        OutputStream os = new FileOutputStream(System.getProperty("user.dir") + "\\src\\arquivos\\menssagemCifrada.txt"); // nome do arquivo que será escrito
        Writer wr = new OutputStreamWriter(os); // criação de um escritor
        BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer


        for(int i=0; i< caracteres.length; i++) {
            br.write(String.valueOf(caracteres[i]));
            br.newLine();
        }
        br.close();
    }
    public BigInteger[] lerCifrada(){
        Scanner sc;
        try {
            sc = new Scanner(new File(System.getProperty("user.dir") + "\\src\\arquivos\\menssagemCifrada.txt"));
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