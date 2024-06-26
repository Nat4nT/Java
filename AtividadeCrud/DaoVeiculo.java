import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

public class DaoVeiculo {
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

    public boolean inserir(Veiculo v){
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO tb_veiculos VALUES("
                + "NULL, '" +v.getMarca() + "', '" + 
                v.getModelo() + "', '" + v.getChassi() 
                + "', " + v.getAno()+ ");";
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

    public ArrayList<Veiculo> buscarTodos(){
        ArrayList<Veiculo> resultados = new ArrayList<Veiculo>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM tb_veiculos ORDER BY modelo");
            while(rs.next()){
                Veiculo v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));

                resultados.add(v);
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
            String comando = "DELETE FROM tb_veiculos "
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

    public Veiculo consultar(int cod){
        Veiculo v = null;
        try{
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM tb_veiculos WHERE codigo = "
                    + cod + ";");
            if(rs.next()){
                v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }finally{
            this.desconectar();
        }
        return v;
    }

    public int alterar(Veiculo v){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "UPDATE tb_veiculos SET "
                + " marca = '" + v.getMarca() + "', "
                + " modelo = '" + v.getModelo() + "', "
                + " chassi = '" + v.getChassi() + "', "
                + " ano = " + v.getAno() 
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
