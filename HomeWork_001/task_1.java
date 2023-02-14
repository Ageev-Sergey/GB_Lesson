package HomeWork_001;

import java.util.Scanner;
import java.util.Random;

public class task_1 {

    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int otvet;
        int n = isNumber(view());
        otvet = ((n+1)*n)/2;
        System.out.printf(String.format("для T = %d\n", n));
        print(otvet);
    }

    static String view() {
        String value;
        System.out.println("\nвыбор ввода порядка триугольного число:\n" +
                "для ввода случайного числа введите 'r'\n" +
                "или введите натурально число с клавиатуры");
        value = input.next();
        return value;
    }

    static int isNumber(String value) {
        int intValue = 0;
        String r = "r";
        boolean flag = value.equalsIgnoreCase(r);
        if (flag) {
            System.out.println("вошли");
            intValue = random.nextInt(3, 8);
        }

        else {
            try {
                intValue = Integer.parseInt(value);
                return intValue;
            } catch (NumberFormatException e) {
                System.out.println("не верное значение!");
                isNumber(view());
            }
        }

        return intValue;
    }

    static void print(int value) {
        System.out.printf(String.format("треугольное число равное %d", value));
    }
}
