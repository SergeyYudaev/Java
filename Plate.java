
import java.util.Scanner;

public class Plate {
    private int food;
    private final int plateSize;

    public Plate(int food, int plateSize) {
        this.food = food;
        this.plateSize = plateSize;
    }

    public void printPlateInfo() {

        System.out.println("Еды в тарелке: " + this.food + " единиц еды");
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int foodSize) {
        this.food -= foodSize;

    }

    //нас не устраивает, если тарелка с горкой или если котам придется есть с пола рядом с тарелкой
    //мы осуждаем тех, кто отбирает еду у котов и требуем покормить котов
    public void increaseFood(Plate plate, int foodSize) {
        Scanner sc1 = new Scanner(System.in);
        int increase;
        boolean filled = false;
        while (!filled) {
            System.out.print("Наполните тарелку: ");
            increase = sc1.nextInt();
            System.out.println();
            if (increase > 0 && increase + foodSize <= this.plateSize) {
                plate.setFood(foodSize + increase);
                filled = true;
                printPlateInfo();
            } else if (increase > 0 && increase + foodSize > this.plateSize) {
                System.out.println("Размер тарелки " + this.plateSize + " превышен. Котам придется есть с пола, осуждаю");
                plate.setFood(foodSize + increase);
                filled = true;
                printPlateInfo();

            } else {
                System.out.println("Ты сейчас отобрал еду у котов?");
            }
        }
    }
}
