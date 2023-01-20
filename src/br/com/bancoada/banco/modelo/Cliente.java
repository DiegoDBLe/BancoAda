package br.com.bancoada.banco.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@ToString
public class Cliente {

    private String nome;

    private String cpf;

    private String profissao;

    private List<String> clientes = new ArrayList<String>();

    public Cliente() {
    }

    public Cliente(ContaCorrente contaCorrente) {
        cadastroCliente();
    }

    public void formularioCLiente() {
        System.out.println("Nome: " + nome +
                "\nCPF: " + cpf +
                "\nProfissao: " + profissao);
    }

    public void incluir() {
        clientes.add(this.nome);
        clientes.add(this.cpf);
        clientes.add(this.profissao);
    }

    public List<String> getClientes() {
        return clientes;
    }

    public void cadastroCliente() {
        Scanner entradaUsuario = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = entradaUsuario.next().toUpperCase();
        setNome(nome.toUpperCase());

        System.out.print("Digite seu CPF:");
        entradaUsuario = new Scanner(System.in);
        String cpf = entradaUsuario.next();
        setCpf(cpf);

        System.out.print("Digite sua Profissão: ");
        entradaUsuario = new Scanner(System.in);
        String profissao = entradaUsuario.next().toUpperCase();
        setProfissao(profissao.toUpperCase());

        incluir();
    }

}
