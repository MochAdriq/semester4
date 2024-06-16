import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Anggota {
    private int idAnggota;
    private String nama;
    private String alamat;

    public Anggota(int idAnggota, String nama, String alamat) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.alamat = alamat;
    }

    // Getters and Setters
    public int getIdAnggota() {
        return idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    // Metode untuk menambahkan anggota ke database
    public static void tambahAnggota(Connection conn, Anggota anggota) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "INSERT INTO Anggota (nama, alamat) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, anggota.getNama());
            stmt.setString(2, anggota.getAlamat());
            stmt.executeUpdate();
        }
    }

    // Metode untuk mencari anggota berdasarkan ID
    public static Anggota cariAnggotaById(Connection conn, int idAnggota) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "SELECT * FROM Anggota WHERE id_anggota = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAnggota);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Anggota(
                        rs.getInt("id_anggota"),
                        rs.getString("nama"),
                        rs.getString("alamat"));
            } else {
                return null;
            }
        }
    }

    // Metode untuk mendapatkan semua anggota
    public static List<Anggota> getAllAnggota(Connection conn) throws SQLException {
        if (conn == null) {
            throw new SQLException("Koneksi database tidak tersedia.");
        }

        String sql = "SELECT * FROM Anggota";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            List<Anggota> daftarAnggota = new ArrayList<>();
            while (rs.next()) {
                Anggota anggota = new Anggota(
                        rs.getInt("id_anggota"),
                        rs.getString("nama"),
                        rs.getString("alamat"));
                daftarAnggota.add(anggota);
            }
            return daftarAnggota;
        }
    }
}
