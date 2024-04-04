import java.util.ArrayList;
import java.util.Iterator;

public class ListagemCliente {
    public static void main(String[] args) {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        Cliente c1 = new Cliente();
        c1.setNome("Natan");
        c1.setCpf("4001");
        c1.setEmail("sadam@flas.com");
        lista.add(c1);
        
        Cliente c2 = new Cliente();
        c2.setNome("Ana");
        c2.setCpf("4100");
        c2.setEmail("Ana@flas.com");
        lista.add(c2);

        Cliente c3 = new Cliente();
        c3.setNome("Taina");
        c3.setCpf("1040");
        c3.setEmail("tata@flas.com");
        lista.add(c3);

        System.out.println("Percorrendo com o Interator");
        Iterator<Cliente> itCliente = lista.iterator();
        while(itCliente.hasNext()){
            Cliente cli = itCliente.next();
            System.out.println("Nome: "+cli.getNome() + " CPF: "+ cli.getCpf() + " E-Mail: "+ cli.getEmail());
        } 


        //Remover da lista
        Cliente cliRemover = new Cliente();
        cliRemover.setCpf("4100");
        Iterator<Cliente> itRemover = lista.iterator();
        while(itRemover.hasNext()){
            if(itRemover.next().getCpf().equals(cliRemover.getCpf())){
                System.out.println("\nRemovendo Cliente ");
                itRemover.remove();
            }
        }

        //Percorrendo com Foreach
        System.out.println("\nPercorrendo com Foreach");
        for(Cliente cliente : lista){
            System.out.println("Nome: "+cliente.getNome()+" CPF:"+cliente.getCpf()+" E-Mail"+cliente.getEmail());
        }

        //Remover com foreach
        //exception ao tentar remover o ultimo item da lista se não colocar um break
        //alternativa usar iterator
        cliRemover.setCpf("1040");
        for (Cliente cli : lista){
            if(cli.getCpf().equals(cliRemover.getCpf())){
                System.out.println("Removendo Cliente " + cli.getNome());
                lista.remove(cli);
                break;
            }
        }

        System.out.println("\nPercorrendo com Foreach");
        for(Cliente cliente : lista){
            System.out.println("Nome: "+cliente.getNome()+" CPF:"+cliente.getCpf()+" E-Mail"+cliente.getEmail());
        }
    }
    
}
