
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Siswa extends User{
    private final String name;
    private final String kelas;
    private final String jenisKelamin;
    private final String siswaIDUser;

    public Siswa(String idUser, String password, String role, String name, String kelas, String jenisKelamin, String siswaIDUser){
        super(idUser, password, role);
        this.name = name;
        this.kelas = kelas;
        this.jenisKelamin = jenisKelamin;
        this.siswaIDUser = siswaIDUser;
    }

    public String getName(){
        return name;
    }

    public String getKelas(){
        return kelas;
    }

    public String getJenisKelamin(){
        return jenisKelamin;
    }

    public String getSiswaIDUser(){
        return siswaIDUser;
    }

    @Override
    public String getRole(){
        return "Siswa";
    }
    
    
    
}
