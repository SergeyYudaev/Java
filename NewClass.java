
package GeekBrainHW2;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Scanner;


public class NewClass {

    public static void main(String[] args) {


        System.out.print("\n");
        System.out.println("//Задание 1. Задать целочисленный массив, состоящий из элементов 0 и 1.\n//Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0.");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Исходный массив ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
        System.out.print("Обратный массив ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            System.out.print(arr[i] + " ");

        }
        System.out.println("\n");


        System.out.println("//Задание 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;");
        System.out.print("Полученный массив: ");
        int[] arr1 = new int[8];
        for (int i = 0; i < 8; i++) {
            arr1[i] = i * 3;
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\n");


        System.out.println("//Задание 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2");
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Исходный массив ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.print("Измененн. массив ");
        for (int j = 0; j < arr2.length; j++) {
            if (arr2[j] < 6) {
                System.out.print((arr2[j] * 2) + " ");
            } else {
                System.out.print(arr2[j] + " ");
            }
        }
        System.out.println("\n");


        System.out.println("//Задание 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), \n//и с помощью цикла(-ов) заполнить его диагональные элементы единицами");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int length = sc.nextInt();
        int[][] arr3 = new int[length][length];
        int count = 1;
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3.length; j++) {
                if ((i == j) || ((i + j) == arr3.length - 1)) {
                    arr3[i][j] = 1;
                } else {
                    arr3[i][j] = 0;
                }
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }


        System.out.print("\n");
        System.out.println("//Задание 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)");
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите длину линейного массива");
        //Есть какой-то способ в цикле for выполнить какое-то условие только один раз?
        int max = -2147483648;
        int min = 2147483647;
        int length2 = sc1.nextInt();
        int[] arr4 = new int[length2];
        for (int i = 0; i < length2; i++) {
            System.out.print("Введите значение очередного элемента массива: ");
            arr4[i] = sc1.nextInt();
            if (arr4[i] > max) {
                max = arr4[i];
            }
            if (arr4[i] < min) {
                min = arr4[i];
            }
        }
        System.out.print("Ваш массив: ");
        for (int i = 0; i < length2; i++) {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();
        System.out.println("Наибольший элемент массива: " + max);
        System.out.println("Наменьший элемент массива: " + min);

        System.out.print("\n");
        System.out.println("//Задание 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, \n//если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, \n//checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.");
        System.out.println("Установите длину массива");
        Scanner sc2 = new Scanner(System.in);
        int balanceArrLength = sc2.nextInt();
        int balanceArr[] = new int[balanceArrLength];
        for (int i = 0; i < balanceArr.length; i++) {
            System.out.print("Введите очередной элемент массива: ");
            balanceArr[i] = sc2.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < balanceArr.length; i++) {
            System.out.print(balanceArr[i] + " ");
            sum += balanceArr[i];
        }
        System.out.println(" -> " + balance(balanceArr, sum));

        System.out.print("\n");
        System.out.println("//Задание 7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),\n//при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.");
        System.out.print("Установите длину массива: ");
        Scanner sc3 = new Scanner(System.in);
        int runningArrLength = sc3.nextInt();
        int runningArr[] = new int[runningArrLength];
        for (int i = 0; i < runningArr.length; i++) {
            System.out.print("Введите очередной элемент массива: ");
            runningArr[i] = sc3.nextInt();
        }
        System.out.print("Исходный массив: ");
        for (int i = 0; i < runningArrLength; i++) {
            System.out.print(runningArr[i] + " ");
        }
        System.out.print("\nВведите число сдвига: ");
        int n = sc3.nextInt();
        runningArrMethod(runningArr, n);

    }

    public static boolean balance(int balanceArr[], int sum) {
        int lSum = 0;
        int rSum = 0;
        for (int i = 0; i < balanceArr.length; i++) {
            lSum = lSum + balanceArr[i];
            rSum = sum - lSum;
            if (lSum == rSum) {
                return true;
            }
        }
        return false;


    }

    public static void runningArrMethod(int runningArr[], int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int arrayPart = runningArr[runningArr.length - 1];
                for (int j = runningArr.length - 1; j > 0; j--) {
                    runningArr[j] = runningArr[j - 1];
                }
                runningArr[0] = arrayPart;
            }
        } else if (n < 0) {
            for (int i = 0; i < Math.abs(n); i++) {
                int arrayPart = runningArr[0];
                for (int j = 0; j < runningArr.length - 1; j++) {
                    runningArr[j] = runningArr[j + 1];
                }
                runningArr[runningArr.length - 1] = arrayPart;
            }
        }
        System.out.print("Конечный массив: ");
        for (int i = 0; i < runningArr.length; i++) {
            System.out.print(runningArr[i] + " ");
        }
    }


}
