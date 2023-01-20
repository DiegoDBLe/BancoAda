package br.com.bancoada.banco.mensageria;

public class ContaNegativaException extends Throwable {
    public ContaNegativaException(String msgContaNegativaException) {
        super(msgContaNegativaException);
    }
}
