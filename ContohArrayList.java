import java.util.ArrayList;

public class ContohArrayList {

    public static void main(String[] args) {
        // Membuat ArrayList
        ArrayList<String> nama = new ArrayList<>();

        // Menambahkan data ke ArrayList
        nama.add("Andi");
        nama.add("Budi");
        nama.add("Cici");

        // Mencetak isi ArrayList
        System.out.println("Isi ArrayList: " + nama);

        // Menghapus data dari ArrayList
        nama.remove("Budi");

        // Mencari data di ArrayList
        boolean adaCici = nama.contains("Cici");

        // Mencetak hasil pencarian
        System.out.println("Apakah ada Cici? " + adaCici);

        // Mencetak isi ArrayList setelah dihapus
        System.out.println("Isi ArrayList setelah dihapus: " + nama);
    }
}
