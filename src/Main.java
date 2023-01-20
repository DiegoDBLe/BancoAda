import br.com.bancoada.banco.mensageria.MensageriaInicioBanco;
import br.com.bancoada.banco.modelo.Cliente;
import br.com.bancoada.banco.modelo.Conta;
import br.com.bancoada.banco.modelo.ContaCorrente;
import br.com.bancoada.banco.mensageria.SaldoInsuficienteException;
import br.com.bancoada.banco.modelo.ContaPoupanca;

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
                msgInicioBanco.msgCriacaoContaCorrente();

                ContaCorrente contaCorrente = new ContaCorrente(1212, 1234);
                Cliente cliente = new Cliente(contaCorrente);
                Conta contaCorrente2 = new ContaCorrente(1212, 1234);
                contaCorrente2.setTitular("Anderson Piotto Leite");

                msgInicioBanco.msgDeCadastro();
                cliente.formularioCLiente();
                contaCorrente.dadosDaConta();
                System.out.println("Seja Bem Vindo Sr(a): " + cliente.getNome());
                Thread.sleep(5000);
                msgInicioBanco.msgOperacaoConta();

                    opcaoEscolhida = scanner.nextInt();
                    if (opcaoEscolhida == 1){
                        Scanner entradaSaque = new Scanner(System.in);
                        msgInicioBanco.msgSaque();
                        Double saque = entradaSaque.nextDouble();
                        try{
                            contaCorrente.sacar(saque);
                            System.out.println(contaCorrente.msgSaqueRealizao());
                        }catch (SaldoInsuficienteException saldoInsuficienteException){
                            System.out.println(saldoInsuficienteException.getMessage());
                            msgInicioBanco.msgRetornarMenu();
                            opcaoEscolhida = scanner.nextInt();
                            if(opcaoEscolhida != 4){
                               msgInicioBanco.msgOperacaoConta();
                               opcaoEscolhida = scanner.nextInt();
                            }else {
                                msgInicioBanco.msgSaidaSIstema();
                                break;
                            }
                        }
                    }
                    if (opcaoEscolhida == 2){
                        Scanner entradaValorDeposito = new Scanner(System.in);
                        msgInicioBanco.msgDeposito();
                        Double deposito = entradaValorDeposito.nextDouble();

                        contaCorrente.depositar(deposito);
                        System.out.println(contaCorrente.msgDeposito());
                        Thread.sleep(5000);

                        msgInicioBanco.msgMaisAlgumaOperacao();
                        msgInicioBanco.msgOperacaoConta();

                        opcaoEscolhida = scanner.nextInt();
                        if(opcaoEscolhida != 4){
                            Scanner entradaSaque = new Scanner(System.in);
                            msgInicioBanco.msgSaque();
                            Double saque = entradaSaque.nextDouble();
                            if(opcaoEscolhida == 1){
                                contaCorrente.sacar(saque);
                                System.out.println(contaCorrente.msgSaqueRealizao());
                            } if (opcaoEscolhida == 3) {
                                contaCorrente.transferir(contaCorrente2, saque);
                                System.out.println("\033[1;32mTransferencia de R$ " + saque + " realizado com sucesso!!" +
                                        "\nPara: Sr(a): " + contaCorrente2.getTitular());
                            }
                        }else {
                            msgInicioBanco.msgSaidaSIstema();
                            break;
                        }
                    }
                break;
            }
            if (opcaoEscolhida == 2){
                msgInicioBanco.msgCriacaoContaPoupanca();

                ContaPoupanca contaPoupanca = new ContaPoupanca(1212, 5432);
                Cliente cliente = new Cliente(contaPoupanca);
                ContaPoupanca contaPoupanca2 = new ContaPoupanca(1212, 5454);
                contaPoupanca2.setTitular("Anderson Piotto Leite");

                msgInicioBanco.msgDeCadastro();
                cliente.formularioCLiente();

                contaPoupanca.dadosDaConta();
                System.out.println("Seja Bem Vindo Sr(a): " + cliente.getNome());
                Thread.sleep(5000);
                msgInicioBanco.msgOperacaoConta();

                opcaoEscolhida = scanner.nextInt();
                if (opcaoEscolhida == 1){
                    Scanner entradaSaque = new Scanner(System.in);
                    msgInicioBanco.msgSaque();
                    Double saque = entradaSaque.nextDouble();
                    try{
                        contaPoupanca.sacar(saque);
                        System.out.println(contaPoupanca.msgSaqueRealizao());
                    }catch (SaldoInsuficienteException saldoInsuficienteException){
                        System.out.println(saldoInsuficienteException.getMessage());
                        msgInicioBanco.msgRetornarMenu();
                        opcaoEscolhida = scanner.nextInt();
                        if(opcaoEscolhida != 4){
                            msgInicioBanco.msgOperacaoConta();
                            opcaoEscolhida = scanner.nextInt();
                        }else {
                            msgInicioBanco.msgSaidaSIstema();
                            break;
                        }
                    }
                }
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