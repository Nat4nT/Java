import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String telefone;
    private ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
    
    
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList<Orcamento> getOrcamentos() {
        return orcamentos;
    }
    public void setOrcamentos(ArrayList<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    
    }

    
}
