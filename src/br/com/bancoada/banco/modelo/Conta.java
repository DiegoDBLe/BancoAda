package br.com.bancoada.banco.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Diego Dantas
 * @version 0.1
 *
 */

@Getter
@Setter
public abstract class Conta {
    protected double saldo;

    private int agencia;

    private int numeroConta;

    private Cliente titular;

    private static int total = 0;

    public Conta(int agencia, int numeroConta){
        Conta.total++;
        System.out.println("Total Contas: " + Conta.total );

        this.agencia = agencia;
        this.numeroConta = numeroConta;
        setSaldo(0.0);
    }

    public abstract void depositar(double valor);

    public void sacar(double valor) throws SaldoInsuficienteException{
        if(this.saldo < valor){
            throw new SaldoInsuficienteException("Saldo insuficiente" + "\nSaldo R$: " + this.saldo +
                    "\nValor R$: " + valor);
        }
        this.saldo -= valor;
    }

    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException{
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void setNumeroConta(int numeroConta) {
        if(numeroConta <= 0){
           System.out.println("Número da Conta não pode ser menor ou igual a 0");
           return;
        }
        this.numeroConta = numeroConta;
        }

    public void setAgencia(int agencia) {
        if (agencia <= 0){
            System.out.println("Número da Agência não pode ser menor ou igual a 0");
            return;
        }
        this.agencia = agencia;
    }
}
