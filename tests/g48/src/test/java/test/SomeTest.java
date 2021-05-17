package test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static helpers.ExcelHelpers.*;

public class SomeTest
{
    @Test
    public void someExcel(){
                        readDataFromExcelFile(
                                "/Users/alina/Documents/Homework/G48-Homework/tests/g48/src/main/resources/testData/Document",
                                "Sheet1")
                .forEach(System.out::println);
    }

    @Test
    public void checkExcelProvider(){
                        readDataFromExcelFile(
                                "/Users/alina/Documents/Homework/G48-Homework/tests/g48/src/main/resources/testData/Homework.xlsx",
                                "Sheet1")
                .forEach(System.out::println);
    }
    @Test
    public void checkSystemProperty(){
        System.setProperty("login", "AlinaShulha");
        String username = System.getProperty("userame", "");
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")
            + "/Users/alina/Documents/Homework/G48-Homework/tests/g48/src/main/resources/log4j2.properties"));
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(prop);
    }
}
