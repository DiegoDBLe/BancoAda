package br.com.bancoada.banco.modelo;

public class ContaCorrente extends Conta implements Impostos{

    public ContaCorrente(int agencia, int numeroConta){
        super(agencia, numeroConta);
    }

    @Override
    public void depositar(double valor) {
        super.saldo += valor;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException{
        double valorASacar = valor;
        super.sacar(valorASacar);
        super.saldo -= 0.2;
    }

    @Override
    public double getValorImposto() {
        return super.saldo * 0.1;
    }
}
