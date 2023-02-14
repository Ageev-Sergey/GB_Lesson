package HomeWork_001;

import java.util.Scanner;
import java.util.Random;


public class task_1 {

    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

    }

    
    static String view (String value) {
        System.out.println("выбор ввода порядка триугольного число:\n" +
        "для ввода случайного числа введите 'r'" +
        "для ручного ввода нажмите введите число натурально число");
        value = input.nextLine();
        return value;
    }
}
