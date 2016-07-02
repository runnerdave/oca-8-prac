class Vehicle {
    public void printSound() {
        System.out.println("vehicle");
    }
}

class Car extends Vehicle {
    public void printSound() {
        System.out.println("car");
    }
}

class Bike extends Vehicle {
    public void printSound() {
        System.out.println("bike");
    }
}

public class Test {
    public static void main(String[] args) {
        Vehicle v = new Car();
        //Vehicle v = new Bike(); //WORKS
        Bike b = (Bike) v; //THROWS ClassCastException

        v.printSound();
        b.printSound();
    }   
}