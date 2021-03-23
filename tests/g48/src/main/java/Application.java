//import Model.Bike;
//import Model.Car;
//import Model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import java.util.ArrayList;
//import java.util.List;
import java.util.concurrent.TimeUnit;

//import static java.lang.String.format;
//import static model.Car.count;
//import static models.Type.NORMAL;

public class Application {

    private final static Logger LOG = LogManager.getLogger("Тест");


    public static void main(String[] args) {
        LOG.info("=========Start========");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        try {

            driver.get("https://github.com/login");
            driver.findElement(By.name("login")).sendKeys("AlinaSHulha");
            driver.findElement(By.name("password")).sendKeys("Richard123789456");
            driver.findElement(By.name("commit")).click();
            driver.findElement(By.xpath("//summary[@aria-label = 'View profile and more' ]  ")).click();
            driver.findElement(By.xpath("//a[@href='/AlinaSHulha?tab=repositories']")).click();
            driver.findElement(By.xpath("//a[@href='/AlinaSHulha/G48-Homework']")).click();
            driver.findElement(By.xpath("//a[@href='/AlinaSHulha/G48-Homework/tree/Homework1.1/tests/g48']")).click();
            driver.findElement(By.xpath("//a[@href='/AlinaSHulha/G48-Homework/blob/Homework1.1/tests/g48/pom.xml']")).click();

          //  LOG.error(driver.findElement(By.xpath("//div[@class = 'flash flash-full flash-error ']/div")).getText());
        } finally {
            driver.quit();
        }

//        String[] colors = new String[]{
//                "red",
//                "blue",
//                "green",
//                "yellow"};
//
//        List<Car> cars = new ArrayList<>();
//
//        for (String color : colors) {
//            LOG.debug(format("Передаём цвет %s в конструктор Car", color));
//            switch (color) {
//                case "red":
//                    cars.add(new Car("Lexus", color));
//                    break;
//                case "blue":
//                    cars.add(new Car("BMW", color));
//                    break;
//                case "yellow":
//                    cars.add(new Car("Ford", color));
//                    break;
//                default:
//                    cars.add(new Car("Tesla", color));
//                    break;
//            }
//
//        }
//        LOG.info(cars);
//
//        List<String> carNames = new ArrayList<>();
//        for (Car car : cars) {
//            car.showName();
//            carNames.add(car.getCarName());
//        }
////        Item.showElements(carNames);
//////        Item.showElements(null);
//
//        Car myCar = new Car();
//        Item[] item = null;
//        myCar.showElements(item);
//        Bike myBike = new Bike();
//        Car[] carArray = new Car[]{
//                new Car("Ford", "black"),
//                new Car("BMW", "blue")
//        };
//        myBike.showElements(carArray);
//        myBike.showElements(carNames);
    }

}