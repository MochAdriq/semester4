package tugas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input nama mahasiswa:");
        String namaMahasiswa = scanner.nextLine();
        System.out.println("Input alamat mahasiswa:");
        String alamatMahasiswa = scanner.nextLine();
        Student mahasiswa = new Student(namaMahasiswa, alamatMahasiswa);

        System.out.println("Input nama dosen:");
        String namaDosen = scanner.nextLine();
        System.out.println("Input alamat dosen:");
        String alamatDosen = scanner.nextLine();
        Teacher dosen = new Teacher(namaDosen, alamatDosen);

        boolean run = true;
        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambahkan nilai kursus mahasiswa");
            System.out.println("2. Tampilkan nilai mahasiswa");
            System.out.println("3. Tambahkan kursus dosen");
            System.out.println("4. Hapus kursus dosen");
            System.out.println("5. Keluar");
            System.out.println("Pilih menu:");

            int menu = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (menu) {
                case 1:
                    System.out.println("Input nama kursus:");
                    String kursus = scanner.nextLine();
                    if (!dosen.getCourses().contains(kursus)) {
                        System.out.println("Kursus belum ditambahkan oleh dosen.");
                        break;
                    }
                    int nilai;
                    do {
                        System.out.println("Input nilai untuk kursus " + kursus + ":");
                        nilai = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        if (nilai < 0 || nilai > 100) {
                            System.out.println("Nilai harus berada di antara 0 dan 100.");
                        }
                    } while (nilai < 0 || nilai > 100);
                    mahasiswa.addCourseGrade(kursus, nilai);
                    break;
                case 2:
                    System.out.println(mahasiswa);
                    mahasiswa.printGrades();
                    System.out.println("Rata-rata nilai mahasiswa: " + mahasiswa.getAverageGrade());
                    break;
                case 3:
                    System.out.println(dosen);
                    System.out.println("Input nama kursus yang akan ditambahkan:");
                    String kursusDosen = scanner.nextLine();
                    dosen.addCourse(kursusDosen);
                    break;
                case 4:
                    ArrayList<String> courses = dosen.getCourses();
                    System.out.println("Kursus yang diajar oleh dosen:");
                    for (String course : courses) {
                        System.out.println(course);
                    }
                    System.out.println("Input nama kursus yang akan dihapus:");
                    String kursusDihapus = scanner.nextLine();
                    boolean successRemove = dosen.removeCourse(kursusDihapus);
                    if (successRemove) {
                        System.out.println("Kursus berhasil dihapus.");
                    } else {
                        System.out.println("Kursus tidak ditemukan.");
                    }
                    break;
                case 5:
                    run = false;
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}