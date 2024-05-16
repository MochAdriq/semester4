import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line;
        String csvSplitBy = ",";
        int rowCount = 0;

        System.out.println("NIM, NAMA, UMUR, PRODI");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (rowCount > 0) {
                    String[] student = line.split(csvSplitBy);
                    System.out.println(student[0] + ", " + student[1] + ", " + student[2] + ", " + student[3]);
                }
                rowCount++;
            }
            System.out.println("Jumlah baris: " + (rowCount - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
