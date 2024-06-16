
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private Connection conn;
    private Scanner scanner = new Scanner(System.in);

    public LibraryManagementSystem() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String password = ""; // Ganti dengan password Anda yang benar
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Koneksi ke database berhasil.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC MySQL tidak ditemukan.");
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal: " + e.getMessage());
        }
    }

    public void mainMenu() {
        while (true) {
            System.out.println("Menu Utama:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Peminjaman Buku");
            System.out.println("4. Pengembalian Buku");
            System.out.println("5. Lihat Daftar Buku");
            System.out.println("6. Lihat Daftar Anggota");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    tambahAnggota();
                    break;
                case 3:
                    peminjamanBuku();
                    break;
                case 4:
                    pengembalianBuku();
                    break;
                case 5:
                    lihatDaftarBuku();
                    break;
                case 6:
                    lihatDaftarAnggota();
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tambahBuku() {
        try {
            System.out.print("Judul: ");
            String judul = scanner.nextLine();
            System.out.print("Pengarang: ");
            String pengarang = scanner.nextLine();
            System.out.print("Tahun Terbit: ");
            int tahunTerbit = scanner.nextInt();
            System.out.print("Jumlah: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Buku buku = new Buku(0, judul, pengarang, tahunTerbit, jumlah);
            Buku.tambahBuku(conn, buku);
            System.out.println("Buku berhasil ditambahkan.");
        } catch (SQLException e) {
            System.err.println("Gagal menambahkan buku: " + e.getMessage());
        }
    }

    private void tambahAnggota() {
        try {
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Alamat: ");
            String alamat = scanner.nextLine();

            Anggota anggota = new Anggota(0, nama, alamat);
            Anggota.tambahAnggota(conn, anggota);
            System.out.println("Anggota berhasil ditambahkan.");
        } catch (SQLException e) {
            System.err.println("Gagal menambahkan anggota: " + e.getMessage());
        }
    }

    private void peminjamanBuku() {
        try {
            System.out.print("ID Anggota: ");
            int idAnggota = scanner.nextInt();
            System.out.print("ID Buku: ");
            int idBuku = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Tanggal Pinjam (YYYY-MM-DD): ");
            String tanggalPinjam = scanner.nextLine();

            // Pastikan anggota dan buku ada
            if (Anggota.cariAnggotaById(conn, idAnggota) == null) {
                System.err.println("Anggota tidak ditemukan.");
                return;
            }
            if (Buku.cariBukuById(conn, idBuku) == null) {
                System.err.println("Buku tidak ditemukan.");
                return;
            }

            Transaksi transaksi = new Transaksi(0, idAnggota, idBuku, tanggalPinjam, null);
            Transaksi.tambahTransaksi(conn, transaksi);
            System.out.println("Peminjaman buku berhasil.");
        } catch (SQLException e) {
            System.err.println("Gagal melakukan peminjaman buku: " + e.getMessage());
        }
    }

    private void pengembalianBuku() {
        try {
            System.out.print("ID Transaksi: ");
            int idTransaksi = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Tanggal Kembali (YYYY-MM-DD): ");
            String tanggalKembali = scanner.nextLine();

            // Cari transaksi
            Transaksi transaksi = Transaksi.cariTransaksiById(conn, idTransaksi);
            if (transaksi == null) {
                System.err.println("Transaksi tidak ditemukan.");
                return;
            }

            Transaksi.updateTanggalKembali(conn, idTransaksi, tanggalKembali);
            System.out.println("Pengembalian buku berhasil.");
        } catch (SQLException e) {
            System.err.println("Gagal melakukan pengembalian buku: " + e.getMessage());
        }
    }

    private void lihatDaftarBuku() {
        try {
            List<Buku> daftarBuku = Buku.getAllBuku(conn);
            if (daftarBuku.isEmpty()) {
                System.out.println("Tidak ada buku yang tersedia.");
            } else {
                for (Buku buku : daftarBuku) {
                    System.out.println("---------------------------");
                    System.out.println("ID Buku: " + buku.getIdBuku());
                    System.out.println("Judul: " + buku.getJudul());
                    System.out.println("Pengarang: " + buku.getPengarang());
                    System.out.println("Tahun Terbit: " + buku.getTahunTerbit());
                    System.out.println("Jumlah: " + buku.getJumlah());
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil daftar buku: " + e.getMessage());
        }
    }

    private void lihatDaftarAnggota() {
        try {
            List<Anggota> daftarAnggota = Anggota.getAllAnggota(conn);
            if (daftarAnggota.isEmpty()) {
                System.out.println("Tidak ada anggota yang tersedia.");
            } else {
                for (Anggota anggota : daftarAnggota) {
                    System.out.println("---------------------------");               
                    System.out.println("ID Anggota: " + anggota.getIdAnggota());
                    System.out.println("Nama: " + anggota.getNama());
                    System.out.println("Alamat: " + anggota.getAlamat());
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil daftar anggota: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.mainMenu();
    }
}
