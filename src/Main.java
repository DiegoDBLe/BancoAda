import br.com.bancoada.banco.modelo.Cliente;
import br.com.bancoada.banco.modelo.Conta;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Diego");
        String nome = cliente.getNome();

        System.out.println(nome);

        Conta conta = new Conta(123, 432);
        System.out.println(conta.getSaldo());
        System.out.println(conta.getTitular());

        Conta conta1 = new Conta(123, 432);
        System.out.println(conta1.getSaldo());
        System.out.println(conta1.getTitular());
    }
}