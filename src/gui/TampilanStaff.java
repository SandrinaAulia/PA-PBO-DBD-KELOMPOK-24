package gui;

import database.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TampilanStaff extends javax.swing.JFrame {

    public TampilanStaff() {
        initComponents();
        table();
    }

    public void table() {
        try {
            Connection conn = Database.connect(); // Ganti dengan cara Anda membuat koneksi database
            Statement statement = conn.createStatement();
            String query = "SELECT user.id_user AS Nis_Siswa,\n" +
                            "siswa.kelas AS Kelas_Siswa,\n" +
                            "mata_pelajaran.kode_mapel AS Kode_Pelajaran,\n" +
                            "MAX(nilai.nilai) AS Nilai\n" +
                            "FROM user\n" +
                            "JOIN siswa ON user.id_user = siswa.id_user\n" +
                            "JOIN nilai ON siswa.id_user = nilai.siswa_id_user\n" +
                            "JOIN mata_pelajaran ON nilai.mata_pelajaran_kode_mapel = mata_pelajaran.kode_mapel\n" +
                            "GROUP BY user.id_user, siswa.kelas, mata_pelajaran.kode_mapel\n" +
                            "ORDER BY user.id_user, mata_pelajaran.kode_mapel ASC;";

            ResultSet resultSet = statement.executeQuery(query);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("NIS Siswa");
            model.addColumn("Kelas Siswa");
            model.addColumn("Kode Mata Pelajaran");
            model.addColumn("Nilai");

            while (resultSet.next()) {
                String namaSiswa = resultSet.getString("Nis_Siswa");
                String kelasSiswa = resultSet.getString("Kelas_Siswa");
                String mataPelajaran = resultSet.getString("Kode_Pelajaran");
                String nilai = resultSet.getString("Nilai");

                model.addRow(new Object[]{namaSiswa, kelasSiswa, mataPelajaran, nilai});
            }

            jTable1.setModel(model);

            conn.close(); // Jangan lupa untuk menutup koneksi setelah selesai
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    void clear(){
        mtkField.setText("");
        bindField.setText("");
        bingField.setText("");
        smkField.setText("");
    }
    
    public boolean isDuplicate(String nis) {
        try {
            Connection conn = Database.connect();
            String query = "SELECT * FROM nilai WHERE siswa_id_user = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nis);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;   
    }

    public int countDuplicates(String nis) {
        try {
            Connection conn = Database.connect();
            String query = "SELECT COUNT(*) AS jumlah FROM nilai WHERE siswa_id_user = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nis);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("jumlah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nisField = new javax.swing.JTextField();
        mtkField = new javax.swing.JTextField();
        bindField = new javax.swing.JTextField();
        bingField = new javax.swing.JTextField();
        smkField = new javax.swing.JTextField();
        show = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        LOGOUT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(nisField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 230, 30));
        getContentPane().add(mtkField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 230, 30));
        getContentPane().add(bindField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 230, 30));
        getContentPane().add(bingField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 230, 30));
        getContentPane().add(smkField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 230, 30));

        show.setBackground(new java.awt.Color(204, 0, 0));
        show.setForeground(new java.awt.Color(255, 255, 255));
        show.setText("Tampil");
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        getContentPane().add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 80, -1));

        update.setBackground(new java.awt.Color(204, 0, 0));
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Ubah");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 80, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIS Siswa", "Kelas", "Kode Mata Pelajaran", "Nilai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 470, 100));

        add.setBackground(new java.awt.Color(204, 0, 0));
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Tambah");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 80, -1));

        delete.setBackground(new java.awt.Color(204, 0, 0));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Hapus");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 80, -1));

        LOGOUT.setBackground(new java.awt.Color(204, 0, 0));
        LOGOUT.setForeground(new java.awt.Color(255, 255, 255));
        LOGOUT.setText("LOGOUT");
        LOGOUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOGOUTMouseClicked(evt);
            }
        });
        getContentPane().add(LOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 80, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tabel Input Nilai.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        table();
    }//GEN-LAST:event_showMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            try {
                String nis = jTable1.getValueAt(row, 0).toString();
                String mataPelajaran = jTable1.getValueAt(row, 2).toString();

                if (mataPelajaran.equals("A1")) {
                    String strNilai = bindField.getText().toString();
                    int value = Integer.parseInt(strNilai);
                    String predikat = calculatePredikat(value);
                    Nilai nilaiObj = new Nilai(predikat, value, nis, "A1");
                    nilaiObj.updateNilai();

                } else if (mataPelajaran.equals("A2")) {
                    String strNilai = mtkField.getText().toString();
                    int value = Integer.parseInt(strNilai);
                    String predikat = calculatePredikat(value);;
                    Nilai nilaiObj = new Nilai(predikat, value, nis, "A2");
                    nilaiObj.updateNilai();

                } else if (mataPelajaran.equals("A3")) {
                    String strNilai = bingField.getText().toString();
                    int value = Integer.parseInt(strNilai);
                    String predikat = calculatePredikat(value);
                    Nilai nilaiObj = new Nilai(predikat, value, nis, "A3");
                    nilaiObj.updateNilai();

                } else if (mataPelajaran.equals("A4")) {
                    String strNilai = smkField.getText().toString();
                    int value = Integer.parseInt(strNilai);
                    String predikat = calculatePredikat(value);
                    Nilai nilaiObj = new Nilai(predikat, value, nis, "A4");
                    nilaiObj.updateNilai();

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mengubah nilai: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu untuk mengubah nilai.");
        }
    }//GEN-LAST:event_updateMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            String nis = jTable1.getValueAt(row, 0).toString(); // Ganti 'kolomNis' dengan indeks kolom yang sesuai
            String mataPelajaran = jTable1.getValueAt(row, 2).toString(); // Ganti 'kolomMataPelajaran' dengan indeks kolom yang sesuai

            try {
                Nilai nilai = new Nilai(nis, mataPelajaran);
                nilai.deleteNilai();
                JOptionPane.showMessageDialog(null, "Berhasil menghapus!");
                table();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus nilai: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu untuk menghapus nilai.");
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            String nis = jTable1.getValueAt(row, 0).toString();
            String nilai = jTable1.getValueAt(row, 3).toString();
            String mataPelajaran = jTable1.getValueAt(row, 2).toString();
            
            mtkField.setText("");
            bindField.setText("");
            bingField.setText("");
            smkField.setText("");
            
            if (mataPelajaran.equals("A1")) {
                bindField.setText(nilai);
            } else if (mataPelajaran.equals("A2")) {
                mtkField.setText(nilai);
            } else if (mataPelajaran.equals("A3")) {
                bingField.setText(nilai);
            } else if (mataPelajaran.equals("A4")) {
               smkField.setText(nilai);
            }
            int value = Integer.parseInt(nilai);
            String predikat = calculatePredikat(value);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void LOGOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseClicked
        Login log = new Login();
        log.setVisible(true);
        this.dispose();       
    }//GEN-LAST:event_LOGOUTMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {
        String nis = nisField.getText();
        String nilaiMtk = mtkField.getText();
        String nilaiBind = bindField.getText();
        String nilaiBing = bingField.getText();
        String nilaiSmk = smkField.getText();

        if (nis.isEmpty() || nilaiMtk.isEmpty() || nilaiBind.isEmpty() || nilaiBing.isEmpty() || nilaiSmk.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
        } else {
            try {
                float nilaiMtkFloat = Float.parseFloat(nilaiMtk);
                float nilaiBindFloat = Float.parseFloat(nilaiBind);
                float nilaiBingFloat = Float.parseFloat(nilaiBing);
                float nilaiSmkFloat = Float.parseFloat(nilaiSmk);

                if (isWithinRange(nilaiMtkFloat) && isWithinRange(nilaiBindFloat) && isWithinRange(nilaiBingFloat) && isWithinRange(nilaiSmkFloat)) {
                    String predikatMtk = calculatePredikat(nilaiMtkFloat);
                    String predikatBind = calculatePredikat(nilaiBindFloat);
                    String predikatBing = calculatePredikat(nilaiBingFloat);
                    String predikatSmk = calculatePredikat(nilaiSmkFloat);

                    if (!isDuplicate(nis) || countDuplicates(nis) < 4) {
                        Nilai mtk = new Nilai(predikatMtk, (int) nilaiMtkFloat, "A2", nis, "100");
                        mtk.addNilai();

                        Nilai bind = new Nilai(predikatBind, (int) nilaiBindFloat, "A1", nis, "100");
                        bind.addNilai();

                        Nilai bing = new Nilai(predikatBing, (int) nilaiBingFloat, "A3", nis, "100");
                        bing.addNilai();

                        Nilai smk = new Nilai(predikatSmk, (int) nilaiSmkFloat, "A4", nis, "100");
                        smk.addNilai();

                        JOptionPane.showMessageDialog(null, "Nilai berhasil ditambahkan!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Jumlah duplikasi nilai untuk NIS ini melebihi 4!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nilai harus berada di antara 0 dan 100!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "NIS dan nilai harus berupa angka!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
            }
        }
    }

    private String calculatePredikat(float nilai) {
        if (nilai >= 85 && nilai <= 100) {
            return "A";
        } else if (nilai >= 70 && nilai < 85) {
            return "B";
        } else if (nilai >= 60 && nilai < 70) {
            return "C";
        } else if (nilai >= 40 && nilai < 60) {
            return "D";
        } else if (nilai >= 0 && nilai < 40) {
            return "E";
        } else {
            return "Nilai tidak valid";
        }
    }

    private boolean isWithinRange(float value) {
        return value >= 0 && value <= 100;
    }
                                

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TampilanStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TampilanStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TampilanStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TampilanStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilanStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LOGOUT;
    private javax.swing.JButton add;
    private javax.swing.JTextField bindField;
    private javax.swing.JTextField bingField;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mtkField;
    private javax.swing.JTextField nisField;
    private javax.swing.JButton show;
    private javax.swing.JTextField smkField;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
