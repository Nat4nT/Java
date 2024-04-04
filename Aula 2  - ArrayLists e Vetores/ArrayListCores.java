import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListCores {
    public static void main(String[] args) {
        String[] vetCores = {"Magenta","Branco","Verde","Azul"};
        ArrayList<String> listaCores = new ArrayList<String>();
        


        System.out.println("Percorrendo vetor com for");
        for(int count = 0;count<vetCores.length;count++){
            System.out.println(vetCores[count]);
        }



        System.out.println("Percorrendo vetor com foreach");

        for(String cor : vetCores){
            System.out.println(cor);
            listaCores.add(cor);
        }

        System.out.println("Percorrendo arrayList com Iterator");
        Iterator<String> it = listaCores.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toUpperCase());
        }

        System.out.println("Percorrendo arrayList com forech");
        for(String cor: listaCores){
            System.out.println(cor);
        }
        
    }
}
