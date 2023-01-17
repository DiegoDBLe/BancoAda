import br.com.bancoada.banco.modelo.Cliente;
import br.com.bancoada.banco.modelo.Conta;
import br.com.bancoada.banco.modelo.ContaCorrente;
import br.com.bancoada.banco.modelo.SaldoInsuficienteException;

public class Main {
    public static void main(String[] args) throws SaldoInsuficienteException {

//        Cliente cliente = new Cliente();
//        cliente.setNome("Diego");
//        String nome = cliente.getNome();
//
//        System.out.println(nome);
//
//        Conta conta = new Conta(123, 432);
//        System.out.println(conta.getSaldo());
//        System.out.println(conta.getTitular());
//
//        Conta conta1 = new Conta(123, 432);
//        System.out.println(conta1.getSaldo());
//        System.out.println(conta1.getTitular());

        ContaCorrente contaCorrente = new ContaCorrente(123, 432);
        double saldo = contaCorrente.getSaldo();
        System.out.println("Saldo: " + saldo);

        contaCorrente.depositar(100);
        double saldoDepositado = contaCorrente.getSaldo();
        System.out.println("Saldo: " + saldoDepositado);
        contaCorrente.sacar(50);
        System.out.println("Saldo: " + contaCorrente.getSaldo());


    }
}