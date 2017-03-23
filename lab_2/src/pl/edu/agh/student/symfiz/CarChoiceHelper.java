package pl.edu.agh.student.symfiz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pl.edu.agh.student.symfiz.CarChoiceHelper.carType.LUXURY;
import static pl.edu.agh.student.symfiz.CarChoiceHelper.carType.SPORT;
import static pl.edu.agh.student.symfiz.CarChoiceHelper.carType.URBAN;

public class CarChoiceHelper {
    public enum carType {SPORT, URBAN, LUXURY}

    private class CarData {
        CarData(carType t, String n, int p) {
            type = t;
            name = n;
            price = p;
        }

        carType type;
        String name;
        int price;
    }

    private ArrayList<CarData> cars = new ArrayList<>();

    public String[] getCars(carType carType, int priceFrom, int priceTo) {
        cars.add(new CarData(SPORT, "Mercedes", 123000));
        cars.add(new CarData(SPORT, "BMW", 5000));
        cars.add(new CarData(URBAN, "Audi", 100));
        cars.add(new CarData(LUXURY, "Maybach", 1000000));

        List<String> properCars = cars.stream()
                .filter(car -> car.type == carType && car.price > priceFrom && car.price < priceTo)
                .map(car -> car.name)
                .collect(Collectors.toList());

        return properCars.toArray(new String[0]);
    }
}
