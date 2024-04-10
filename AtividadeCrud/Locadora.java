import java.sql.Connection;
import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) throws Exception{
        Locadora loc = new Locadora();
        loc.menuPrincipal();
    }

    public void menuPrincipal(){
        int opcao = -1;
        Scanner scanner = new Scanner(System.in);
        while (opcao != 0) {
			System.out.println("\n-------------------------------");
			System.out.println("MENU PRINCIPAL");            
			System.out.println("[1] Gerenciar Veículos");            
			System.out.println("[2] Gerenciar Vendedores");            
			System.out.println("[0] Sair");            
			System.out.println("\n-------------------------------");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Informe um nro inteiro");
            }

            switch (opcao) {
            case 1:
                GerenciadorVeiculo gv = new GerenciadorVeiculo();
                gv.menu();
                break;
            case 2:
                GerenciadorVendedor gve = new GerenciadorVendedor();
                gve.menu();
                break;
            case 0:
                System.out.println("Até logo.");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
            }
        }
    }
}
