package postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H_TabelaDeletar {
    public static void main(String[] args) {
        String tableName = "pessoa";
        String driver = "jdbc:postgresql://127.0.0.1:5432/DadosGerais";

        try (Connection conn = DriverManager.getConnection(driver, "postgres", "password")) {
            if (conn != null) {
                System.out.println("Conectado ao Banco de Dados com sucesso.");
            } else {
                System.out.println("Falha ao conectar ao Banco de Dados.");
            }

            System.out.println("Deletando Tabela...");

            Statement statement = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS " + tableName;
            statement.executeUpdate(sql);

            System.out.println("Tabela Deletada com Sucesso.");
            
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}