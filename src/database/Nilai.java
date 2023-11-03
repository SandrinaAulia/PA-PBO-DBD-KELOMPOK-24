package database;

import java.sql.*;

public class Nilai {
    private int idNilai;
    private int nilai;
    private String predikat;
    private final String mataPelajaranKodeMapel;
    private final String siswaIdUser;
    private String staffTUIdUser;

    public Nilai(String predikat, int nilai, String mataPelajaranKodeMapel, String siswaIdUser, String staffTUIdUser) {
        this.idNilai = idNilai;
        this.nilai = nilai;
        this.predikat = predikat;
        this.mataPelajaranKodeMapel = mataPelajaranKodeMapel;
        this.siswaIdUser = siswaIdUser;
        this.staffTUIdUser = staffTUIdUser;
    }
    
    public Nilai(String siswaIdUser, String mataPelajaranKodeMapel){
        this.siswaIdUser = siswaIdUser;
        this.mataPelajaranKodeMapel = mataPelajaranKodeMapel;
    }
    
    public Nilai(String predikat, int nilai, String siswaIdUser, String mataPelajaranKodeMapel){
        this.predikat = predikat;
        this.nilai = nilai;
        this.siswaIdUser = siswaIdUser;
        this.mataPelajaranKodeMapel = mataPelajaranKodeMapel;
    }


    public int getIdNilai() {
        return idNilai;
    }

    public void setIdNilai(int idNilai) {
        this.idNilai = idNilai;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public boolean addNilai() {
        try {
            String query = "INSERT INTO nilai (nilai, predikat, mata_pelajaran_kode_mapel, siswa_id_user, staff_tu_id_user) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = Database.connect().prepareStatement(query);
            preparedStatement.setInt(1, this.nilai);
            preparedStatement.setString(2, this.predikat);
            preparedStatement.setString(3, this.mataPelajaranKodeMapel);
            preparedStatement.setString(4, this.siswaIdUser);
            preparedStatement.setString(5, this.staffTUIdUser);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void showTranskipNilai() {
        try {
            Connection conn = Database.connect();
            String query = "SELECT n.id_nilai, n.predikat, n.MATA_PELAJARAN_kode_mapel, n.SISWA_id_user, " +
                    "u.id_user, u.nama, u.password, u.role " +
                    "FROM nilai AS n " +
                    "JOIN user AS u ON n.SISWA_id_user = u.id_user";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idNilai = resultSet.getInt("id_nilai");
                String predikat = resultSet.getString("predikat");
                int mataPelajaranKodeMapel = resultSet.getInt("MATA_PELAJARAN_kode_mapel");
                int siswaIdUser = resultSet.getInt("SISWA_id_user");

                System.out.println("ID Nilai: " + idNilai);
                System.out.println("Predikat: " + predikat);
                System.out.println("Kode Mapel: " + mataPelajaranKodeMapel);
                System.out.println("ID User Siswa: " + siswaIdUser);
            }

            conn.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNilai(){
        try {
            Connection conn = Database.connect();
            String query = "DELETE FROM nilai WHERE siswa_id_user = ? AND mata_pelajaran_kode_mapel = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, this.siswaIdUser);
            preparedStatement.setString(2, this.mataPelajaranKodeMapel);
            preparedStatement.executeUpdate();
            System.out.println("berhasil eksekusi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateNilai(){
        try {
            Connection conn = Database.connect();
            String query = "UPDATE nilai SET nilai = ?, predikat = ? WHERE siswa_id_user = ? AND mata_pelajaran_kode_mapel = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, this.nilai);
            preparedStatement.setString(2, this.predikat);
            preparedStatement.setString(3, this.siswaIdUser);
            preparedStatement.setString(4, this.mataPelajaranKodeMapel);
            preparedStatement.executeUpdate();
            System.out.println("berhasil eksekusi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
