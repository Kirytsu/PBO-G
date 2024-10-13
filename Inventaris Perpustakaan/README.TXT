------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Sistem Buku Perpustakaan

PURPOSE OF PROJECT: Untuk dapat mengelola buku-buku yang disimpan dalam sebuah perpustakaan

HOW TO START THIS PROJECT: 

	1. Membuka proyek di BlueJ
	- Buka BlueJ
	- Klik 'Project' di atas kiri, lalu klik 'Open Project...'
	- Pilihlah folder proyek ini

	2. Compile proyek
	- Klik kanan pada sebuah class dan klik 'Compile'
	- Lakukan untuk semua class / interface
	- Bisa juga hanya melakukan compile pada class Main, dengan begitu semua class/interface lain juga akan dicompile secara otomatis 

	3. Memulai system
	- Klik kanan pada class Main dan klik 'void main(String[] args)', lalu klik 'OK'
	- Sistem telah terbuka

AUTHORS:

	Kelompok 17:
	Nathanael Valen Susilo   -   5025231099
	Basten Andika Salim      -   5025231132

USER INSTRUCTIONS:

	Sistem dapat melakukan 4 hal tergantung dengan input pengguna, yaitu:

	Input '1' --- Menambahkan Buku:
		- Sistem akan membaca input berikutnya sebagai nama dari buku yang ingin ditambahkan
		- Sistem akan membaca input berikutnya sebagai jumlah dari buku yang baru saja dinamakan
		- Jika penambahan buku sukses, sistem akan memberikan konfirmasi

	Input '2' --- Menghapus Buku:
		- Sistem akan membaca input berikutnya sebagai nama dari buku yang ingin dihapus
		- Sistem akan mencari buku tersebut dalam kumpulan datanya
		- Jika sistem menemukan buku dengan nama tersebut, maka buku akan dihapus dan akan diberikan sebuah konfirmasi keberhasilan penghapusan buku
		- Jika tidak, sistem akan memberikan konfirmasi bahwa buku tersebut tidak ada

	Input '3' --- Menampilkan Daftar Buku:
		- Sistem akan menampilkan seluruh buku yang terdaftar beserta dengan jumlahnya dalam bentuk table

	Input '4' --- Menghentikan Sistem:
		- Sistem akan berhenti