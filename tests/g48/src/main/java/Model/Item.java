package Model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public abstract class Item {

    private String type;
    protected final Logger log;
    protected String name;

    public Item(String name){
        this.log = LogManager.getLogger(name);
        this.name = name;
    }
    public void showName() {
        System.out.println("Car name: " + this.name);
    }

    public static void showElements(List<String> List) {
        for (String element: List) {
            System.out.println("Result: " + element);
            String[] split = element.split("");
            for( String el : split ){
                System.out.println("  split: " + el);
            }

        }
    }


    public Item(){
        this.log = LogManager.getLogger(this.getClass().getName());
    }

    public String getType() {
        return type;
    }

    public Item setType(String type) {
        this.type = type;
        return this;

    }
}