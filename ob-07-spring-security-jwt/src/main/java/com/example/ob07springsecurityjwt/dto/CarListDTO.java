package com.example.ob07springsecurityjwt.dto;

import com.example.ob07springsecurityjwt.domain.Car;

import java.util.List;

/**
 * Data transfer object
 */
public class CarListDTO {

    private List<Car> cars;

    public CarListDTO() {}

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
