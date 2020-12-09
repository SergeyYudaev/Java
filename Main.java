import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Plate plate1 = new Plate(0, 150);
        Cat[] cats = new Cat[7];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat" + (i + 1), (i + 1) * 5);
        }

        while (!checkCats(cats)) {
            plate1.increaseFood(plate1, plate1.getFood());
            quest(cats, plate1);
        }

    }

    static void quest(Cat[] cats, Plate plate) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Покормить котов? 1-да, 0-нет: ");
        int q;
        q = sc1.nextInt();
        System.out.println();
        if (q == 1) {
            feeding(cats, plate);

        } else System.out.println("Пользователь не хочет кормить котов");

    }

    static void feeding(Cat[] cats, Plate plate) {

        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].isFullness()) {
                plate.printPlateInfo();
                cats[i].eat(plate);
                if (!cats[i].isFullness())
                    System.out.println(cats[i]);
                System.out.println();
            }
        }
    }

    static boolean checkCats(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].isFullness()) return false;
        }
        return true;
    }


}


