package creational;

interface Vehicle {
    void drive();
}
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a Car");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Riding a Bike");
    }
}
class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        // Get a Car object
        Vehicle v1 = VehicleFactory.getVehicle("car");
        v1.drive();

        // Get a Bike object
        Vehicle v2 = VehicleFactory.getVehicle("bike");
        v2.drive();
    }
}
