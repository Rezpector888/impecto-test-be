# IMPECTO Test Backend

## Persiapan Proyek

Pastikan Anda memiliki Java, PostgreSQL.

```
    java: v21
    postgresql: v16

```

## Instalasi

1. Clone repository ini:
   ```bash
   git clone https://github.com/Rezpector888/impecto-test-be.git
   ```
2. Masuk ke direktori proyek:
  ```bash
  cd impecto-test-be
  ```
3. Install dependencies:
  ```bash
  ./mvnw install
  ```

## Konfigurasi Database
1. Masuk kedalam folder ```src/main/resources``` dan buka file ```application.properties```
2. Lalu sesuaikan ```spring.datasource.url```, ```spring.datasource.username```, ```spring.datasource.password``` sesuai dengan informasi koneksi database Anda.

## Menjalankan Aplikasi
1. Jalankan aplikasi dalam mode pengembangan:
  ```bash
    ./mvnw spring-boot:run
  ```
2. Aplikasi akan berjalan di ```http://localhost:8080```.

## Dokumentasi API
```
- Dokumentasi API tersedia di Swagger.
- Anda dapat mengaksesnya melalui http://localhost:8080/docs/index.html.
```

## Menjalankan Aplikasi di Container
1. Membangun Aplikasi Spring Boot
    Sebelum membuat Docker image, Anda perlu membangun aplikasi Spring Boot terlebih dahulu. Gunakan Maven untuk membangun aplikasi:
    ```bash
    ./mvnw clean package
    ```

2. Membangun Docker Image
    Pertama, Anda perlu membangun Docker image untuk aplikasi Anda. Pastikan Anda berada di direktori proyek yang berisi Dockerfile. Jalankan perintah berikut untuk membangun image:
    ```bash
    docker build -t nama-image-anda .
    ```
    Gantilah ```nama-image-anda``` dengan nama yang sesuai untuk image Anda.

3. Menjalankan Container
    Setelah image berhasil dibangun, Anda dapat menjalankan container menggunakan perintah berikut:
    ```bash
    docker run -p 8080:8080 nama-image-anda
    ```
4. Verifikasi
    Untuk memastikan aplikasi Anda berjalan dengan baik, buka browser dan akses http://localhost:8080. Anda seharusnya dapat melihat aplikasi Anda berfungsi seperti yang diharapkan.