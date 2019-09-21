package com.chang.demo.study.jdk8.useFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author: changhao
 * @time: 2019-09-04
 */
public class Car {
    private String name;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Car create(Supplier<Car> supplier){
        return supplier.get();
    }

    public static void follow(final Car car){
        car.setName("d");
        System.out.println("Follow the "+car.toString());
    }

    public void collide(Car car){
        System.out.println("collide the "+car.toString());
    }

    public void repair(){
        System.out.println("repair the "+this.toString());
    }

    public static void main(String[] args) {
        Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::follow);
        cars.forEach(car::collide);
        cars.forEach(Car::repair);

    }
}
