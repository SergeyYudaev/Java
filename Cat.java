
public class Cat {
    private final String name;
    private final int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    //коты очень характерные и домашние, поэтому примем, что в рамках данной задачи
    //голодный кот будет просить еду, пока мы его не накормим, т.к. охотиться не умеет


    public void eat(Plate plate) {
        if (plate.getFood() - this.appetite >= 0) {
            plate.decreaseFood(this.appetite);
            System.out.println(this.name + " съел из тарелки " + appetite + " единиц еды. Осталось еды в тарелке: " + plate.getFood());
            fullness = true;
        } else {
            System.out.println("Коту " + this.name + " не хватило еды. Еды в тарелке:" + plate.getFood());
            fullness = false;
            System.out.println(this);
            plate.increaseFood(plate, plate.getFood());
            eat(plate);
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", fullness=" + fullness +
                '}';
    }


}
