public class OperacoesMatematicas {
    public float dividir(float num1 ,float num2)throws DivisaoPorZeroException{
        if(num2 == 0){
            throw new DivisaoPorZeroException();
        }
        return num1 / num2;
    }
}
