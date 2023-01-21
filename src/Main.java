import br.com.bancoada.banco.mensageria.MensageriaDoBanco;
import br.com.bancoada.banco.mensageria.ExceptionSaldoInsuficiente;
import br.com.bancoada.banco.modelo.Cliente;
import br.com.bancoada.banco.modelo.Conta;
import br.com.bancoada.banco.modelo.ContaCorrente;
import br.com.bancoada.banco.modelo.ContaPoupanca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ExceptionSaldoInsuficiente, InterruptedException {
        int opcaoContaCorrente = 1;
        int opcaoSacar = 1;
        int opcaoDepositar = 2;
        int opcaoTransferir = 3;
        int opcaoSair = 4;

        MensageriaDoBanco mensageriaDoBanco = new MensageriaDoBanco();
        mensageriaDoBanco.msgInicio();
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        int opcaoEscolhida;

        do {
            mensageriaDoBanco.msgSelecioneUmaOpcao();
            opcaoEscolhida = scanner.nextInt();

            if (opcaoEscolhida == opcaoContaCorrente) {
                mensageriaDoBanco.msgCriacaoContaCorrente();

                ContaCorrente contaCorrente = new ContaCorrente(1212, 1234);
                Cliente cliente = new Cliente(contaCorrente);

                Conta contaCorrente2 = new ContaCorrente(1212, 4567);
                contaCorrente2.setTitular("Anderson Piotto Leite");

                mensageriaDoBanco.msgDeCadastro();

                cliente.formularioCLiente();

                contaCorrente.dadosDaConta();
                System.out.println("Seja Bem Vindo Sr(a): " + cliente.getNome());
                Thread.sleep(5000);

                mensageriaDoBanco.msgOperacaoConta();

                opcaoEscolhida = scanner.nextInt();
                if (opcaoEscolhida == opcaoSacar) {
                    Scanner entradaSaque = new Scanner(System.in);
                    mensageriaDoBanco.msgSaque();
                    Double saque = entradaSaque.nextDouble();
                    try {
                        contaCorrente.sacar(saque);
                        System.out.println(contaCorrente.msgSaqueRealizao());
                    } catch (ExceptionSaldoInsuficiente exceptionSaldoInsuficiente) {
                        System.out.println(exceptionSaldoInsuficiente.getMessage());

                        mensageriaDoBanco.msgRetornarMenu();

                        opcaoEscolhida = scanner.nextInt();

                            if (opcaoEscolhida != opcaoSair) {
                                mensageriaDoBanco.msgOperacaoConta();
                                opcaoEscolhida = scanner.nextInt();
                                while (opcaoEscolhida  != opcaoDepositar){
                                    mensageriaDoBanco.msgOperacaoConta();
                                    opcaoEscolhida = scanner.nextInt();
                                }
                            } else {//
                                mensageriaDoBanco.msgSaidaSIstema();
                                break;
                            }
                    }
                }
                if (opcaoEscolhida == opcaoDepositar) {
                    Scanner entradaValorDeposito = new Scanner(System.in);
                    mensageriaDoBanco.msgDeposito();
                    Double deposito = entradaValorDeposito.nextDouble();

                    contaCorrente.depositar(deposito);
                    System.out.println(contaCorrente.msgDeposito());
                    Thread.sleep(5000);

                    mensageriaDoBanco.msgMaisAlgumaOperacao();
                    mensageriaDoBanco.msgOperacaoConta();

                    opcaoEscolhida = scanner.nextInt();
                    if (opcaoEscolhida != opcaoSair) {
//                        Scanner entradaSaque = new Scanner(System.in);
//                        Double saque = entradaSaque.nextDouble();

                        if (opcaoEscolhida == opcaoSacar) {
                            mensageriaDoBanco.msgSaque();
                            Scanner entradaSaque = new Scanner(System.in);
                            Double saque = entradaSaque.nextDouble();
                            contaCorrente.sacar(saque);
                            System.out.println(contaCorrente.msgSaqueRealizao());
                        }
                        if (opcaoEscolhida == opcaoTransferir) {
                            mensageriaDoBanco.msgTrasnferencia();
                            Scanner entradaSaque = new Scanner(System.in);
                            Double transferencia = entradaSaque.nextDouble();
                            contaCorrente.transferir(contaCorrente2, transferencia);
                            System.out.println("\033[1;32mTransferencia de R$ " + transferencia + " realizado com sucesso!!" +
                                    "\nPara: Sr(a): " + contaCorrente2.getTitular());
                        }
                    } else {
                        mensageriaDoBanco.msgSaidaSIstema();
                        break;
                    }
                }
                mensageriaDoBanco.msgSaidaSIstema();
                break;
            }
            if (opcaoEscolhida == opcaoDepositar) {
                mensageriaDoBanco.msgCriacaoContaPoupanca();

                ContaPoupanca contaPoupanca = new ContaPoupanca(1212, 5432);
                Cliente cliente = new Cliente(contaPoupanca);
                ContaPoupanca contaPoupanca2 = new ContaPoupanca(1212, 5454);
                contaPoupanca2.setTitular("Anderson Piotto Leite");

                mensageriaDoBanco.msgDeCadastro();
                cliente.formularioCLiente();

                contaPoupanca.dadosDaConta();
                System.out.println("Seja Bem Vindo Sr(a): " + cliente.getNome());
                Thread.sleep(5000);
                mensageriaDoBanco.msgOperacaoConta();

                opcaoEscolhida = scanner.nextInt();
                if (opcaoEscolhida == opcaoSacar) {
                    Scanner entradaSaque = new Scanner(System.in);
                    mensageriaDoBanco.msgSaque();
                    Double saque = entradaSaque.nextDouble();
                    try {
                        contaPoupanca.sacar(saque);
                        System.out.println(contaPoupanca.msgSaqueRealizao());
                    } catch (ExceptionSaldoInsuficiente exceptionSaldoInsuficiente) {
                        System.out.println(exceptionSaldoInsuficiente.getMessage());
                        mensageriaDoBanco.msgRetornarMenu();
                        opcaoEscolhida = scanner.nextInt();
                        if (opcaoEscolhida != opcaoSair) {
                            mensageriaDoBanco.msgOperacaoConta();
                            opcaoEscolhida = scanner.nextInt();
                        } else {
                            mensageriaDoBanco.msgSaidaSIstema();
                            break;
                        }
                    }
                    if (opcaoEscolhida == opcaoDepositar) {
                        Scanner entradaValorDeposito = new Scanner(System.in);
                        mensageriaDoBanco.msgDeposito();
                        Double deposito = entradaValorDeposito.nextDouble();

                        contaPoupanca.depositar(deposito);
                        System.out.println(contaPoupanca.msgDeposito());
                        Thread.sleep(5000);

                        mensageriaDoBanco.msgMaisAlgumaOperacao();
                        mensageriaDoBanco.msgOperacaoConta();

                        opcaoEscolhida = scanner.nextInt();
                        if (opcaoEscolhida != opcaoSair) {
                            Scanner valorDepositado = new Scanner(System.in);
                            mensageriaDoBanco.msgDeposito();
                            Double valorParaDeposito = valorDepositado.nextDouble();

                            if (opcaoEscolhida == opcaoSacar) {
                                contaPoupanca.sacar(valorParaDeposito);
                                System.out.println(contaPoupanca.msgSaqueRealizao());
                            }
                            if (opcaoEscolhida == opcaoTransferir) {
                                contaPoupanca.transferir(contaPoupanca2, saque);
                                System.out.println("\033[1;32mTransferencia de R$ " + saque + " realizado com sucesso!!" +
                                        "\nPara: Sr(a): " + contaPoupanca2.getTitular());

                                mensageriaDoBanco.msgSaidaSIstema();
                                break;
                            }
                        } else {
                            mensageriaDoBanco.msgSaidaSIstema();
                            break;
                        }
                    }
                }
            }
            if (opcaoEscolhida == opcaoSair) {
                mensageriaDoBanco.msgSaidaSIstema();
                break;
            }
        } while (opcaoEscolhida != 4 || opcaoEscolhida < 0 || opcaoEscolhida > 4);

    }
}