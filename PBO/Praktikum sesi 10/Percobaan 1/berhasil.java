public class berhasil{
    public static void main(String[] args) {
        int a[] = new int[5];
        try {
            a[5] = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Terjadi pelanggaran memori");
        }
    }
}
