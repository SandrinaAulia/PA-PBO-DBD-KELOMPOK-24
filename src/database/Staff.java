/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class Staff extends User {
    private final String name;
    private final String noTelp;
    private final String email;

    private int id;

    public Staff(String idUser, String password, String role, String name, String noTelp, String email, String staffIDUser) {
        super(idUser, password, role);
        this.name = name;
        this.noTelp = noTelp;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getRole() {
        return "Staff";
    }
}
