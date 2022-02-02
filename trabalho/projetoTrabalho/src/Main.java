import classes.ManipuladorArquivos;

import java.io.*;
import java.math.BigInteger;


public class Main {
    public static void main(String[] args) throws IOException {



        /*classes.GeradorDeChaves geradorDeChaves = new classes.GeradorDeChaves(10);

        BigInteger chavePublica[] = geradorDeChaves.getChavePublica();
        BigInteger chavePrivada = geradorDeChaves.getChavePrivada();

        System.out.println("Chave Publica: ");
        System.out.println("[" + chavePublica[0] + ", " + chavePublica[1] + "]");
        System.out.println("Chave privada: ");
        System.out.println(chavePrivada);*/

        //---------------

        /*BigInteger chavePublica[] = new BigInteger[2];
        chavePublica[0] = new BigInteger("13431043770310227308780573336628212913694060823782271897818897753943793116941623828091870950047692605886294476501498991773742373030237888532734957759253650162285154814331264519081310428357404946737684740272735994797059369175788066728861760767648113053167468297483016975627937547826477929655930612724532499327768009881883638924283944114703535751191574316854505862334246896762237689359895643310541788869188013702583941992436337531580042312094421682806017825232034672136898625956648565475857108472899576367228294165434504318703035129510705807631624851527428485819791767201052128576714091576970235880593229166628824116617");
        chavePublica[1] = new BigInteger("5062499386886720618013597564655634549324304024112041256878927291995406957699539412789037901532089388221635700733577566837615852968425416949369464834820065801652618614492354503068419802103947758873150914516830102693177260808664143042013811727756678457877969338475327175391992857004731403211553691187691340895379787126667248232500730758277793971934046251947472391588703520183716318113045216868243424519856213199138448435364025068705957913031887098391131567872733713563056122752786283675069280474261082832062044132522399985614018974138938697857405615963776779988831289228644615984340981293407272886522212163900701196761");
        BigInteger chavePrivada = new BigInteger("5670986516863586781188902311987282678517541544297923148890735183480360051896544817072993351240236508556389910993521005921845866696864625758207634377717102544533406029493067763327670724078925659611370442121295907843897477741468387727135488440242369523579216851773734248477110790779511297059017828002699403887383610978809695238598904151249519135875909037663414353670269027911756955204671728341062615040060091944646379951693537217974418773039064460036083052623969828813253354886263767395323655681650407685331604734279587794978161972125267716807425669551383524419391321776794814283996336946447592348288693982489760478941");
        */

        //-------------

        /*String mensagem = "Andrei";

        BigInteger[] msgCifrada = geradorDeChaves.cifrando(mensagem, chavePublica[0], chavePublica[1]);

        System.out.println(geradorDeChaves.decifrando(msgCifrada, chavePublica[0], chavePrivada));*/


        //ler com scanner
        /*Scanner sc;
        try {
            sc = new Scanner(new File(System.getProperty("user.dir") + "\\src\\arquivos\\menssagemDecifrada.txt"));
        } catch (FileNotFoundException e) {
            sc = new Scanner(System.in);
        }
        BigInteger a = new BigInteger(sc.nextLine());
        System.out.println(a);*/
        //    System.out.println(sc.nextLine());

        //escrever
        /*OutputStream os = new FileOutputStream(System.getProperty("user.dir") + "\\src\\arquivos\\menssagemCifrada.txt"); // nome do arquivo que será escrito
        Writer wr = new OutputStreamWriter(os); // criação de um escritor
        BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

        br.write("Vamos escrever nesse novo arquivo em Java! que legal hahaha!!!");
        br.newLine();
        br.newLine();
        br.write("Vamos escrever outra linha aqui embaixo hahaha!!!");
        br.close();*/

        /*System.out.println("-------------------------------------");
        ManipuladorArquivos manipuladorArquivos = new ManipuladorArquivos();
        manipuladorArquivos.salvarCifrada(msgCifrada);
        manipuladorArquivos.lerCifrada();

        BigInteger[] teste = manipuladorArquivos.lerCifrada();

        for(int i=0; i<teste.length; i++)
            System.out.println(teste[i]);

        System.out.println("--------------------");
        System.out.println(geradorDeChaves.decifrando(msgCifrada, chavePublica[0], chavePrivada));*/
    }

}