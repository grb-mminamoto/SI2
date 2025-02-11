import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlExample {
    public static void main(String[] args) {
        String username = "user";  // Usuário fornecido pelo usuário
        String password = "password";  // Senha fornecida pelo usuário

        try {
            // Conectar ao banco de dados
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

            // Vulnerabilidade: SQL Injection
            String query = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nome);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Login bem-sucedido");
            } else {
                System.out.println("Falha no login");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
