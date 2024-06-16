

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Buku {
    private int idBuku;
    private String judul;
    private String pengarang;
    private int tahunTerbit;
    private int jumlah;

    public Buku(int idBuku, String judul, String pengarang, int tahunTerbit, int jumlah) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.jumlah = jumlah;
    }

    // Getters
    public int getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public int getJumlah() {
        return jumlah;
    }

    // Setters
    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    // Metode untuk menambahkan buku ke database
    public static void tambahBuku(Connection conn, Buku buku) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "INSERT INTO Buku (judul, pengarang, tahun_terbit, jumlah) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, buku.getJudul());
            stmt.setString(2, buku.getPengarang());
            stmt.setInt(3, buku.getTahunTerbit());
            stmt.setInt(4, buku.getJumlah());
            stmt.executeUpdate();
        }
    }

    // Metode untuk mencari buku berdasarkan ID
    public static Buku cariBukuById(Connection conn, int idBuku) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "SELECT * FROM Buku WHERE id_buku = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idBuku);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Buku(
                        rs.getInt("id_buku"),
                        rs.getString("judul"),
                        rs.getString("pengarang"),
                        rs.getInt("tahun_terbit"),
                        rs.getInt("jumlah"));
            } else {
                return null;
            }
        }
    }

    // Metode untuk memperbarui jumlah buku
    public static void updateJumlahBuku(Connection conn, int idBuku, int jumlah) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "UPDATE Buku SET jumlah = ? WHERE id_buku = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, jumlah);
            stmt.setInt(2, idBuku);
            stmt.executeUpdate();
        }
    }

    // Metode untuk mendapatkan semua buku
    public static List<Buku> getAllBuku(Connection conn) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "SELECT * FROM Buku";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            List<Buku> daftarBuku = new ArrayList<>();
            while (rs.next()) {
                Buku buku = new Buku(
                        rs.getInt("id_buku"),
                        rs.getString("judul"),
                        rs.getString("pengarang"),
                        rs.getInt("tahun_terbit"),
                        rs.getInt("jumlah"));
                daftarBuku.add(buku);
            }
            return daftarBuku;
        }
    }
}
