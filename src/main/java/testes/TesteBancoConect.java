import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteBancoConect {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/inventario";
        String usuario = "root";
        String senha = "$uP3rn0V@";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
        }
    }
}