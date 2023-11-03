# PENGELOLAAN DATA NILAI UJIAN SEKOLAH SISWA
## DESKRIPSI PROJECT

SMAKESHA (Sekolah Menengah Kejuruan Star Harmoni) adalah sebuah institusi pendidikan yang berkomitmen untuk memberikan pendidikan berkualitas kepada para siswa. 

Mereka menyadari bahwa mengelola data nilai siswa dengan cara manual mengalami banyak kendala, termasuk kesalahan pencatatan, kerumitan dalam mengakses data.

### Fitur Inti

1. **Pengelolaan Data Siswa**: Aplikasi ini memungkinkan Siswa untuk melihat informasi siswa itu sendiri. Siswa dapat melihat data seperti nama, Nomor Induk Sekolah (NIS)/Id_User, nama, nilai dan informasi terkait lainnya.

2. **Pengelolaan Nilai Siswa**: Aplikasi ini memfasilitasi Staff TU untuk membuat, mengedit, menghapus maupun menampilkan data nilai siswa. Termasuk dalam fitur ini adalah pengelolaan nilai.

3. **Autentikasi Pengguna**: Aplikasi memiliki fitur login yang membedakan antara pengguna berdasarkan peran mereka, seperti staf akademik dan mahasiswa.

### Teknologi yang Digunakan

- **Bahasa Pemrograman Java**: Bahasa utama yang digunakan dalam pengembangan aplikasi ini.
- **Lingkungan Pengembangan NetBeans IDE**: Digunakan sebagai alat utama dalam proses pengembangan aplikasi.
- **Sistem Manajemen Basis Data MySQL**: Digunakan untuk menyimpan dan mengelola data siswa dan nilai siswa.

### Struktur Proyek

- **Direktori "src"**: Berisi kode sumber Java, termasuk paket Controller, Database, Model, dan View.
- **Direktori "dist"**: Berisi file JAR yang dapat dijalankan bersama dengan library pihak ketiga yang diperlukan untuk menjalankan aplikasi.
- **Direktori "nbproject"**: Berisi berkas konfigurasi proyek yang khusus untuk penggunaan NetBeans.

### Selain itu, proyek ini mencakup berkas SQL yang digunakan untuk membuat struktur basis data yang diperlukan untuk menyimpan informasi siswa dan nilai siswa.

## Cara Menjalankan Aplikasi

Untuk menjalankan aplikasi ini, Anda dapat menggunakan file JAR yang telah disediakan dalam direktori "dist". Pastikan untuk menyertakan semua library yang ada di direktori "dist/lib" dalam classpath aplikasi.

Aplikasi ini bertujuan mempermudah staf akademik/TU dalam mengelola data siswa dan nilai siswa, memungkinkan mereka untuk mencatat, memperbarui data akademik seperti nilai dengan cepat, dan menghasilkan laporan nilai serta transkrip akademik secara efisien. Selain itu, siswa juga dapat dengan mudah memantau perkembangan akademik mereka melalui aplikasi ini.



# FLOWCHART 
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121924124/0fc262b3-9ab4-47e6-9e53-3a667da12011)

Flowchart dimulai dari user diminta untuk memilih menu login , terdapat 3 menu pilihan yaitu staff TU, siswa dan exit. Ketika user memilih menu staff TU maka user diminta untuk menginputkan nip dan password kemudian jika user salah menginputkan maka user diminta untuk menginput kan kembali, jika user berhasil login maka user akan ditampilkan menu tabel nilai yang berisi crud dari menu tersebut kemudian akan tersimpan didatabase.Kemudian jika pengguna memilih menu siswa maka pengguna diminta untuk menginputkan nis dan password, jika gagal maka pengguna akan diminta menginputkan kembali jika berhasil maka pengguna akan ditampilkan tabel nilai namun pengguna hanya bisa melihat tanpa bisa mengedit.


# ERD
ERD LOGICAL

![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121924124/af6be1ea-d8d1-4043-bb27-4ed1b4bef17a)

ERD RELATIONAL

![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121924124/782bc04f-d53e-4935-942f-a80a1053417c)


# HIRARKI KELAS

Hirarki Kelas adalah struktur kelas yang digunakan dalam program. Berikut adalah Hirarki Kelas dari Sistem Pengelolaan Data Nilai Siswa.

![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121924124/83ea1334-8522-4989-b765-f6b975b3c8fc)


# SCREENSHOT CODINGAN
1. Pola Desain ORM (WAJIB)
2. Best Practice dari Final Variabel, Property, Method, Class (WAJIB)
3. Inheritance/Pewarisan (OPSIONAL)
4. Encapsulation = Getter & Setter (WAJIB tp sebaiknya pake)
5. Polymorphism = Overriding & Overloading (OPSIONAL tp sebaiknya pake)
6. Abstraction = Interface/Kelas Abstrak (Pilih Salah Satu Aja)
7. Penerapan Property/Method bersifat Static (Ga termasuk property Static yang dikelas Database untuk nama host, nama database, username dan password)


# OUTPUT 
