package postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class F_DadosAtualizar {
    public static void main(String[] args) {
        String driver = "jdbc:postgresql://127.0.0.1:5432/DadosGerais";
        Statement st = null;

        try (Connection conn = DriverManager.getConnection(driver, "postgres", "password")) {
            if (conn != null) {
                System.out.println("Conectado ao Banco de Dados com sucesso.");
            } else {
                System.out.println("Falha ao conectar ao Banco de Dados.");
            }

            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o CPF para ser modificado:");
            int cpf = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Digite o novo nome:");
            String novoNome = scanner.nextLine();

            String SQLatualizarDados = "UPDATE pessoa SET nome = '" + novoNome + "' WHERE cpf = " + cpf;
            System.out.println("Atualizando dados na tabela...");

            st = conn.createStatement();
            st.executeUpdate(SQLatualizarDados);

            System.out.println("Dados atualizados!");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                System.err.format("Erro ao fechar o statement: %s\n%s", e.getSQLState(), e.getMessage());
            }
        }
    }
}