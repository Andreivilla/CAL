package classes;

import java.io.IOException;
import java.math.BigInteger;

public class Cripto {
    private RSA rsa;
    private ManipuladorArquivos manipuladorArquivos = new ManipuladorArquivos();

    public Cripto(RSA rsa){
        this.rsa = rsa;
    }

    public void criptografa() throws IOException {
        BigInteger[] cifrada = rsa.cifrando(manipuladorArquivos.lerDecifrada(), rsa.getChavePublica()[0], rsa.getChavePublica()[1]);
        manipuladorArquivos.salvarCifrada(cifrada);
    }

    public void descriptografa(){
        String decifrada = rsa.decifrando(manipuladorArquivos.lerCifrada(), rsa.getChavePublica()[0], rsa.getChavePrivada());
        manipuladorArquivos.salvarDecifrada(decifrada);
    }

}
