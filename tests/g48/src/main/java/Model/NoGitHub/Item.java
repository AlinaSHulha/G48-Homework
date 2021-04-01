package Model.NoGitHub;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public abstract class Item {

    private String type;
    protected final Logger log;
    protected String name;

    public Item(String name) {
        this.log = LogManager.getLogger(name);
        this.name = name;
    }

    public void showName() {
        log.info("Car name: " + this.name);
    }

    public void showElements(List<String> List) {
        try {
            for (String element : List) {
                log.info("Result: " + element);
                String[] split = element.split("");
                for (String el : split) {
                    log.info("  split: " + el);
                }
            }
        } catch (NullPointerException npe) {
            log.error(format("Массив не определён. Пожалуйста проверте корректность вводимых значений"));
        } catch (Exception e) {
            log.error("Произошла неизвесная ошибка. Подробнее: ");
            e.printStackTrace();
        }
    }

    public void showElements(Item[] items) {
        List<String> list = new ArrayList<>();
        try {
            for (Item item : items) {
                list.add(item.name);
            }
            this.showElements(list);
        } catch (NullPointerException npe) {
            log.info("Массив не определён. Пожалуйста проверте корректность вводимых значений");
        }
    }


    public Item() {
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