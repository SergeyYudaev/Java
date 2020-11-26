
public class Main {
    public static void main(String[] args) {

        Plate plate1 = new Plate(100, 150);
        Cat[] cats = new Cat[7];

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat" + (i + 1), (i + 1) * 5);
            plate1.printPlateInfo();
            cats[i].eat(plate1);
            System.out.println(cats[i]);
            System.out.println();

        }
    }
}


