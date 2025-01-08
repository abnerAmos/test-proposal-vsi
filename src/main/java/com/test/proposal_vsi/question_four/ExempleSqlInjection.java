package com.test.proposal_vsi.question_four;

import java.sql.*;

public class ExempleSqlInjection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/meubanco";
        String user = "root";
        String pass = "senha";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String query = "SELECT * FROM usuarios WHERE username = ? AND senha = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, "usuario_entrada");
                pstmt.setString(2, "senha_entrada");


                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.println("Usuário encontrado: " + rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
