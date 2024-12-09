package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> cars;

    public CarDaoImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2022));
        cars.add(new Car("Honda", "Civic", 2021));
        cars.add(new Car("Ford", "Mustang", 2020));
        cars.add(new Car("Chevrolet", "Cruze", 2019));
        cars.add(new Car("Nissan", "Altima", 2018));
    }

    @Override
    public List<Car> getCarsByCount(int count) {
        if (count == 0) {
            return new ArrayList<>(cars);
        }
        return cars.stream()
                .limit(Math.max(count, 0))
                .collect(Collectors.toList());
    }

}
