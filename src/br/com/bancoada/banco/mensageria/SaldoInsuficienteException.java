package br.com.bancoada.banco.mensageria;

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String message) {
        super(message);
    }

    public String contaNegativaException(String message) {
        return(message);
    }
}
