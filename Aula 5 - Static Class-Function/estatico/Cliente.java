package estatico;
public class Cliente {
    private String name;
    private String email;
    public static int qtdeClientes;

    public Cliente(){
        qtdeClientes++;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
 
}
