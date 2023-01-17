package br.com.bancoada.banco.modelo;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int agencia, int numeroCOnta) {
        super(agencia, numeroCOnta);
    }

    @Override
    public void depositar(double valor) {
        super.saldo += valor;
    }
}
