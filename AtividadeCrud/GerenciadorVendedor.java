import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

public class GerenciadorVendedor {
    Scanner scanner;
    DaoVendedor daoVendedor;

    public GerenciadorVendedor(){
        scanner = new Scanner(System.in);
        daoVendedor = new DaoVendedor();
    }

    public void menu(){
        int opcao = -1;
        while (opcao != 0) {
			System.out.println("\n-------------------------------");
			System.out.println("Gerenciamento de Vendedores");            
			System.out.println("[1] Cadastrar");            
			System.out.println("[2] Consultar");            
			System.out.println("[3] Alterar");            
			System.out.println("[4] Excluir");            
			System.out.println("[5] Listar Todos");            
			System.out.println("[0] Sair");            
			System.out.println("\n-------------------------------");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Informe um nro inteiro");
            }

            switch (opcao) {
            case 1:
                this.cadastrar();
                break;
            case 2:
                this.consultar();
                break;
            case 3:
                this.alterar();
                break;
            case 4:
                this.excluir();
                break;
            case 5:
                this.listarTodos();
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

    public void cadastrar(){
        Vendedor ve = new Vendedor();
        System.out.println("------------------------------");
        System.out.println("[Cadastro de Vendedor]");
        System.out.println("Nome: ");
        ve.setNome(scanner.nextLine());
        System.out.println("Sobrenome: ");
        ve.setSobrenome(scanner.nextLine());
        System.out.println("Nacionalidade: ");
        ve.setNacionalidade(scanner.nextLine());
        System.out.println("Ano Nascimento: ");
        ve.setAno_nascimento(Integer.parseInt(scanner.nextLine()));

        //passa para a camada model
        boolean inserido = daoVendedor.inserir(ve);
        if(inserido){
            System.out.println("Inserido com sucesso.");
        }
    }

    public void listarTodos(){
        ArrayList<Vendedor> vendedor = daoVendedor.buscarTodos();
        System.out.println("----------------------------");
        System.out.println("Vendedores Cadastrados");
        for(Vendedor v : vendedor){
            System.out.println("Código: " + v.getCodigo()
                + ", Nome: " + v.getNome()
                + ", Sobrenome: " + v.getSobrenome()
                + ", Nacionalidade: " + v.getNacionalidade()
                + ", Ano Nascimento: " + v.getAno_nascimento());
        }
    }

    public void excluir(){
        System.out.println("----------------------------");
        System.out.println("Exclusão de Vendedor");
        System.out.println("Código:");
        int codigo = Integer.parseInt(scanner.nextLine());
        int qtde = daoVendedor.excluir(codigo);
        if(qtde > 0){
            System.out.println("Excluído com sucesso.");
        }else{
            System.out.println("Não encontrado...");
        }
    }

    public void consultar(){
        System.out.println("----------------------------");
        System.out.println("Consulta de Vendedor");
        System.out.println("Código:");
        int codigo = Integer.parseInt(scanner.nextLine());
        
        Vendedor ve = daoVendedor.consultar(codigo);
        if(ve != null){
            System.out.println("[Dados do Vendedor]");
            System.out.println("Código: " + ve.getCodigo());
            System.out.println("Nome: " + ve.getNome());
            System.out.println("Sobrenome: " + ve.getSobrenome());
            System.out.println("Nacionalidade: " + ve.getNacionalidade());
            System.out.println("Ano Nascimento: " + ve.getAno_nascimento());
        }else{
            System.out.println("Não encontrado...");
        }
    }

    public void alterar(){
        System.out.println("----------------------------");
        System.out.println("Alteração de Vendedor");
        System.out.println("Código:");
        int codigo = Integer.parseInt(scanner.nextLine());
        Vendedor ve = daoVendedor.consultar(codigo);

        if(ve != null){
            System.out.println("[Dados do Vendedor]");
            System.out.println("[Código: " + ve.getCodigo() + "]");

            System.out.println("[Nome: " + ve.getNome() + "]");
            String nome = scanner.nextLine();
            if(!nome.isEmpty()){
                ve.setNome(nome);
            }

            System.out.println("[Sobrenome: " + ve.getSobrenome() + "]");
            String sobrenome = scanner.nextLine();
            if(!sobrenome.isEmpty()){
                ve.setSobrenome(sobrenome);
            }

            System.out.println("[Nacionalidade: " + ve.getNacionalidade() + "]");
            String nacionalidade = scanner.nextLine();
            if(!nacionalidade.isEmpty()){
                ve.setNacionalidade(nacionalidade);
            }

            System.out.println("[Ano nascimento: " + ve.getAno_nascimento() + "]");
            String ano_nascimento = scanner.nextLine();
            if(!ano_nascimento.isEmpty()){
                ve.setAno_nascimento(Integer.parseInt(ano_nascimento));
            }

            int qtdeAlterado = daoVendedor.alterar(ve);
            if(qtdeAlterado > 0){
                System.out.println("Atualizado com sucesso.");
            }else{
                System.out.println("Não foi possível atualizar.");
            }
        }else{
            System.out.println("Não encontrado...");
        }        
    }
}
