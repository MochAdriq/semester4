
public class MobilBensin extends Mobil{
    
    String bahanBakar;
    
    MobilBensin(String merk, int harga, int kecepatan, String bahanBakar){
        super(merk,harga,kecepatan);
        this.bahanBakar = bahanBakar;
    }
    
    String getBahanBakar(){
        return bahanBakar;
    }
    
    void infoMobilBensin(){
        super.info();
        System.out.println("Bahan Bakar : " + getBahanBakar());
    }
}
