import java.util.*;

/**
 * Класс LaptopStore представляет собой магазин ноутбуков.
 */
public class LaptopStore {
    // Весь код класса LaptopStore
    private Set<Laptop> laptops;
    private Random random;

    /**
     * Конструктор класса LaptopStore.
     */
    public LaptopStore() {
        laptops = new HashSet<>();
        random = new Random();
    }

    /**
     * Генерирует указанное количество ноутбуков и добавляет их в магазин.
     *
     * @param count Количество ноутбуков для генерации.
     */
    public void generateLaptops(int count) {
        String[] models = {"Dell", "HP", "Lenovo", "Asus", "Acer", "MSI", "Huawei"};
        int[] ramOptions = {4, 8, 16, 32, 64};
        int[] hddOptions = {256, 512, 1024, 2048};
        String[] osOptions = {"Windows", "Linux"};
        String[] colorOptions = {"Black", "Silver", "White", "Blue", "Red"};

        for (int i = 0; i < count; i++) {
            String model = models[random.nextInt(models.length)] + "-" + (i + 1);
            int ram = ramOptions[random.nextInt(ramOptions.length)];
            int hddCapacity = hddOptions[random.nextInt(hddOptions.length)];
            String os = osOptions[random.nextInt(osOptions.length)];
            String color = colorOptions[random.nextInt(colorOptions.length)];
            double price = 500 + random.nextDouble() * 2500; // Цена от 500 до 3000

            laptops.add(new Laptop(model, ram, hddCapacity, os, color, Math.round(price * 100.0) / 100.0));
        }

    }

    /**
     * Отображает информацию обо всех доступных ноутбуках.
     */
    public void displayAllLaptops() {
        System.out.println("Все доступные ноутбуки:");
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
        System.out.println("Всего ноутбуков: " + laptops.size());
    }

    /**
     * Фильтрует ноутбуки по заданным критериям.
     */
    public void filterLaptops() {
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Цена");
            System.out.println("0 - Вывести отфильтрованный список");

            int choice = scanner.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("Введите минимальный объем ОЗУ:");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Введите минимальный объем ЖД:");
                    filters.put("hddCapacity", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Введите операционную систему:");
                    filters.put("os", scanner.next());
                    break;
                case 4:
                    System.out.println("Введите цвет:");
                    filters.put("color", scanner.next());
                    break;
                case 5:
                    System.out.println("Введите максимальную цену:");
                    filters.put("price", scanner.nextDouble());
                    break;
            }
        }

        Set<Laptop> filteredLaptops = new HashSet<>(laptops);
        for (Laptop laptop : laptops) {
            if (filters.containsKey("ram") && laptop.getRam() < (int) filters.get("ram")) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("hddCapacity") && laptop.getHddCapacity() < (int) filters.get("hddCapacity")) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("price") && laptop.getPrice() > (double) filters.get("price")) {
                filteredLaptops.remove(laptop);
            }
        }

        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }

}