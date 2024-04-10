import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

public class DaoVendedor {
    private Connection conn;
    private Statement st;
    
    private void conectar(){
        try {
            this.conn = GerenciadorConexao.pegarConexao();
            this.st = conn.createStatement();
        } catch (ClassNotFoundException e1) {
            System.out.println("Erro: " + e1.getMessage());
        }catch(SQLException e2){
            System.out.println("Erro: " + e2.getMessage());
        }
    }

    private void desconectar(){
        try {
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public boolean inserir(Vendedor ve){
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO tb_vendedor VALUES("
                + "NULL, '" +ve.getNome() + "', '" + 
                ve.getSobrenome() + "', '" + ve.getNacionalidade() 
                + "', " + ve.getAno_nascimento()+ ");";
            // System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: "
                + e.getMessage());
        }finally{
            this.desconectar();    
        }
        return resultado;
    }

    public ArrayList<Vendedor> buscarTodos(){
        ArrayList<Vendedor> resultados = new ArrayList<Vendedor>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM tb_vendedor ORDER BY nome");
            while(rs.next()){
                Vendedor ve = new Vendedor();
                ve.setCodigo(rs.getInt("codigo"));
                ve.setNome(rs.getString("nome"));
                ve.setSobrenome(rs.getString("sobrenome"));
                ve.setNacionalidade(rs.getString("nacionalidade"));
                ve.setAno_nascimento(rs.getInt("ano_nascimento"));

                resultados.add(ve);
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultados;
    }

    public int excluir(int cod){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "DELETE FROM tb_vendedor "
                + "WHERE codigo = " + cod + ";";
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }

    public Vendedor consultar(int cod){
        Vendedor ve = null;
        try{
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM tb_vendedor WHERE codigo = "
                    + cod + ";");
            if(rs.next()){
                ve = new Vendedor();
                ve.setCodigo(rs.getInt("codigo"));
                ve.setNome(rs.getString("nome"));
                ve.setSobrenome(rs.getString("sobrenome"));
                ve.setNacionalidade(rs.getString("nacionalidade"));
                ve.setAno_nascimento(rs.getInt("ano_nascimento"));
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }finally{
            this.desconectar();
        }
        return ve;
    }

    public int alterar(Vendedor v){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "UPDATE tb_vendedor SET "
                + " nome = '" + v.getNome() + "', "
                + " sobrenome = '" + v.getSobrenome() + "', "
                + " nacionalidade = '" + v.getNacionalidade() + "', "
                + " ano_nascimento = " + v.getAno_nascimento() 
                + " WHERE codigo = " + v.getCodigo() + ";";
            // System.out.println(comando);
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }
}
