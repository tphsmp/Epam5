package building;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuildingMain {

    public static void main(String[] args) throws IlluminanceTooMuchException, SpaceUsageTooMuchException {

        System.setProperty("log4j.configurationFile", "C:\\Users\\Gleb\\Downloads\\Epam_practice\\Epam5\\src\\main\\resources\\log.xml");

        //создаем экземпляр здания 1
        Building b1 = new Building("Здание 1");

        //создаем экземпляр комнатыпомещения 1
        Room r1 = new Room("room1", 33.7d, 3);

        //добавляем помещение 1 в лист
        b1.addRoom(r1);

        //добавляем освещение в помещение 1
        r1.addLighting(new Lighting("lumen", 50));
        r1.addLighting(new Lighting("lumen", 70));

        r1.addFurniture(new Furniture("Диван", 2.7d));
        r1.addFurniture(new Furniture("Кресло", 1.3d));

        //добавлем экземпляр помещения 2
        Room r2 = new Room("room2", 24.5d, 2);

        //добавляем помещение 2 в лист
        b1.addRoom(r2);

        //добавляем освещение в помещение 2
        r2.addLighting(new Lighting("lumen", 90));

        //выводим описание здания
        b1.buildingDescription();

    }

}