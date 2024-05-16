import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            System.out.println(
                    "Masukkan data baru (Format: NIM, NAMA, UMUR, PRODI), atau ketik 'selesai' untuk mengakhiri:");

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("selesai")) {
                    break; // Keluar dari loop jika pengguna memasukkan "selesai"
                }

                // Menambahkan input pengguna ke file CSV
                bw.write(input);
                bw.newLine();
            }

            System.out.println("Data berhasil ditambahkan ke file " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
