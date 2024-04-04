package explofinal;

public class ExAtributoFinal {
    private final int id = 123;

    public static void main(String[] args) {
        final float pi = 3.14f;

        System.out.println("pi vale: "+ pi);

        // pi=222f; (não aceita pois é final)

        ExAtributoFinal ex = new ExAtributoFinal();
        System.out.println("id = "+ex.id);
        // ex.id = 20;
    }
}
