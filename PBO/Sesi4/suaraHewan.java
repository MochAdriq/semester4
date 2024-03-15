class hewan {
    void makesound(){};
}

class dog extends hewan{
    @Override
    void makesound(){
        System.out.println("gug gug");
    }
}

class cat extends hewan{
    @Override
    void makesound(){
        System.out.println("nyan nyan punch");
    }
}

public class suaraHewan {
    public static void main(String[] args) {
        hewan dog = new dog();
        hewan cat = new cat();

        dog.makesound();
        cat.makesound();
    }
}