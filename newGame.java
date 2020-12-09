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
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (winCheck(i, j, 0, 1, dot)) return true;
                if (winCheck(i, j, 1, 0, dot)) return true;
                if (winCheck(i, j, 1, 1, dot)) return true;
                if (winCheck(i, j, 1, -1, dot)) return true;
            }
        }
        return false;
    }

    public static boolean aiCanBeatYou() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (lineFill(i, j, 0, 1)) return true;//проверяем линию вправо
                if (lineFill(i, j, 0, -1)) return true;//проверяем линию влево
                if (lineFill(i, j, 1, 0)) return true;//столбец вправо
                if (lineFill(i, j, -1, 0)) return true;//столбец влево
                if (lineFill(i, j, 1, 1)) return true;//диагональ \ вниз
                if (lineFill(i, j, -1, -1)) return true;//диагональ \ вверх
                if (lineFill(i, j, 1, -1)) return true;//диагональ / вниз
                if (lineFill(i, j, -1, 1)) return true;//диагональ / вверх
            }
        }
        return false;
    }

    public static boolean lineFill(int i, int j, int vectorCol, int vectorRow) {
        if (lineCheck(i, j, vectorCol, vectorRow)) {
            for (int k = 1; k < SIZE; k++) {
                int iNext = i + k * vectorCol;
                int jNext = j + k * vectorRow;
                if (iNext > SIZE - 1 || iNext < 0 || jNext > SIZE - 1 || jNext < 0) return false;
                if (field[i][j] == DOT_X && field[iNext][jNext] == DOT_EMPTY) {
                    field[iNext][jNext] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean lineCheck(int i, int j, int vectorCol, int vectorRow) {
        if (field[i][j] == DOT_X) {
            int counter = 1;
            for (int k = 1; k < SIZE; k++) {
                int iNext = i + k * vectorCol;
                int jNext = j + k * vectorRow;
                if (iNext > SIZE - 1 || iNext < 0 || jNext > SIZE - 1 || jNext < 0) return false;
                if (field[iNext][jNext] == DOT_X) counter++;
                if (DOTS_DO_WIN - counter <= 1) return true;
            }
        }
        return false;
    }

    public static boolean winCheck(int i, int j, int vectorCol, int vectorRow, char dot) {
        if (field[i][j] == dot) {
            int counter = 1;
            for (int k = 1; k < SIZE; k++) {
                int iNext = i + k * vectorCol;
                int jNext = j + k * vectorRow;
                if (iNext > SIZE - 1 || iNext < 0 || jNext > SIZE - 1 || jNext < 0) return false;
                if (field[i][j] == dot && field[iNext][jNext] == dot) counter++;
                else {
                    counter = 1;
                    break;
                }
                if (counter == DOTS_DO_WIN) return true;
            }
        }
        return false;
    }




}





