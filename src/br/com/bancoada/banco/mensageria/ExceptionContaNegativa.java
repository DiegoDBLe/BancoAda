package br.com.bancoada.banco.mensageria;

public class ExceptionContaNegativa extends Throwable {
    public ExceptionContaNegativa(String msgContaNegativaException) {
        super(msgContaNegativaException);
    }
}
