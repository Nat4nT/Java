import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Sistema {
    BufferedReader reader;
    ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    ArrayList<Orcamento> listaOrcamento = new ArrayList<Orcamento>();

    public static void main(String[] args)throws Exception {
        Sistema sistema = new Sistema();
        sistema.menu();
    }
    
    public void menu()throws Exception{
        System.out.println("---------------MENU------------");
        System.out.println("1-Cadastrar Cliente");
        System.out.println("2-Listar Clientes");
        System.out.println("3-Cadastrar Orçamento");
        System.out.println("4-Listar Orçamentos de um Cliente");
        System.out.println("5-Encerrar");
        System.out.println("---------------------------------");
        cases();
    }

    public void cases()throws Exception{
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = reader.readLine();
        switch(choice){
            case "1":
                cadastro();
                menu();
                break;
            case "2":
                listar();
                menu();
                break;
            case "3":
                cadastroOrcamento();
                menu();
                break;
            case "4":
                System.out.println("Entre com o numero de telefone do cliente que deseja ver os orçamentos");
                String telefone = reader.readLine();
                listarOrcamentos(telefone);
                menu();
                break;
            case "5":
                System.out.println("Encerrando...");
                break;
            default:
                menu();
                break;
        }

    }

    public void cadastro()throws Exception{
        boolean verification = false;
        Cliente cliente = new Cliente();
        System.out.println("Entre com o nome do Cliente");
        cliente.setNome(this.reader.readLine());
        while(!verification){
            System.out.println("Entre com o número de telefone do cliente");
            String telefone = reader.readLine();
            if(!telefone.equals("")){
                cliente.setTelefone(telefone);
                verification = !verification;
                this.listaCliente.add(cliente);
                System.out.println("Cliente cadastrado");
            }else{
                System.out.println("Por favor entre com um número valido");
            }
        }
    }

    public void listar(){
        Iterator<Cliente> listarClientes = listaCliente.iterator();
        while(listarClientes.hasNext()){
            Cliente clie = listarClientes.next();
            System.out.println("Nome: " + clie.getNome() + " Telefone: " + clie.getTelefone() );
        }
    }

    public void cadastroOrcamento()throws Exception{
        Iterator<Cliente> listarClientes = listaCliente.iterator();
        boolean again = true;

        System.out.println("Entre com o numero de telefone do cliente que deseja adicionar um orçamento");
        String telefone = reader.readLine();

        while(listarClientes.hasNext()){
            if (listarClientes.next().getTelefone().equals(telefone)) {
                while(again){

                    System.out.println("Entre com o nome do item que deseja orçar");
                    String nomeItem = reader.readLine();
                    System.out.println("Entre com a quantidade que deseja orçar");
                    String quantidade = reader.readLine();
                   
                    setOrcamento(nomeItem, quantidade);

                    System.out.println("Orçamento Salvo");
                    System.out.println("Deseja adiconar mais um item?");
                    System.out.println("[Y]-Sim [N]-Não");
                    if(reader.readLine().toUpperCase().equals("N")){
                        again = !again;
                    }
                }
            
            }else{
                System.out.println("Numero não encontrado");
            }   
        }
        
    }

    public void setOrcamento(String nomeItem,String quantidade){
        Cliente cli = new Cliente();
        Orcamento orc = new Orcamento();
        orc.setNomeitem(nomeItem);
        if (quantidade.equals("")) {
            orc.setQuantidade(1);
            this.listaOrcamento.add(orc);
            cli.setOrcamentos(listaOrcamento);
        }else{
            orc.setQuantidade(Integer.parseInt(quantidade));
            this.listaOrcamento.add(orc);
            cli.setOrcamentos(listaOrcamento);
        }
    }

    public void listarOrcamentos(String telefone){
        Iterator<Orcamento> listarOrcamento = listaOrcamento.iterator();
        Iterator<Cliente> listarClientes = listaCliente.iterator();
        while(listarClientes.hasNext()){   
            if(listarClientes.next().getTelefone().equals(telefone)){
                while(listarOrcamento.hasNext()){
                    Orcamento item = listarOrcamento.next();
                    System.out.println("Item: "+item.getNomeitem() + " Quantidade: "+ item.getQuantidade());
                }
            }else{
                System.out.println("Telefone não encontrado");
            }
        }
    }
}
