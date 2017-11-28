package com.company;

import java.util.Random;

/**
 * 1. механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет
 2. найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000
 3. найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
 4. добавить к данной иерархии машину-амфибию, и БетМобиль, создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble
 */

interface SwimAble{
    int swim();
}

interface Flyable{
    int fly();
}

interface Moveable{
    int move();
}

class Vehicle {

    private String name;
    private int price;

    public Vehicle(String name, int price) {
        super();
        this.name = name;
        this.price= price;
    }

    public Vehicle(String name) {
        super();
        this.name = name;
    }

    public Vehicle() {
        super();
        this.name = "Mashina";
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle [name=" + name + "price = "+ price + "]";
    }
}

class Ship extends Vehicle implements SwimAble {

    private int weight;

    public Ship(String name, int price, int weight) {
        super(name, price);
        this.weight = weight;
    }

    public Ship(String name, int weight) {
        super(name);
        this.weight = weight;
    }

    public Ship() {
        this("Igrannic", 2222);
    }
    public int swim() {
        return 100;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ship:" + super.getName() + ", weight = " + weight;
    }
}

class Plane extends Vehicle {

    private int year;

    public Plane(String name, int price, int year) {
        super(name, price);
        this.year = year;
    }

    public Plane(String name, int year) {
        super(name);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Plane [year of issue =" + year + ", Name=" + getName() + "]";
    }
}

class RandomVehicle{
    public static Vehicle randomVehicle() {
        Random r = new  Random();
        return nextVehicle(r.nextInt(6));
    }
    public static Vehicle nextVehicle(int key) {
        switch (key) {
            case 0: return new Vehicle("Mashina", 1144);
            case 1: return new Plane("Boing228", 600000, 2008);
            case 2: return new Ship("Chelsea", 12000, 1234);
            case 3: return new Vehicle("zhiguli", 255);
            case 4: return new Plane("tutu", 600000, 1998);
            case 5 : return new Ship("Kvitka", 7777, 888);

            default: return null;
        }
    }
}



public class Main {

    public static void main(String[] args) {

        Vehicle veh = new Vehicle();

        Ship ship1 = new Ship("Titan", 19999, 3000);
        Plane plane1 = new Plane("Boing", 66666, 2008);

        Vehicle[] masVeh = new Vehicle[30];
        for (int i = 0; i < masVeh.length; i++) {
            masVeh[i] = RandomVehicle.randomVehicle();
        }




        for (Vehicle vehicle : masVeh) {
            if (vehicle.getPrice() < 333 )
                System.out.println(vehicle);

            if (vehicle instanceof Plane && ((Plane) vehicle).getYear()>2000)
                System.out.println(vehicle);


        }

    }
}