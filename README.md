# Aplikasi Peminjaman Buku Perpustakaan

Aplikasi ini merupakan aplikasi peminjaman buku pada perpustakaan yang digunakan oleh pustakawan untuk mengelola data buku, anggota, dan peminjaman. 
Pada aplikasi terdapat 2 data utama dan 1 data relasi, yang dimana data relasi akan mengambil data dari 2 data utama.

Data utama :
1. Buku (id, judul, pengarang, penerbit, tahun terbit, kategori)
2. Anggota (id, nama, alamat, jenis kelamin, nomor hp)

Data relasi :
1. Peminjaman (id, judul buku, nama anggota, tanggal peminjaman, tanggal pengembalian)

Database yang digunakan adalah Firebase.

# Use Case
![Use Case Diagram1](https://github.com/FarhanTaufiqulIhsan/perpustakaan/assets/115075868/51c098d2-7bb1-46c2-b2e0-6138c4a7ac7b)


# Pembagian Tugas
Farhan mengerjakan bagian data buku, meluputi data class buku, halaman data buku, navigasi pada halaman buku, halaman entry data peminjaman , halaman utama.

Ika mengerjakan bagian data anggota, meliputi data class anggota, halaman data anggota, navigasi pada halaman anggota, halaman list peminjaman, halaman welcome.
