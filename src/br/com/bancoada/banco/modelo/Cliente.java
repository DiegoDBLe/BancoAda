package br.com.bancoada.banco.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cliente {

    private String nome;

    private String cpf;

    private String profissao;

}
