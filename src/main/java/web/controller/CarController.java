package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;



import java.util.List;

@Controller
public class CarController {


    private CarService carService;

    @Autowired
    private CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCarsByCount(@RequestParam(defaultValue = "5") int count, Model model) {
        List<Car> cars = carService.getCarsByCount(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
