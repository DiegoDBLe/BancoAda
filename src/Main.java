import br.com.bancoada.banco.mensageria.MensageriaInicioBanco;
import br.com.bancoada.banco.modelo.Cliente;
import br.com.bancoada.banco.modelo.ContaCorrente;
import br.com.bancoada.banco.mensageria.SaldoInsuficienteException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SaldoInsuficienteException, IOException, ClassNotFoundException, InterruptedException {

        MensageriaInicioBanco msgInicioBanco = new MensageriaInicioBanco();
        msgInicioBanco.msgInicio();
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        int opcaoEscolhida;

        do{
            msgInicioBanco.msgSelecioneUmaOpcao();
            opcaoEscolhida = scanner.nextInt();

            if (opcaoEscolhida == 1) {
                System.out.println("Opção escolhida: 1\nCriando Conta Corrente:");

                ContaCorrente contaCorrente = new ContaCorrente(1212, 1234);
                Cliente cliente = new Cliente(contaCorrente);
//                cliente.cadastroCliente();

                msgInicioBanco.msgDeCadastro();
                cliente.formularioCLiente();
                final double saldo = contaCorrente.getSaldo();
                System.out.println("Saldo: R$ " + saldo);
                break;
            }
        }while (opcaoEscolhida != 4 || opcaoEscolhida < 0 || opcaoEscolhida > 4);











//        System.out.println("\033[32m------- Teste do Método sacar: ------- \033[m");
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Digite o valor que deseja sacar R$ ");
//        Double saque = scanner.nextDouble();
//
//        Conta contaCorrente = new ContaCorrente(123, 432);
//        contaCorrente.depositar(100);
//
//        try{
//            contaCorrente.sacar(saque);
//            System.out.println(contaCorrente.msgSaque());
//        }catch (SaldoInsuficienteException saldoInsuficienteException){
//            System.out.println(saldoInsuficienteException.getMessage());
//        }

    }
}