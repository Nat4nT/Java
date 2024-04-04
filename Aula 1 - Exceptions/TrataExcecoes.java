import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TrataExcecoes {
    public static void main(String[] args){
        TrataExcecoes le = new TrataExcecoes();
        le.lerArquivo();

    }   

    public void lerArquivo(){
        try {
            String arqEntrada = "arq.txt";
            BufferedReader arq = new BufferedReader(
               new FileReader(arqEntrada)); 
               String linha;
               while ((linha = arq.readLine()) != null){
                   System.out.println(linha + "\n");
               }
                   arq.close();
        } catch (FileNotFoundException ef) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ei){
            System.out.println("Erro em ler o arquivo");
        } catch (Exception e){
            System.out.println("Erro");
            System.out.println("Detalhes : " + e.getMessage());
        }finally{
            System.out.println("Encerrando...");
        }

    } 
}