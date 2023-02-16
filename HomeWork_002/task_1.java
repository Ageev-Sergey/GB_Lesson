package HomeWork_002;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class task_1 {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int a;
        int b;
        double otvet;
        String flag = View();
        if (flag.equalsIgnoreCase("r")) {
            int[] a_b = My_readFile();
            a = a_b[0];
            b = a_b[1];
            otvet = MathAll(a, b);
            WriterFile(otvet);
            System.out.printf(String.format("a = %d\nb = %d\notvet = %f", a, b, otvet));
        } else if (flag.equalsIgnoreCase("h")) {
            System.out.println("введите число a:");
            a = InputHand();
            System.out.println("введите число b:");
            b = InputHand();
            if (a == 0 & b == 0) {
                System.out.println("не определено");
            } else {
                otvet = MathAll(a, b);
                WriterFile(otvet);
                System.out.printf(String.format("a = %d\nb = %d\notvet = %f", a, b, otvet));
            }

        } else if (flag.equalsIgnoreCase("h")) {

        } else
            System.out.println("не корректные данные!");
    }

    static int InputHand() {
        int intValue;
        String value;
        value = input.next();
        try {
            intValue = Integer.parseInt(value);
            return intValue;
        } catch (Exception e) {
            System.out.println("не корректные данные!\n повторите ввод:");
            return intValue = InputHand();
        }
    }

    static double MathPOV(int a, int b) {
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

    static double MathAll(int a, int b) {
        double result = 1;
        if (b > 1) {
            result = MathPOV(a, b);
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
            result = 1 / MathPOV(a, b);
            return result;
        } else
            return 1;
    }

    static void WriterFile(Double a) {
        try {
            PrintWriter wr = new PrintWriter("C:/gb/Java/HomeWork_002/Output.txt");
            wr.append(Double.toString(a) + "\n");
            wr.close();
        } catch (Exception e) {
        }
    }

    static int[] My_readFile() {

        File myFile = new File("C:/gb/Java/HomeWork_002/Input.txt");
        int[] arr = new int[2];
        try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
            arr[0] = Integer.parseInt(br.readLine());
            arr[1] = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    static String View() {
        String value;
        System.out.println("\nвыбор ввода :\n" +
                "1 - для чтения из файла введите 'r'\n" +
                "или ввода a и b с клавиатуры, введите 'h");
        value = input.next();
        return value;
    }
}

// "C:/gb/Java/HomeWork_002/Input.txt"