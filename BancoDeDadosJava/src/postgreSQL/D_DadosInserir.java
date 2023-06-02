package postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class D_DadosInserir {
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
            
            System.out.println("Digite o CPF:");
            int cpf = scanner.nextInt();
            
            System.out.println("Digite o nome:");
            scanner.nextLine(); 
            String nome = scanner.nextLine();
            
            String SQLinserirDados = "INSERT INTO pessoa (cpf, nome) VALUES (" + cpf + ", '" + nome + "')";
            
            System.out.println("Inserindo dados na tabela...");
            
            st = conn.createStatement();
            st.executeUpdate(SQLinserirDados);
            
            System.out.println("Dados inseridos!");
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