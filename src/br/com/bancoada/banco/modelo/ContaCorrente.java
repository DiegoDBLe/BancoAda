package br.com.bancoada.banco.modelo;

import br.com.bancoada.banco.mensageria.ExceptionSaldoInsuficiente;
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
        if(valor < 0){
            System.out.println("\033[1;31mValor de deposito NÂO pode ser negativo!!\\033[m");
        }else {
            super.saldo += valor;
        }
    }

    @Override
    public void sacar(double valor) throws ExceptionSaldoInsuficiente {
        double valorASacar = valor;
        super.sacar(valorASacar);
        super.saldo -= 0.2;
    }

    @Override
    public double getValorImposto() {
        return super.saldo * 0.1;
    }
    public void dadosDaConta(){
        System.out.println("Agência: " + super.getAgencia());
        System.out.println("Conta: " + super.getNumeroConta());
        System.out.println("Saldo: " + super.getSaldo());
    }
}
