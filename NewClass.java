package GeekBrainHW1;


import java.util.Scanner;

public class NewClass {
    public static void main(String[] args) {

        System.out.println("Задание 3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий");
        System.out.println("результат,где a, b, c, d – входные параметры этого метода");
        Scanner sc1 = new Scanner(System.in);
        System.out.println("-введите значение переменной а");
        int a = sc1.nextInt();
        System.out.println("a=" + a);
        System.out.println("-введите значение переменной b");
        int b = sc1.nextInt();
        System.out.println("b=" + b);
        System.out.println("-введите значение переменной c");
        int c = sc1.nextInt();
        System.out.println("c=" + c);
        System.out.println("-введите значение переменной d");
        int d = sc1.nextInt();
        System.out.println("d=" + d);
        calculateIt(a, b, c, d);

        System.out.println("Задание 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в");
        System.out.println("пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false");
        System.out.println("-введите первое число");
        int a1 = sc1.nextInt();
        System.out.println("Первое число = " + a1);
        System.out.println("-введите второе число");
        int b1 = sc1.nextInt();
        System.out.println("Второе число = " + b1);
        System.out.println(compare(a1, b1));
        System.out.println("----------------------------------------------");

        System.out.println("Задание 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать");
        System.out.println("в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом");
        System.out.println("-Введите число");
        int x = sc1.nextInt();
        positive(x);

        System.out.println("Задание 6. Написать метод, которому в качестве параметра передается");
        System.out.println("целое число, метод должен вернуть true, если число отрицательное");
        System.out.println("-Введите число");
        int y = sc1.nextInt();
        if (negative(y)) System.out.println("true");
        else System.out.println("false");
        System.out.println("----------------------------------------------");

        System.out.println("Задание 7 Написать метод, которому в качестве параметра передается строка, обозначающая имя,");
        System.out.println("метод должен вывести в консоль сообщение «Привет, указанное_имя!");
        System.out.println("-Введите свое имя");
        Scanner sc2 = new Scanner(System.in);
        String s = sc2.nextLine();
        callName(s);

        System.out.println("Задание 8 Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.");
        System.out.println("Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный");
        System.out.println("-Какой сейчас год?");
        int year = sc1.nextInt();
        whatsYear(year);

        sc1.close();
        sc2.close();

    }

    public static void calculateIt(int a, int b, int c, int d) {

        int result = a * (b + (c / d));
        System.out.println("рузультат = a * (b + (c / d)) = " + result);
        System.out.println("----------------------------------------------");

    }

    public static boolean compare(int a1, int b1) {
        int sum = a1 + b1;
        return (sum >= 10) && (sum <= 20);

    }

    public static void positive(int x) {
        if (x >= 0) {
            System.out.println("Это положительное число");
        } else System.out.println("Это отрицательное число");
        System.out.println("----------------------------------------------");
    }

    public static boolean negative(int y) {
        return y < 0;

    }

    public static void callName(String s) {
        System.out.println("Привет, " + s + "!");
        System.out.println("----------------------------------------------");
    }

    public static void whatsYear(int year) {
        if (!(year % 4 == 0) || (year % 100 == 0) && !(year % 400 == 0)) {
            System.out.println("Это не високосный год");
        } else {
            System.out.println("Это високосный год");
        }
    }

}
