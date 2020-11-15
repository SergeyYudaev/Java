package Lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class newGame {
    public static int SIZE = 5;
    public static int DOTS_DO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] field;
    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        initField();
        printField();
        while (true) {
            gamerTurn();
            System.out.println("Вы сделали ход:");
            printField();
            if (gameOver()) {
                System.out.println("Ничья");
                break;
            }
            if (win(DOT_X)) {
                System.out.println("Вы победили");
                break;
            }
            machineTurn();
            System.out.println("Машина сделала ход:");
            printField();
            if (gameOver()) {
                System.out.println("Ничья");
                break;
            }
            if (win(DOT_O)) {
                System.out.println("Вы проиграли");
                break;
            }
        }
    }

    public static void initField() {
        field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            Arrays.fill(field[i], DOT_EMPTY);
    }

    public static void printField() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void gamerTurn() {
        int x, y;
        do {
            System.out.println("Введте координаты");
            System.out.print("Строка: ");
            x = sc.nextInt() - 1;
            System.out.print("Столбец: ");
            y = sc.nextInt() - 1;
        }
        while (isNotValid(x, y));
        field[x][y] = DOT_X;
    }

    public static void machineTurn() {
        int x, y;
        if (!aiCanBeatYou()) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }
            while (isNotValid(x, y));
            field[x][y] = DOT_O;
        }
    }


    public static boolean isNotValid(int x, int y) {
        if (x < 0 || y < 0 || x > SIZE || y > SIZE) return true;
        return field[x][y] != DOT_EMPTY;
    }

    public static boolean gameOver() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }


    public static boolean win(char dot) {
        int counter = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == dot) {

                    if (SIZE - j >= DOTS_DO_WIN) { //смотрим серию по горизонтали
                        for (int k = 1; k < DOTS_DO_WIN; k++) {
                            if (field[i][j + k] == dot) counter++;
                            else {
                                counter = 1;
                                break;
                            }
                            if (counter == DOTS_DO_WIN) return true;
                        }
                    }

                    if (SIZE - i >= DOTS_DO_WIN) { //смотрим серию по вертикали
                        for (int k = 1; k < DOTS_DO_WIN; k++) {
                            if (field[i + k][j] == dot) counter++;
                            else {
                                counter = 1;
                                break;
                            }
                            if (counter == DOTS_DO_WIN) return true;
                        }
                    }

                    if ((SIZE - i >= DOTS_DO_WIN) && (SIZE - j >= DOTS_DO_WIN)) { // Смотрим \-диагональ
                        for (int k = 1; k < DOTS_DO_WIN; k++) {
                            if (field[i + k][j + k] == dot) counter++;
                            else {
                                counter = 1;
                                break;
                            }
                            if (counter == DOTS_DO_WIN) return true;
                        }
                    }

                    if ((SIZE - i >= DOTS_DO_WIN) && (j + 1 >= DOTS_DO_WIN)) { // смотрим /-диагональ
                        for (int k = 1; k < DOTS_DO_WIN; k++) {
                            if (field[i + k][j - k] == dot) counter++;
                            else {
                                counter = 1;
                                break;
                            }
                            if (counter == DOTS_DO_WIN) return true;
                        }
                    }


                }
            }
        }
        return false;
    }

    public static boolean aiCanBeatYou() {


        for (int i = 0; i < SIZE; i++) { //если в строке фишек игрока на 1 меньше, чем надо для победы, заполним строку
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == DOT_X) {
                    counter++;
                    if (DOTS_DO_WIN - counter < 2) {
                        for (int k = 0; k < SIZE - 1; k++) {
                            if (k != SIZE - 1 && field[i][k] == DOT_X && field[i][k + 1] == DOT_EMPTY) {
                                field[i][k + 1] = DOT_O;
                                return true;
                            }
                            if (k != 0 && field[i][k] == DOT_X && field[i][k - 1] == DOT_EMPTY) {
                                field[i][k - 1] = DOT_O;
                                return true;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < SIZE; i++) { //если в столбце фишек игрока на 1 меньше, чем надо для победы, заполним строку
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[j][i] == DOT_X) {
                    counter++;
                    if (DOTS_DO_WIN - counter < 2) {
                        for (int k = 0; k < SIZE - 1; k++) {
                            if (k != SIZE - 1 && field[k][i] == DOT_X && field[k + 1][i] == DOT_EMPTY) {
                                field[k + 1][i] = DOT_O;
                                return true;
                            }
                            if (k != 0 && field[k][i] == DOT_X && field[k - 1][i] == DOT_EMPTY) {
                                field[k - 1][i] = DOT_O;
                                return true;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < SIZE; i++) { //если в "\" диагонали фишек игрока на 1 меньше...
            for (int j = 0; j < SIZE; j++) {
                int counter = 0;
                int counterOfEmpty = 0; //эта переменная считает, были ли у нас пустые поля до того, как мы нашли достаточно DOT_X
                //причем если пустое поле будет между двумя DOT_X, это не ломает логику, мы просто будем итерировать вверх, а не вниз
                for (int k = 0; k < SIZE - Math.max(i, j) && DOTS_DO_WIN - counter > 1; k++) {
                    if (field[i + k][j + k] == DOT_X) counter++;
                    if (field[i + k][j + k] == DOT_EMPTY) counterOfEmpty++;
                }

                if (DOTS_DO_WIN - counter < 2 && counterOfEmpty < 1) {
                    for (int k = 1; k < SIZE - Math.max(i, j); k++) {
                        if (field[i][j] == DOT_X && field[i + k][j + k] == DOT_EMPTY) {
                            field[i + k][j + k] = DOT_O;
                            return true;
                        }
                    }
                }
                if (DOTS_DO_WIN - counter < 2) {
                    for (int k = 1; k <= Math.min(i, j); k++) {
                        if (field[i][j] == DOT_X && field[i - k][j - k] == DOT_EMPTY) {
                            field[i - k][j - k] = DOT_O;
                            return true;
                        }
                    }
                }
            }
        }

        char[][] fieldRotate = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {//заполням доп. матрицу = нашему полю, повернутому влево на 90
            for (int j = 0; j < SIZE; j++) {
                fieldRotate[i][j] = field[j][SIZE - 1 - i];
            }
        }

        for (int i = 0; i < SIZE; i++) {//если в "/" диагонали фишек игрока на 1 меньше...
            for (int j = 0; j < SIZE; j++) {

                int counter = 0;
                int counterOfEmpty = 0;
                for (int k = 0; k < SIZE - Math.max(i, j) && DOTS_DO_WIN - counter > 1; k++) {
                    if (fieldRotate[i + k][j + k] == DOT_X) counter++;
                    if (fieldRotate[i + k][j + k] == DOT_EMPTY) counterOfEmpty++;
                }

                if (DOTS_DO_WIN - counter < 2) {
                    for (int k = 1; k < SIZE - Math.max(i, j); k++) {
                        if (fieldRotate[i][j] == DOT_X && fieldRotate[i + k][j + k] == DOT_EMPTY) {
                            field[j + k][SIZE - 1 - i - k] = DOT_O;
                            return true;
                        }
                    }
                }
                if (DOTS_DO_WIN - counter < 2 && counterOfEmpty < 1) {
                    for (int k = 1; k <= Math.min(i, j); k++) {
                        if (fieldRotate[i][j] == DOT_X && fieldRotate[i - k][j - k] == DOT_EMPTY) {
                            field[j - k][SIZE - 1 - i + k] = DOT_O;
                            return true;
                        }
                    }
                }
            }
        }


        return false;
    }
}