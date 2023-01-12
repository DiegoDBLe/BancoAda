import br.com.bancoada.banco.modelo.Cliente;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Diego");
        String nome = cliente.getNome();

        System.out.println(nome);
    }
}