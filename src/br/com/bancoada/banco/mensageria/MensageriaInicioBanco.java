package br.com.bancoada.banco.mensageria;

import lombok.Getter;

@Getter
public class MensageriaInicioBanco {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private String msgBaertura;

    public void msgInicio(){
        this.msgBaertura = "    \033[34;7m-=-=-=-=-=-Bem Vindo(a) ao Banco Ada -=-=-=-=-=-\033[m   ";
        System.out.println(this.msgBaertura);
    }

    public void msgSelecioneUmaOpcao(){

        System.out.println("\033[4;34;1mDigite uma opção desejada:\033[m ");
        System.out.println("\033[32;m1 - Abrir uma Conta Corrente: \033[m ");
        System.out.println("\033[32;m2 - Abrir uma Conta Poupança: \033[m ");
        System.out.println("\033[32;m3 - Acessar Conta: \033[m ");
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
}
