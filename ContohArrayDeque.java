import java.util.ArrayDeque;

public class ContohArrayDeque {

    public static void main(String[] args) {
        // Membuat ArrayDeque
        ArrayDeque<String> antrian = new ArrayDeque<>();

        // Menambahkan data ke ArrayDeque (dari belakang)
        antrian.add("Andi");
        antrian.add("Budi");
        antrian.add("Cici");

        // Mencetak isi ArrayDeque
        System.out.println("Isi ArrayDeque: " + antrian);

        // Mengambil data dari depan ArrayDeque
        String depan = antrian.pollFirst();

        // Mengambil data dari belakang ArrayDeque
        String belakang = antrian.pollLast();

        // Mencetak data yang diambil
        System.out.println("Data yang diambil dari depan: " + depan);
        System.out.println("Data yang diambil dari belakang: " + belakang);

        // Mencetak isi ArrayDeque setelah dihapus
        System.out.println("Isi ArrayDeque setelah dihapus: " + antrian);
    }
}
