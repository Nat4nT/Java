public class ExemploExcecao {
    public static void main(String[] args) {
        ExemploExcecao ee = new ExemploExcecao();
        ee.calcular();
    }

    public void calcular(){
        try {
            OperacoesMatematicas op = new OperacoesMatematicas();
            float res;
            res = op.dividir(4, 2);
            System.out.println(res);
            res = op.dividir(3, 0);
            System.out.println(res);
        } catch (DivisaoPorZeroException e) {
            System.out.println(e.getMessage());                   
        }
    }
}
