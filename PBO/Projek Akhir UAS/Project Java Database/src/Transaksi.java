import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaksi {
    private int idTransaksi;
    private int idAnggota;
    private int idBuku;
    private String tanggalPinjam;
    private String tanggalKembali;

    public Transaksi(int idTransaksi, int idAnggota, int idBuku, String tanggalPinjam, String tanggalKembali) {
        this.idTransaksi = idTransaksi;
        this.idAnggota = idAnggota;
        this.idBuku = idBuku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    // Getters and Setters
    public int getIdTransaksi() {
        return idTransaksi;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    // Metode untuk menambahkan transaksi ke database
    public static void tambahTransaksi(Connection conn, Transaksi transaksi) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "INSERT INTO Transaksi (id_anggota, id_buku, tanggal_pinjam) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaksi.getIdAnggota());
            stmt.setInt(2, transaksi.getIdBuku());
            stmt.setString(3, transaksi.getTanggalPinjam());
            stmt.executeUpdate();
        }
    }

    // Metode untuk mencari transaksi berdasarkan ID
    public static Transaksi cariTransaksiById(Connection conn, int idTransaksi) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "SELECT * FROM Transaksi WHERE id_transaksi = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTransaksi);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Transaksi(
                        rs.getInt("id_transaksi"),
                        rs.getInt("id_anggota"),
                        rs.getInt("id_buku"),
                        rs.getString("tanggal_pinjam"),
                        rs.getString("tanggal_kembali"));
            } else {
                return null;
            }
        }
    }

    // Metode untuk memperbarui tanggal kembali pada transaksi
    public static void updateTanggalKembali(Connection conn, int idTransaksi, String tanggalKembali) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "UPDATE Transaksi SET tanggal_kembali = ? WHERE id_transaksi = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tanggalKembali);
            stmt.setInt(2, idTransaksi);
            stmt.executeUpdate();
        }
    }
}
