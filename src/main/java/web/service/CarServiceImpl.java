package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2022));
        cars.add(new Car("Honda", "Civic", 2021));
        cars.add(new Car("Ford", "Mustang", 2020));
        cars.add(new Car("Chevrolet", "Cruze", 2019));
        cars.add(new Car("Nissan", "Altima", 2018));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count <= 0) {
            return new ArrayList<>();
        } else if (count >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}
