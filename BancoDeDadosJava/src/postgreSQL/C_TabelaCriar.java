package postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_TabelaCriar {
    public static void main(String[] args) {
        String SQLcriarTabela = "CREATE TABLE pessoa (cpf int, nome VARCHAR(60))"; // define os parâmetros da tabela
        String driver = "jdbc:postgresql://127.0.0.1:5432/DadosGerais"; // endereço do Banco de Dados
        Statement st = null;

        try (Connection conn = DriverManager.getConnection(driver, "postgres", "password")) {
            if (conn != null) {
                System.out.println("Conectado ao Banco de Dados com sucesso.");
            } else {
                System.out.println("Falha ao conectar ao Banco de Dados.");
            }
            System.out.println("Criando tabela, aguarde...");
            st = conn.createStatement();
            st.executeUpdate(SQLcriarTabela);
            System.out.println("Tabela criada com sucesso!");
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