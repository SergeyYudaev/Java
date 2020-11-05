package GeekBrainHW1;


import java.util.Scanner;

public class NewClass {
    public static void main(String[] args) {
        System.out.println("Задание 3");
        Scanner sc1 = new Scanner(System.in);
        System.out.println("введите значение переменной а");
        int a = sc1.nextInt();
        System.out.println("a=" + a);
        System.out.println("введите значение переменной b");
        int b = sc1.nextInt();
        System.out.println("b=" + b);
        System.out.println("введите значение переменной c");
        int c = sc1.nextInt();
        System.out.println("c=" + c);
        System.out.println("введите значение переменной d");
        int d = sc1.nextInt();
        System.out.println("d=" + d);
        calculateIt(a, b, c, d);

        System.out.println("Задание 4");
        System.out.println("введите первое число");
        int a1 = sc1.nextInt();
        System.out.println("Первое число = " + a1);
        System.out.println("введите второе число");
        int b1 = sc1.nextInt();
        System.out.println("Второе число = " + b1);
        System.out.println(compare(a1, b1));
        System.out.println("----------------------------------------------");

        System.out.println("Задание 5");
        System.out.println("Введите число");
        int x = sc1.nextInt();
        positive(x);

        System.out.println("Задание 6");
        System.out.println("Введите число");
        int y = sc1.nextInt();
        if (negative(y)) System.out.println("true");
        else System.out.println("false");
        System.out.println("----------------------------------------------");

        System.out.println("Задание 7");
        System.out.println("Введите свое имя");
        String s = "друг";
        callName(s);

        System.out.println("Задание 7");
        System.out.println("Какой сейчас год?");
        int year = sc1.nextInt();
        whatsYear(year);




    }

    public static void calculateIt(int a, int b, int c, int d) {

        int result = a * (b + (c / d));
        System.out.println("рузультат = a * (b + (c / d)) = " + result);
        System.out.println("----------------------------------------------");

    }

    public static boolean compare(int a1, int b1) {
        Boolean m = (((a1 + b1) >= 10)) && ((a1 + b1) <= 20);
        if (m) return true;
        else {
            return false;
        }

    }

    public static void positive(int x) {
        if (x >= 0) {
            System.out.println("Это положительное число");
        } else System.out.println("Это отрицательное число");
        System.out.println("----------------------------------------------");
    }

    public static boolean negative(int y) {
        if (y < 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void callName (String s){
        System.out.println("Привет, " + s);
        System.out.println("----------------------------------------------");
    }
    public static void whatsYear (int year) {
        if (!(year % 4 == 0) || (year % 100 == 0) && !(year % 400 == 0)) {
            System.out.println("Это не високосный год");
        } else {
            System.out.println("Это високосный год");}
    }

}
