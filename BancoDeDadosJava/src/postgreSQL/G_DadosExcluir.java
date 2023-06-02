package postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class G_DadosExcluir {
    public static void main(String[] args) {
        String SQLexcluirDados = "DELETE FROM pessoa";
        String driver = "jdbc:postgresql://127.0.0.1:5432/DadosGerais";
        Statement st = null;

        try (Connection conn = DriverManager.getConnection(driver, "postgres", "password")) {
            if (conn != null) {
                System.out.println("Conectado ao Banco de Dados com sucesso.");
            } else {
                System.out.println("Falha ao conectar ao Banco de Dados.");
            }
            System.out.println("Excluindo dados da tabela...");
            st = conn.createStatement();
            st.executeUpdate(SQLexcluirDados);
            System.out.println("Dados excluídos!");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                System.err.format("Error closing statement: %s\n%s", e.getSQLState(), e.getMessage());
            }
        }
    }
}