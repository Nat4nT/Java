import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class HashList {
    HashMap<String,ArrayList<String>> aniversariantes;    
    BufferedReader reader;

    public static void main(String[] args) {
        HashList dataNiver = new HashList();
        dataNiver.reader = new BufferedReader(new InputStreamReader(System.in));
        dataNiver.aniversariantes = new HashMap<String,ArrayList<String>>();
       
        dataNiver.menu();

    }

    public void menu(){
        System.out.println("-------------------MENU---------------");
        System.out.println("1 - Cadastrar Data Aniversariante");
        System.out.println("2 - Listar Datas Cadastradas");
        System.out.println("3 - Consultar Data Especifica");
        System.out.println("4 - Sair");
        System.out.println("---------------------------------------");
        cases();
    }

    public void cases(){
        try {
            String choice = reader.readLine();
            switch(choice){
                case "1":
                    System.out.println("Informe dia/mes (dd/mm) para cadastro");
                    String data = this.reader.readLine();
                    System.out.println("Informe o nome");
                    String nome = this.reader.readLine();
                    this.adicionarRegistro(data, nome);
                    menu();
                    break;
                case "2":
                    listarDatas();
                    menu();
                    break;
                case "3":
                    System.out.println("Unforme a data desejada ( padrão dd/mm )");
                    String dataConsulta = this.reader.readLine();
                    consultarData(dataConsulta);
                    menu();
                    break;
                case "4":
                    System.out.println("Encerrando...");
                    break;
                default:
                    menu();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }
    }

    public void adicionarRegistro(String data, String nome){

        if(!this.aniversariantes.containsKey(data)){
            this.aniversariantes.put(data, new ArrayList<String>());
        }

        // ArrayList<String> nomes = this.aniversariantes.get(data);
        // nomes.add(nome);

        this.aniversariantes.get(data).add(nome);

    }


    public void listarDatas(){
        System.out.println("Datas registradas");
        for (String item : this.aniversariantes.keySet()) {
            System.out.println(item);
        }
    }

    public void consultarData(String dataConsulta){
        if (this.aniversariantes.containsKey(dataConsulta)) {
            System.out.println("Registros de pessoas na data "+ dataConsulta);
            ArrayList<String> arrayListNomes = this.aniversariantes.get(dataConsulta);
            for (String pessoa : arrayListNomes) {
                System.out.println(pessoa);
            }
        } else {
            System.out.println("Não há registros nesta data");
        }
    }
}
