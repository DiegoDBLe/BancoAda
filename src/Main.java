import br.com.bancoada.banco.modelo.Conta;
import br.com.bancoada.banco.modelo.ContaCorrente;
import br.com.bancoada.banco.modelo.SaldoInsuficienteException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SaldoInsuficienteException, IOException, ClassNotFoundException {

        System.out.println("\033[32m------- Teste do Método sacar: ------- \033[m");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor que deseja sacar R$ ");
        Double saque = scanner.nextDouble();

        Conta contaCorrente = new ContaCorrente(123, 432);
        contaCorrente.depositar(100);

        try{
            contaCorrente.sacar(saque);
            System.out.println(contaCorrente.msgSaque());
        }catch (SaldoInsuficienteException saldoInsuficienteException){
            System.out.println(saldoInsuficienteException.getMessage());
        }

    }
}