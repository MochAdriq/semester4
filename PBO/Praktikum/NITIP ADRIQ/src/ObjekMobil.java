
public class ObjekMobil {
    
        public static void main(String args[]){
            MobilDiesel md = new MobilDiesel ("fuso", 10, 10, "solar");
            md.infoMobilDiesel();
            
            MobilBensin mb = new MobilBensin ("avanza",20,20,"pertamax");
            mb.infoMobilBensin();
        }
}

