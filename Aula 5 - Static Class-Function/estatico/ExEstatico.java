package estatico;
public class ExEstatico {
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.setName("Adriana");
        System.out.println("Quantidade Clientes:(c1) " + c1.qtdeClientes);
        Cliente c2 = new Cliente();
        c1.setName("Adrian");
        System.out.println("Quantidade Clientes:(c2) " + c2.qtdeClientes);
    }
}
