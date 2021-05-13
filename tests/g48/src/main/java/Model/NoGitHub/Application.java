package Model.NoGitHub;//import Model.NoGitHub.Bike;
//import Model.NoGitHub.Car;
//import Model.NoGitHub.Item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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
        System.setProperty("webdriver.chrome.driver", "/Users/alina/Documents/Homework/G48-Homework/tests/g48/src/main/resources/Chrome90/chromedriver_mac64.zip");
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
            driver.findElement(By.xpath("//span[@class = ('css-truncate-target')]")).click();
            driver.findElement(By.xpath("//a[@href = 'https://github.com/AlinaSHulha/G48-Homework/tree/Homework2']")).click();
            driver.findElement(By.xpath("//a[@href='/AlinaSHulha/G48-Homework/tree/Homework2/tests/g48']")).click();
            driver.findElement(By.xpath("//a[@href='/AlinaSHulha/G48-Homework/blob/Homework2/tests/g48/pom.xml']")).click();
            String actual = driver.findElement(By.xpath("//td[@id='LC35']")).getAttribute("textContent");

            Assert.assertTrue("Version is not matches", actual.contains("3.141.59"));

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