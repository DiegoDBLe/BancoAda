package br.com.bancoada.banco.modelo;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class CalculadoraDeImpostos {

    private double totalImposto;

    public void registraImposto(@NotNull Impostos impostos){
        double valorImposto = impostos.getValorImposto();
        this.totalImposto += valorImposto;
    }
}
