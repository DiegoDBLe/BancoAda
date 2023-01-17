package br.com.bancoada.banco.modelo;

import lombok.Getter;

@Getter
public class ListaDeContas {

    private Conta[] contas;

    private int posicaoDaConta;

    public ListaDeContas() {
        this.contas = new Conta[10];
        this.posicaoDaConta = 0;
    }

    public void adicionar(Conta conta) {
        this.contas[this.posicaoDaConta] = conta;
        this.posicaoDaConta++;
    }

}
