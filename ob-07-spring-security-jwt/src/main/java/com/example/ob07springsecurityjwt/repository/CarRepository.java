package com.example.ob07springsecurityjwt.repository;

import com.example.ob07springsecurityjwt.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByDoors(Integer doors);
    List<Car> findByManufacturerAndModel(String manufacturer, String model);
    List<Car> findByModelContaining(String model);
    List<Car> findByDoorsGreaterThanEqual(Integer doors);
    List<Car> findByYearBetween(Integer startYear, Integer endYear);
    List<Car> findByYearIn(List<Integer> years);
    List<Car> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);
    List<Car> findByAvailableTrue();
    Long deleteAllByAvailableFalse();
}
