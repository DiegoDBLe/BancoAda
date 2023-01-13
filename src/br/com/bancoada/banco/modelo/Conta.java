package br.com.bancoada.banco.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

/**
 *
 * @author Diego Dantas
 * @version 0.1
 *
 */

@Getter
@Setter
public class Conta {
    protected double saldo;

    private int agencia;

    private int numeroConta;

    private Cliente titular;

    private static int total = 0;

    public Conta(int agencia, int numeroConta){
        Conta.total++;
        System.out.println("Total Conta " + Conta.total );

        this.agencia = agencia;
        this.numeroConta = numeroConta;
        setSaldo(0.0);
    }

    public Cliente getTitular() {
        if (titular == null){
            System.out.println("Nome do Cliente não informado!! Por Favor informar nome do Cliente: ");
            Scanner scanner = new Scanner(System.in);
            titular = new Cliente();
            scanner.hasNext();
            titular.setNome(scanner.next());
        }
        return titular;
    }
}
