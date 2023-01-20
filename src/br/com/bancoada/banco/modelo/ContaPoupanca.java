package br.com.bancoada.banco.modelo;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int agencia, int numeroCOnta) {
        super(agencia, numeroCOnta);
    }

    @Override
    public void depositar(double valor) {
        super.saldo += valor;
    }
    public void dadosDaConta(){
        System.out.println("Agência: " + super.getAgencia());
        System.out.println("Conta: " + super.getNumeroConta());
        System.out.println("Saldo: " + super.getSaldo());
    }
}
