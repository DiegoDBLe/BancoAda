package br.com.bancoada.banco.modelo;

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
public class Conta {
    protected double saldo;

    private int agencia;

    private int numeroConta;

    private Cliente titular;

    private static int total = 0;

    public Conta(int agencia, int numeroConta){

    }

}
