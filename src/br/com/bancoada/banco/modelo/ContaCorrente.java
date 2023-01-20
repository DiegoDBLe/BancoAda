package br.com.bancoada.banco.modelo;

import br.com.bancoada.banco.mensageria.SaldoInsuficienteException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCorrente extends Conta implements Impostos{

    private static String titularDaConta;
    private static String profissao;
    private static String cpf;
    public ContaCorrente(int agencia, int numeroConta){
        super(agencia, numeroConta);
        if (agencia != 1212){
            setAgencia(1212);
        }
    }

    @Override
    public void depositar(double valor) {
        super.saldo += valor;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        double valorASacar = valor;
        super.sacar(valorASacar);
        super.saldo -= 0.2;
    }

    @Override
    public double getValorImposto() {
        return super.saldo * 0.1;
    }
}
