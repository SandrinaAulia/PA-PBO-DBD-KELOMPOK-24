package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class User {
    
    private String idUser;
    private String password;
    private String role;

    public User(String idUser, String password, String role) {
        this.idUser = idUser;
        this.password = password;
        this.role = role;
    }

    // Getter dan setter
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Method login menggunakan ORM
    public boolean login() {
        try {
            Connection conn = Database.connect();
            String query = "SELECT * FROM user WHERE id_user = ? AND password = ? AND role = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, this.getIdUser());
            statement.setString(2, this.getPassword());
            statement.setString(3, this.getRole());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Kesalahan Koneksi Pada Database" );
            e.printStackTrace();
            // Tangani kesalahan koneksi atau query
        }
        JOptionPane.showMessageDialog(null,"Input Salah ! Mohon Coba Lagi" );
        return false; 
        
    }
}
