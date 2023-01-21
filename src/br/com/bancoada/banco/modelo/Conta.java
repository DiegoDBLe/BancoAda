package br.com.bancoada.banco.modelo;

import br.com.bancoada.banco.mensageria.ExceptionContaNegativa;
import br.com.bancoada.banco.mensageria.ExceptionSaldoInsuficiente;
import lombok.Getter;
import lombok.Setter;

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

    private String titular;

    private static int total = 0;

    public Conta(int agencia, int numeroConta){
        Conta.total++;
        System.out.println("Total Contas: " + Conta.total );

        this.agencia = agencia;
        this.numeroConta = numeroConta;
        setSaldo(0.0);
    }

    public abstract void depositar(double valor);

    public void sacar(double valor) throws ExceptionSaldoInsuficiente {
        if(this.saldo < valor){
            throw new ExceptionSaldoInsuficiente(msgSladoInsuficiente());
        }else {
            this.saldo -= valor;
        }
    }
    public void transferir(Conta destino, double valor) throws ExceptionSaldoInsuficiente {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void setNumeroConta(int numeroConta) throws ExceptionContaNegativa {
        if(numeroConta <= 0){
          throw new ExceptionContaNegativa(msgContaNegativaException());
        }
        this.numeroConta = numeroConta;
        }

    public void setAgencia(int agencia) {
        if (agencia <= 0){
            System.out.println("\033[1;31mNúmero da Agência não pode ser menor ou igual a 0\033[m");
            return;
        }
        this.agencia = agencia;
    }

    public  String msgContaNegativaException(){
        return "\033[1;31mNúmero da Conta não pode ser menor ou igual a 0\033[m";
    }
    public String msgSladoInsuficiente(){
        return "\033[1;31mSaldo Insuficiente!!\033[m" + "\nSaldo Disponivel R$: " + this.saldo;
    }

    public String msgSaqueRealizao(){
        String  msg = "\033[1;32mSaque Realizado com sucesso!!\033[m" + "\nSaldo Disponivel R$: " + this.saldo;
        return msg;
    }

    public String msgDeposito(){
        String  msg = "\033[1;32mDepósito Realizado com sucesso!!\033[m" + "\nSaldo Disponivel R$: " + this.saldo;
        return msg;
    }

}
