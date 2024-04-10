public class Vendedor{
    private int codigo;
    private String nome;
    private String sobrenome;
    private String nacionalidade;
    private int ano_nascimento;
    

    public int getCodigo() {
      return this.codigo;
    }
    public void setCodigo(int value) {
      this.codigo = value;
    }

    public String getNome() {
      return this.nome;
    }
    public void setNome(String value) {
      this.nome = value;
    }

    public String getSobrenome() {
      return this.sobrenome;
    }
    public void setSobrenome(String value) {
      this.sobrenome = value;
    }

    public String getNacionalidade() {
      return this.nacionalidade;
    }
    public void setNacionalidade(String value) {
      this.nacionalidade = value;
    }

    public int getAno_nascimento() {
      return this.ano_nascimento;
    }
    public void setAno_nascimento(int value) {
      this.ano_nascimento = value;
    }
}