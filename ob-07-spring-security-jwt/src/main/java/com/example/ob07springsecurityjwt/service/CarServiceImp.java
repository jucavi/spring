package com.example.ob07springsecurityjwt.service;

import com.example.ob07springsecurityjwt.domain.Car;
import com.example.ob07springsecurityjwt.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarServiceImp implements CarService {

    private static final Integer MIN_DOORS = 3;
    private final Logger log = LoggerFactory.getLogger(CarServiceImp.class);
    private CarRepository carRepository;

    public CarServiceImp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        log.info("Executing findAll Cars");
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        log.info("Executing findById");
        return carRepository.findById(id);
    }

    @Override
    public Long count() {
        log.info("Get total number of cars");
        return carRepository.count();
    }

    @Override
    public Car save(Car car) {
        log.info("Creating/Updating car");

        if (!validateCars(car)) {
            return null;
        }

        Car c = carRepository.save(car);

        return c;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting car by id");

        if (id == null || id < 0) {
            log.warn("Trying to delete car with wrong id");
            return;
        }

        try {
            carRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error trying to delete car by id {}", id, e);
        }
    }

    @Override
    public void deleteAll() {
        log.info("Deleting all cars");
        carRepository.deleteAll();
    }

    @Override
    public void deleteAll(List<Car> cars) {
        log.info("Deleting from a list of cars");

        if (CollectionUtils.isEmpty(cars)) {
            log.warn("Trying to delete an empty or null car list");
            return;
        }

        carRepository.deleteAll(cars);
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        log.info("Deleting cars from a list of ids");

        if (CollectionUtils.isEmpty(ids)) {
            log.warn("Trying to delete an empty or null car list");
            return;
        }
        carRepository.deleteAllById(ids);
    }

    @Override
    public List<Car> findByDoors(Integer doors) {
        log.info("Searching cars by doors");
        if (doors < MIN_DOORS) {
            log.warn("Trying to search less than allowed doors");
            return new ArrayList<>();
        }
        return carRepository.findByDoors(doors);
    }

    @Override
    public List<Car> findByManufacturerAndModel(String manufacturer, String model) {
        log.info("Searching car by manufacturer and model");

        if (!StringUtils.hasLength(manufacturer) || StringUtils.hasLength(model)) {
            return new ArrayList<>();
        }

        return carRepository.findByManufacturerAndModel(manufacturer, model);
    }

    @Override
    public List<Car> findByModelContaining(String model) {
        log.info("Searching cars by model");

        if (!StringUtils.hasLength(model)) {
            return new ArrayList<>();
        }

        return carRepository.findByModelContaining(model);
    }

    @Override
    public List<Car> findByDoorsGreaterThanEqual(Integer doors) {
        log.info("Searching cars with number of doors greater or equal than {}", doors);
        if (doors < MIN_DOORS) {
            log.warn("Trying to search less than allowed doors");
            return new ArrayList<>();
        }
        return carRepository.findByDoorsGreaterThanEqual(doors);
    }

    @Override
    public List<Car> findByYearBetween(Integer startYear, Integer endYear) {
        return carRepository.findByYearBetween(startYear, endYear);
    }

    @Override
    public List<Car> findByYearIn(List<Integer> years) {
        return carRepository.findByYearIn(years);
    }

    @Override
    public List<Car> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate) {
        return carRepository.findByReleaseDateBetween(startDate, endDate);
    }

    @Override
    public List<Car> findByAvailableTrue() {
        return carRepository.findByAvailableTrue();
    }

    @Override
    public Long deleteAllByAvailableFalse() {
        return carRepository.deleteAllByAvailableFalse();
    }

    private boolean validateCars(Car car) {
        if (car == null) {
            log.warn("Trying to create null car");
            return false;
        }

        if (car.getDoors() == null || car.getDoors() < MIN_DOORS) {
            log.warn("Trying to create a car with not allowed number of doors");
            return false;
        }

        return true;
    }
}
