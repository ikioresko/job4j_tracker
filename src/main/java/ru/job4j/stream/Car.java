package ru.job4j.stream;

public class Car {
    private String model;
    private String color;
    private double engine;
    private double fuelTank;
    private int door;
    private int wheelsInch;

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", color='" + color + '\''
                + ", engine=" + engine
                + ", fuelTank=" + fuelTank
                + ", door=" + door
                + ", wheelsInch=" + wheelsInch + '}';
    }
    
    static class Builder {
        private String model;
        private String color;
        private double engine;
        private double fuelTank;
        private int door;
        private int wheelsInch;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildEngine(double engine) {
            this.engine = engine;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildFuelTank(double fuelTank) {
            this.fuelTank = fuelTank;
            return this;
        }

        Builder buildDoor(int door) {
            this.door = door;
            return this;
        }

        Builder buildWheelsInch(int wheelsInch) {
            this.wheelsInch = wheelsInch;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.model = model;
            car.color = color;
            car.engine = engine;
            car.fuelTank = fuelTank;
            car.door = door;
            car.wheelsInch = wheelsInch;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildModel("Lada")
                .buildColor("White")
                .buildEngine(1.6)
                .buildFuelTank(45)
                .buildDoor(4)
                .buildWheelsInch(17)
                .build();
        System.out.println(car);
    }
}