import Model.Car;
import Model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static Model.Car.count;

public class Application {

    private final static Logger LOG = LogManager.getLogger("Тест");

    public static void main(String[] args) {

        String[] colors = new String[]{
                "red",
                "blue",
                "green",
                "yellow"};

        List<Car> cars = new ArrayList<>();

        for (String color : colors) {
            LOG.debug(format("Передаём цвет %s в конструктор Car", color));
            switch (color) {
                case "red":
                    cars.add(new Car("Lexus", color));
                    break;
                case "blue":
                    cars.add(new Car("BMW", color));
                    break;
                case "yellow":
                    cars.add(new Car("Ford", color));
                    break;
                default:
                    cars.add(new Car("Tesla", color));
                    break;
            }

        }
        LOG.info("Текущее количество машин: " + count);
        try {
            throw new IllegalArgumentException(
                    "Ошибка " +
                            "переменной");
        } catch (IllegalArgumentException i) {
            LOG.error(i);
        }
        {
            try {
                throw new IllegalAccessException(
                        "Неизвестная ошибка");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                LOG.error(e);
            }

        }
        LOG.info(cars);

        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            car.showName();
            carNames.add(car.getCarName());
        }
        Item.showElements(carNames);

    }

}