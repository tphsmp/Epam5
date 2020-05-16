package building;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Room {

    //создаем логгер
    private Logger logger = LogManager.getLogger();

    //объявляем общие свойства класса Room
    final int LK = 700;
    private String name;
    private double roomSquare;
    private int windows;

    //конструктор класса Room
    public Room(String name, double roomSquare, int windows) {
        this.name = name;
        this.roomSquare = roomSquare;
        this.windows = windows;
    }

    //создаем лист осветительных приборов в помещении
    List<Lighting> lamps = new ArrayList<>();

    //метод добавления ламп в помещение и обработки исключения превышения освещенности
    public int addLighting(Lighting lighting) throws IlluminanceTooMuchException {
        if (calcCoommonBrightness() > 4000) {
            logger.error("Maximal brightness is exceeded");
            throw new IlluminanceTooMuchException("Maximal brightness is exceeded");
        } else {
            lamps.add(lighting);
            return calcLampsBrigthness();
        }
    }

    //    //метод расчета яркости ламп для передачи в интерфейс расчета общей яркости
    public int calcLampsBrigthness() {
        int lampsLight = 0;
        for (Lighting lamp : lamps) {
            lampsLight += lamp.getBrightness();
        }
        return lampsLight;
    }

    //расчет яркости окон для передачи в интерфейс расчета общей яркости
    public int calcWindowsBrightness() {
        return getWindows() * getLk();
    }

    public int calcCoommonBrightness() {
        return calcWindowsBrightness() + calcLampsBrigthness();

    }

    //получение количества окон в помещении
    public int getWindows() {
        return windows;
    }

    //получение константы яркости каждого окна
    public int getLk() {
        return LK;
    }

    //создаем лист предметов мебели в помещении
    List<Furniture> furnitures = new ArrayList<>();

    //метод добавления мебели в помещение и обработки исключения превышения занимаемой площади
    private double furnitureSquare = 0;

    public void addFurniture(Furniture furniture) throws SpaceUsageTooMuchException {
        furnitures.add(furniture);
        furnitureSquare += furniture.getFurnitureSquare();

        if ((furnitureSquare > roomSquare * 0.7)) {
            logger.error("Furniture occupies more than 70% of room!");
            throw new SpaceUsageTooMuchException("Furniture occupies more than 70% of room!");
        }
    }

    //получем общую площадь мебели в помещении
    public double getFurnitureSquare() {
        return furnitureSquare;
    }

    //расчет свободной площади помещения
    public double unbusySpace() {
        double freeSpace = new BigDecimal(roomSquare - furnitureSquare).setScale(1, RoundingMode.HALF_UP).doubleValue();
        return freeSpace;
    }

    //расчет процентного соотношения свободного места
    public double percentageUnbusySpace() {
        double percentageFreeSpace = new BigDecimal(unbusySpace() * 100 / roomSquare).setScale(1, RoundingMode.HALF_UP).doubleValue();
        return percentageFreeSpace;
    }

    //преобразование данных о помещении в строку
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", roomSquare=" + roomSquare +
                ", windows=" + windows +
                ", lamps=" +
                ", furnitures=" + furnitures +
                '}';
    }

    //получаем наименование помещения
    public String getName() {
        return name;
    }

    //получаем площадь помещения
    public double getRoomSquare() {
        return roomSquare;
    }


}
