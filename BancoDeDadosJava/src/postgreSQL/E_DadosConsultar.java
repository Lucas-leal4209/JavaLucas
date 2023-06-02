package postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class E_DadosConsultar {
    public static void main(String[] args) {
        String SQLConsultarDados = "SELECT * FROM pessoa";
        String driver = "jdbc:postgresql://127.0.0.1:5432/DadosGerais";
        Statement st;
        ResultSet result;

        try (Connection conn = DriverManager.getConnection(driver, "postgres", "password")) {
            if (conn != null) {
                System.out.println("Conectado ao Banco de Dados com sucesso.");
            } else {
                System.out.println("Falha ao conectar ao Banco de Dados.");
            }

            System.out.println("Consultando dados na Tabela...");
            st = conn.createStatement();
            result = st.executeQuery(SQLConsultarDados);

            while (result.next()) {
                System.out.println("-----------------");
                System.out.println("CPF: " + result.getString(1));
                System.out.println("Nome: " + result.getString(2));
            }

            result.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}