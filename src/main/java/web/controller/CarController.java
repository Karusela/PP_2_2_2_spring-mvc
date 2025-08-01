package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", required = false) Integer count, Model model) {

        List<Car> cars = List.of(
                new Car("Opel", "Red", "Billy"),
                new Car("Audi", "Yellow", "Bob"),
                new Car("Mustang", "Black", "Clint"),
                new Car("Dodge", "Green", "John"),
                new Car("Ford", "White", "Harrison")
        );

        if (count == null) {
            model.addAttribute("result", cars);
        } else {
            List<Car> result = carService.listCar(cars, count);
            model.addAttribute("result", result);
        }

        return "cars";
    }
}

