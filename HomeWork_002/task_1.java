package HomeWork_002;

import java.util.Scanner;

public class task_1 {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int a;
        int b;
        double otvet;
        System.out.println("введите число a:");
        a = view();
        System.out.println("введите число b:");
        b = view();
        otvet = math(a, b);
        System.out.printf(String.format("a = %d\nb = %d\notvet = %f", a, b, otvet));
    }

    static int view() {
        int intValue;
        String value;
        value = input.next();
        try {
            intValue = Integer.parseInt(value);
            return intValue;
        } catch (Exception e) {
            System.out.println("не корректные данные!\n повторите ввод:");
            return intValue = view();
        }

    }

    static double math(int a, int b) {
        int check = 1;
        double res = 0;
        while (b > 1) {
            if (b>2) {
                if (b > 2 & b % 2 == 0) {
                    a = a * a;
                    b /= 2;
                    System.out.print("%==0 " + "ch = " + check + " a = " + a + " b = " + b + "\n");
                }
                if (b > 2 & b % 2 == 1) {
                    check *= a;
                    b -= 1;
                    System.out.print("%==1 " + "ch = " + check + " a = " + a + " b = " + b + "\n");
                    // System.out.println(" ");
                }
            } else {
                System.out.print("не вошли в иф " + "ch = " + check + " a = " + a + " b = " + b + "\n");
                res = a * a * check;
                b = b - 1;
                System.out.println(" res= " + res + "\n");
            }

        }
        return res;
    }

    // static int
}
