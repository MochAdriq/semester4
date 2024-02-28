public class MobilDiesel extends Mobil {
    
    String bahanBakar;
    
    MobilDiesel(String merk, int harga, int kecepatan, String bahanBakar){
        super(merk,harga,kecepatan);
        this.bahanBakar = bahanBakar;
    }
    
    void setBahanBakar(String bahanBakar){
        this.bahanBakar = bahanBakar;        
    }
    
    String getBahanBakar(){
        return bahanBakar;
    }
    
    void infoMobilDiesel(){
        super.info();
        System.out.println("Bahan Bakar : " + getBahanBakar());
    }
}