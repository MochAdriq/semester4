
public class Mobil {
    protected String merk;
    protected int harga, kecepatan;

    Mobil(String merk, int harga, int kecepatan){
        this.merk = merk;
        this.harga = harga;
        this.kecepatan = kecepatan;
    }
    
    Mobil(){
        
    }
    
    void setmerk (String brand){
        merk = brand;
    }

    void setHargaKecepatan (int harga, int kecepatan){
        this.harga = harga;
        this.kecepatan = kecepatan;
    }

    String getMerk(){
        return merk;
    }

    int getHarga(){
        return harga;
    }
    
    int getKecepatan(){
        return kecepatan;
    }
    
    void info(){
        System.out.println("-----------------------------");
        System.out.println("merk : "+ getMerk());
        System.out.println("harga : "+ getHarga());
        System.out.println("balap : " + getKecepatan());
    }
}