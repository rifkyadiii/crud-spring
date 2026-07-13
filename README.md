# Aplikasi CRUD Manajamen Mahasiswa dengan Java Spring Boot

Proyek ini merupakan aplikasi web sederhana berbasis Java yang mengimplementasikan operasi dasar **CRUD (Create, Read, Update, Delete)** menggunakan **Spring Framework** dan dikelola oleh **Maven**.

## 📝 Deskripsi Proyek

Tujuannya adalah untuk mendemonstrasikan pemahaman konsep OOP dan penerapannya dalam membangun aplikasi backend fungsional dengan studi kasus manajemen data sederhana.

## ✨ Fitur Utama

  * **Create**: Menambahkan data baru ke dalam database.
  * **Read**: Menampilkan daftar data yang sudah ada.
  * **Update**: Mengubah data yang sudah tersimpan.
  * **Delete**: Menghapus data dari database.
  * **Login**: Fitur otentikasi sederhana untuk pengguna.

## 🛠️ Teknologi yang Digunakan

  * **Bahasa**: Java
  * **Framework**: Spring Boot
  * **Build Tool**: Maven
  * **Database**: *(Sebutkan database yang Anda gunakan, contoh: MySQL, PostgreSQL, H2)*
  * **Dependensi Lain**: *(Sebutkan jika ada, contoh: Spring Data JPA, Spring Security, Thymeleaf)*

## 🚀 Cara Menjalankan Proyek

1.  **Clone repositori ini:**
    ```bash
    git clone https://github.com/rifkyadiii/tugas-akhir-pbo-crud-spring.git
    ```
2.  **Masuk ke direktori proyek:**
    ```bash
    cd tugas-akhir-pbo-crud-spring
    ```
3.  **Konfigurasi Database:**
    Buka file `src/main/resources/application.properties` dan sesuaikan konfigurasi koneksi database (URL, username, dan password) dengan pengaturan lokal Anda.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/nama_database_anda
    spring.datasource.username=root
    spring.datasource.password=password_anda
    spring.jpa.hibernate.ddl-auto=update
    ```
4.  **Build dan jalankan aplikasi menggunakan Maven wrapper:**
      * Untuk pengguna Linux/Mac:
        ```bash
        ./mvnw spring-boot:run
        ```
      * Untuk pengguna Windows:
        ```bash
        mvnw.cmd spring-boot:run
        ```
5.  Aplikasi akan berjalan dan dapat diakses melalui browser di alamat `http://localhost:9090`.
