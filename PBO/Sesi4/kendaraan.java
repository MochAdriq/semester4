class Vehicle {
    void drive() {
        System.out.println("Driving a vehicle");
    }

    void drive(String location) {
        System.out.println("Driving to " + location);
    }
}

class Car extends Vehicle {
    @Override
    void drive() {
        System.out.println("Driving a car");
    }
}

class Motorcycle extends Vehicle {
    @Override
    void drive() {
        System.out.println("Riding a motorcycle");
    }
}

public class kendaraan {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();

        vehicle.drive();
        vehicle.drive("the city \n");

        car.drive();
        car.drive("the mall \n");

        motorcycle.drive();
        motorcycle.drive("the countryside \n");
    }
}