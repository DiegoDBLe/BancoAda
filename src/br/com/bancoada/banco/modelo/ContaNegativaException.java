package br.com.bancoada.banco.modelo;

public class ContaNegativaException extends Throwable {
    public ContaNegativaException(String msgContaNegativaException) {
        super(msgContaNegativaException);
    }
}
