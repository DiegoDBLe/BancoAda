package br.com.bancoada.banco.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Locale;

@Getter
@Setter
@ToString
public class Cliente {

    private String nome;

    private String cpf;

    private String profissao;

    public String toString(){
        return "Bem Vindo(a) Sr(a) Nome: " + this.nome.toUpperCase(Locale.ROOT);
    }

    public boolean isEmpty() {
        if (this.nome.isEmpty())
            return false;
        return false;
    }
}
