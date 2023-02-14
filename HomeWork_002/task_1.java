package HomeWork_002;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

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
        otvet = mathAll(a, b);
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

    static double mathPOV(int a, int b) {
        int check = 1;
        double res = 0;
        if (b < 0)
            b *= (-1);
        while (b > 1) {
            if (b > 2) {
                if (b > 2 & b % 2 == 0) {
                    a = a * a;
                    b /= 2;
                }
                if (b > 2 & b % 2 == 1) {
                    check *= a;
                    b -= 1;
                }
            } else {
                res = a * a * check;
                b = b - 1;
            }
        }
        return res;
    }

    static double mathAll(int a, int b) {
        double result = 1;
        if (b > 1) {
            result = mathPOV(a, b);
            return result;
        }
        if (b == 1) {
            return a;
        }
        if (b == -1) {
            result = result / a;
            return result;
        }
        if (b < -1) {
            result = 1 / mathPOV(a, b);
            return result;
        } else
            return 1;
    }
}
