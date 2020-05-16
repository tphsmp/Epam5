package building;

public class Furniture {

    //объявляем общие свойства класса мебель
    private String name;
    private double furnitureSquare;

    //конструктор класса мебель
    public Furniture(String name, double furnitureSquare) {
        this.name = name;
        this.furnitureSquare = furnitureSquare;
    }

    //вывод класса мебель в читаемом виде
    @Override
    public String toString() {
        return  name + " " + furnitureSquare + " м^2";
    }

    //получение переменной площадь экземпляра класса мебель
    public double getFurnitureSquare() {
        return furnitureSquare;
    }
}
