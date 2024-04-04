import java.util.HashMap;

public class Dias{
    public static void main(String[] args) {
        HashMap<String, String>  diasSemana = new HashMap<String, String>(); //Criando

        diasSemana.put("SEG", "Segunda-Feira");
        diasSemana.put("TER", "Terça-Feira");
        diasSemana.put("QUA", "Quarta-Feira");
        diasSemana.put("QUI", "Quinta-Feira");
        diasSemana.put("SEX", "Sexta-Feira");
        diasSemana.put("SAB", "Sábado");
        diasSemana.put("DOM", "Domingo");


        //diasSemana.put("SEG", "Segundona") -> Vai sobrescrever a que possui a mesma chave.

        System.out.println("Mostrando os pares armazenados" + diasSemana);

        System.out.println("Verificando se um dia existe");
        System.out.println("QUA existe? " + diasSemana.containsKey("QUA"));
        System.out.println("ASD existe? " + diasSemana.containsKey("ASD"));


        System.out.println("Pegando um item a partir da chave ");
        System.out.println("O valor da chave TER é: " + diasSemana.get("MAR"));


        System.out.println("Quantidade de pares chave-valor: " + diasSemana.size());

        String itemremover = "TER";
        System.out.println("Removendo o item " + itemremover);
        diasSemana.remove(itemremover);

        System.out.println("Quantidade de pares chave-valor: " + diasSemana.size());

        System.out.println("Percorrendo as chaves: ");
        for (String chave : diasSemana.keySet())  {
            System.out.println(chave);
            
        }

        System.out.println("Percorrendo as valores: ");
        for (String valor : diasSemana.values())  {
            System.out.println(valor);            
        }

        System.out.println("Removendo todos os pares: ");
        diasSemana.clear();

        System.out.println("Quantidade de pares chave-valor: " + diasSemana.size());


    }

}