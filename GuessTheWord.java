package GeekBrainHW3;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    public static void main(String[] args) {
        String[] arrOfWords = begin(); //Объявляем и выводим массив из задания
        char[] programmWord = randomizer(arrOfWords); //выбираем случайное слово, переводим в массив из символов и возвращаем
        char[] gamerWord = gamerWordInput(); // пользователь вводит слово, оно переводится в массив из символов и возвращается
        boolean b = compareWords(programmWord, gamerWord); // этот метод переводит символьые массивы в строки и сравнивает их, возвращает результат
        char[] compare = compare(programmWord, gamerWord); // этот метод выдает подсказку в случае, если мы не угадали, возвращает символьный массив

        if (b) { //если угадал, то угадал
            System.out.println("Вы угадали!");
        } else {
            while (!b) {//если не угадал, то подсказка выводится и переопределяются пользовательский массив, снова все сравнивается
                for (int i = 0; i < compare.length; i++) {
                    System.out.print(compare[i]);
                }
                System.out.println();
                gamerWord = gamerWordInput();
                compare = compare(programmWord, gamerWord);
                b = compareWords(programmWord, gamerWord);
            }
            System.out.println("Вы угадали!");
        }
    }

    public static String[] begin() {
        String[] arrOfWords = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Угадайте слово");
        System.out.print("Вот варианты: ");
        for (int i = 0; i < arrOfWords.length; i++) {
            if (i < (arrOfWords.length - 1)) {
                System.out.print(arrOfWords[i] + ", ");
            } else {
                System.out.print(arrOfWords[i] + ".");
            }
        }
        return arrOfWords;
    }

    public static char[] randomizer(String[] arrOfWords) {
        Random someWord = new Random();
        String word = arrOfWords[someWord.nextInt(arrOfWords.length)];
        char[] programmWord = new char[word.length()];
//        System.out.println();
//        System.out.print("Машина загадала в символах /");
        for (int i = 0; i < programmWord.length; i++) {
            programmWord[i] = word.charAt(i);
//            System.out.print(programmWord[i] + " ");
        }
        System.out.println();
        return programmWord;
    }

    public static char[] gamerWordInput() {
        System.out.print("Ваше слово: ");
        Scanner sc = new Scanner(System.in);
        String gamerWord = sc.nextLine();
        char[] gamerWordArr = new char[gamerWord.length()];
        for (int i = 0; i < gamerWordArr.length; i++) {
            gamerWordArr[i] = gamerWord.charAt(i);
        }
        return gamerWordArr;
    }

    public static char[] compare(char[] programmWord, char[] gamerWord) {
        char[] result = new char[15];
        for (int i = 0; i < result.length; i++) {
            result[i] = 'Х';
        }

        for (int i = 0; (i < programmWord.length) && (i < gamerWord.length); i++) {
            if (programmWord[i] == gamerWord[i]) {
                result[i] = gamerWord[i];
            }
        }
        return result;
    }

    public static boolean compareWords(char[] programmWord, char[] gamerWord) {
        String a = new String(programmWord);
        String b = new String(gamerWord);
        if (a.equals(b)) {
            return true;
        } else {
            return false;
        }

    }

}



