package br.com.bancoada.banco.mensageria;

public class ExceptionSaldoInsuficiente extends Exception {

    public ExceptionSaldoInsuficiente(String message) {
        super(message);
    }

    public String contaNegativaException(String message) {
        return(message);
    }
}
