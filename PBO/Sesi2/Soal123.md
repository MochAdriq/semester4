1. Class: Class adalah sebuah template atau blueprint yang digunakan untuk mendefinisikan atribut dan perilaku yang akan dimiliki oleh objek yang dibuat dari class tersebut. Class mendefinisikan struktur data dan fungsi yang akan digunakan oleh objek. Class juga dapat berisi variabel data (attributes), metode (methods), dan konstruktor. Class tidak menggunakan memori ketika didefinisikan, tetapi memori akan dialokasikan ketika sebuah objek dibuat dari class tersebut .
   Object: Object adalah instance dari sebuah class. Setiap objek adalah representasi dari class dan dapat menggunakan atribut dan metode yang didefinisikan dalam class tersebut. Objek memiliki state (representasi oleh atribut), behavior (representasi oleh metode), dan identity (memberikan nama unik kepada objek). Objek dibuat menggunakan keyword new dalam bahasa pemrograman seperti Java, dan setiap objek menggunakan memori yang dialokasikan untuk menyimpan state-nya

2. Metode Predefined (Metode Pratama): Metode ini sudah didefinisikan dalam library kelas Java dan dapat digunakan langsung dalam program tanpa perlu deklarasinya. Contohnya termasuk metode length(), equals(), compareTo(), dan sqrt() yang dapat digunakan untuk berbagai tugas seperti operasi matematika, perbandingan string, dan lainnya. Metode ini sering disebut sebagai metode standar atau metode bawaan .

Metode User-defined (Metode Pengguna): Metode yang dibuat oleh programmer sendiri untuk melakukan tugas-tugas tertentu sesuai dengan kebutuhan program. Metode ini dapat dideklarasikan dengan atribut-atribut seperti jenis akses (public, private, protected, default), tipe pengembalian (return type), nama metode, dan daftar parameter. Metode ini dapat mencakup semua jenis tugas yang tidak dapat dilakukan oleh metode predefined .

Metode Static: Metode ini adalah bagian dari kelas, bukan dari objek kelas. Metode static dapat dipanggil tanpa perlu membuat instance dari kelas. Contohnya adalah metode main() yang digunakan sebagai titik masuk program Java. Metode static sering digunakan untuk operasi yang tidak memerlukan state objek .

Metode Instance: Metode ini memerlukan objek dari kelas untuk dipanggil. Metode ini memiliki akses ke variabel dan metode lain dalam kelas. Metode instance dapat dibagi menjadi dua kategori utama:
Accessor Method: Metode yang digunakan untuk mengambil nilai dari variabel instance. Biasanya, metode ini memiliki nama yang diawali dengan kata get.

Mutator Method: Metode yang digunakan untuk mengubah nilai dari variabel instance. Biasanya, metode ini memiliki nama yang diawali dengan kata set.

Metode Abstract: Metode ini dideklarasikan dalam kelas abstrak dan tidak memiliki implementasi di dalam kelas itu sendiri. Metode abstrak dapat dipanggil melalui referensi objek yang merujuk ke kelas abstrak atau kelas turunannya. Metode abstrak sering digunakan dalam konsep pewarisan dan polimorfisme dalam pemrograman berorientasi objek 4.

3. `public class Komputer {`
   (1) Pada baris satu pada kode tersebut ialah mendeklarasikan kelas Komputer sebagai public, yang berarti kelas ini dapat diakses dari kelas lain dalam aplikasi.

   `
   String jenis_komputer;
   private String merk;
   `
   (2) Pada nomor 2 itu ada kode yang mendeklarasikan `jenis_komputer` dan `merk` sebagai variable ber tipe String, tetapi pada var merk terdapat penggunaan modifier private, yang berarti variabel ini hanya dapat diakses dari dalam kelas Komputer itu sendiri.

    `
   public void setDataKomputer(String jenis, String merk) {
   this.jenis_komputer = jenis;
   this.merk = merk;
   `
   (3) Pada nomor 3 Mendefinisikan metode setDataKomputer yang memungkinkan pengaturan nilai untuk jenis_komputer dan merk. Metode ini menerima dua parameter, jenis dan merk, yang keduanya bertipe String.
       Menggunakan kata kunci `this` untuk merujuk ke variabel instance `jenis_komputer` dan `merk` dari kelas `Komputer`, dan menetapkan nilai dari parameter jenis ke variabel tersebut.

`
public String getJenis() {
return jenis_komputer;
`
   (4) Mendefinisikan metode `getJenis` yang mengembalikan nilai dari variabel instance `jenis_komputer`.
       dan di bawah nya ada return yang berfungsi mengembalikan nilai dari variabel `jenis_komputer`.
   
`
public String getMerk() {
return merk;
`
   (5) Mendefinisikan metode `getMerk` yang mengembalikan nilai dari variabel instance `merk`.
       dan di bawah nya ada return yang berfungsi mengembalikan nilai dari variabel `merk`.
   
`
Komputer mykom = new Komputer();
`
   (6) Membuat objek mykom dari kelas Komputer menggunakan konstruktor default (yang dianggap ada oleh Java jika tidak ada konstruktor lainnya yang ditentukan).
   
`
mykom.setDataKomputer("LAPTOP", "MACBOOK");
`
   (7) Memanggil metode setDataKomputer pada objek mykom untuk mengatur jenis_komputer menjadi "LAPTOP" dan merk menjadi "MACBOOK".
   
`
System.out.println(mykom.getJenis());
System.out.println(mykom.getMerk());
`
   (8) Mencetak jenis komputer yang telah disetel sebelumnya ke konsol.
       Mencetak merk komputer yang telah disetel sebelumnya ke konsol.
