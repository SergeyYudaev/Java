package GeekBrainHW6;

public class MainClass {

    public static void main(String[] args) {
        Cat cat1 = new Cat("cat1");
        Dog dog1 = new Dog("dog1");
        Dog dog2 = new Dog("dog2");

        cat1.run(400);
        cat1.run(100);
        cat1.jump(1);
        cat1.jump(3);
        cat1.swim(10);
        System.out.println();

        dog1.run(300);
        dog1.jump(0.2);
        dog1.jump(1);
        dog1.swim(5);
        dog1.swim(15);
        System.out.println();

        dog2.run(600);

    }


}
