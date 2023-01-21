package br.com.bancoada.banco.mensageria;

import br.com.bancoada.banco.modelo.Cliente;
import lombok.Getter;

@Getter
public class MensageriaDoBanco extends Cliente{
    private static final StringBuilder stringBuilder = new StringBuilder();
    private String msgBaertura;

    public void msgInicio(){
        this.msgBaertura = "    \033[34;7m-=-=-=-=-=-Bem Vindo(a) ao Banco Ada -=-=-=-=-=-\033[m   ";
        System.out.println(this.msgBaertura);
    }

    public void msgSelecioneUmaOpcao(){

        System.out.println("\033[4;34;1mDigite uma opção:\033[m ");
        System.out.println("\033[32;m1 - Abrir uma Conta Corrente: \033[m ");
        System.out.println("\033[32;m2 - Abrir uma Conta Poupança: \033[m ");
        System.out.println("\033[32;m3 - Acessar Conta: \033[m ");
        System.out.println("\033[32;m4 - Sair: \033[m ");
        System.out.print("\033[32;m  : \033[m ");

    }

    public void msgOperacaoConta(){
        System.out.println("\033[4;34;7mQual das opções abaixo deseja realizar: \033[m ");
        System.out.println("\033[32;m1 - Sacar: \033[m ");
        System.out.println("\033[32;m2 - Depositar: \033[m ");
        System.out.println("\033[32;m3 - Transferir: \033[m ");
        System.out.println("\033[32;m4 - Sair: \033[m ");
        System.out.print("\033[32;m  : \033[m ");
    }
    public void msgDeCadastro() throws InterruptedException {
        System.out.println("\033[33mProcessando...\033[m");
        barraCarregamento();
        System.out.println("\033[1;32mCADASTRO REALIZADO COM SUCESSO! \033[m");
    }

    public void barraCarregamento() throws InterruptedException {

        for (int i = 0 ; i <= 100 ; i++) {
            stringBuilder.setLength(0);
            for (int j = 0 ; j < i; j++) {
                stringBuilder.append("#");
            }
            Thread.sleep(50);
            System.out.print("[" + String.format("%-100s", stringBuilder) + "] " +  i + "%");
            System.out.print("\r");
        }
    }

    public void msgSaidaSIstema() throws InterruptedException {
        System.out.println("\033[33mSaindo...\033[m");
        Thread.sleep(3000);
        System.out.println("\033[32m----- Obrigado por usar o Banco Ada! -----\033[m");
        System.out.println("\033[32m----- Volte Sempre! -----\033[m");
    }

    public void msgRetornarMenu(){
        System.out.println("\033[4;34;7mDigite 4 para sair ou qualquer outro número para retornar ao menu:\033[m");
    }

    public void msgSaque(){
        System.out.print("Digite o valor que deseja sacar R$ ");
    }

    public void msgTrasnferencia(){
        System.out.print("Digite o valor que deseja transferir R$ ");
    }

    public void msgDeposito(){
        System.out.print("Digite o valor do Depósito R$ ");
    }

    public void msgMaisAlgumaOperacao(){
        System.out.println("\033[4;34;7mDejesa fazer mais alguma operação?\033[m");
    }
    public void msgCriacaoContaCorrente(){
        System.out.println("\033[1;34;mOpcao Selecionada: 1\nCriando Conta Corrente:");
    }

    public void msgCriacaoContaPoupanca(){
        System.out.println("\033[34;1;mOpcao Selecionada: 2\nCriando Conta Poupança:");
    }

}
