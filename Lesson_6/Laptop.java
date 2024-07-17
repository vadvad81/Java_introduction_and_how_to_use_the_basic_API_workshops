import java.util.*;

/**
 * Класс Laptop представляет собой модель ноутбука.
 */
public class Laptop {
    private String model;
    private int ram;
    private int hddCapacity;
    private String os;
    private String color;
    private double price;

    /**
     * Конструктор класса Laptop.
     *
     * @param model       Модель ноутбука.
     * @param ram         Объем оперативной памяти в ГБ.
     * @param hddCapacity Объем жесткого диска в ГБ.
     * @param os          Операционная система.
     * @param color       Цвет ноутбука.
     * @param price       Цена ноутбука.
     */
    public Laptop(String model, int ram, int hddCapacity, String os, String color, double price) {
        this.model = model;
        this.ram = ram;
        this.hddCapacity = hddCapacity;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public int getHddCapacity() {
        return hddCapacity;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Возвращает строковое представление объекта в формате:
     * "Laptop{model='...', ram=..., hddCapacity=..., os='...', color='...', price=...}"
     *
     * @return строковое представление информации о ноутбуке.
     */
    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", ram=" + ram +
                ", hddCapacity=" + hddCapacity +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }


    // Весь код класса Laptop
}