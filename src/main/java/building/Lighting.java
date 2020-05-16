package building;

public class Lighting {

    //задаем общие свойства класса Lighting
    private String name;
    private int brightness;

    //конструктор класса Lighting
    public Lighting(String name, int brightness) {
        this.name = name;
        this.brightness = brightness;
    }

    //представление данных класса в читаемом виде
    @Override
    public String toString() {
        return +brightness + " лк";
    }

    //получение свойства brightness экземпляра класса Lighting
    public int getBrightness() {
        return brightness;
    }

}
