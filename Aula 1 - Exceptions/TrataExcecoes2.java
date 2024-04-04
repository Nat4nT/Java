import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TrataExcecoes2 {
    public static void main(String[] args){
        TrataExcecoes2 le = new TrataExcecoes2();
        String resultado = le.lerArquivo();
        System.out.println(resultado);

    }   

    public String lerArquivo(){
        String retorno = "Ok";
        try {
            String arqEntrada = "arq2.txt";
            BufferedReader arq = new BufferedReader(
               new FileReader(arqEntrada)); 
               String linha;
               while ((linha = arq.readLine()) != null){
                   System.out.println(linha + "\n");
               }
                   arq.close();
        } catch (FileNotFoundException ef) {
            retorno = "Arquivo não encontrado";
        } catch (IOException ei){
            retorno = "Erro em ler o arquivo";
        } catch (Exception e){
            retorno="Erro \n" + "Detalhes : " + e.getMessage();
        }finally{
            retorno += "\nEncerrando...";
        }
        return retorno;

    } 
}