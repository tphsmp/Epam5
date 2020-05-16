
package building;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Building {

    //создаем логгер
    Logger logger = LogManager.getLogger();

    //задаем свойства класса
    private String name;

    //задаем название здания
    public Building(String name) {
        this.name = name;
    }

    //создаем лист помещенийв здании
    List<Room> rooms = new ArrayList<>();

    //метод описание здания и комнат
    public void buildingDescription() {
        for (Room room : rooms) {

            logger.info("Здание: " + getName() + " Комната " + room.getName() + " Освещенность " + room.calcCoommonBrightness() + " " + room.getWindows() + " окна" +
                    " по " + room.getLk() + " лк" + " Лампочки " + room.lamps + "\n" +
                    "Площадь " + room.getRoomSquare() + " м^2 " + " Занято " + room.getFurnitureSquare() + " м^2 " + " свободно: " + room.unbusySpace() + " м^2 в процентах "
                    + room.percentageUnbusySpace() + "%");

            //проверка наличия мебели в комнате
            if (room.furnitures.isEmpty()) {
                logger.info("Мебель: No furniture in " + room.getName());
            } else {
                logger.info("Мебель: " + room.furnitures);
            }
        }
    }

    //конструктор добавлениея помещения
    public void addRoom(Room room) {
        rooms.add(room);
    }

    //получаем наименование здания
    public String getName() {
        return name;
    }

}


