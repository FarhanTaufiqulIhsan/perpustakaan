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
<img width="445" alt="Screenshot 2024-01-07 133212" src="https://github.com/FarhanTaufiqulIhsan/perpustakaan/assets/115075868/d428afc6-f905-4599-a6a9-e2226e6cab22">

# Pembagian Tugas
Farhan mengerjakan bagian data buku, meluputi data class buku, halaman data buku, navigasi pada halaman buku, halaman entry data peminjaman , halaman utama.

Ika mengerjakan bagian data anggota, meliputi data class anggota, halaman data anggota, navigasi pada halaman anggota, halaman list peminjaman, halaman welcome.
