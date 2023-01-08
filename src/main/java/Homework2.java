import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        float task1 = inputNumber();
        task2(new int[]{8, 7, 3, 1, 0, 10, 1, 3, 4, 6}, 0, 8);
        task3();
        getData();

    }

    public static float inputNumber() {
        float res = 0;
        System.out.println("Введите дробное число: ");
        Scanner scanner = new Scanner(System.in);
        try {
            res = scanner.nextFloat();
        } catch (InputMismatchException exception) {
            System.out.println("Введено неверное значение. Введите ещё раз.");
            inputNumber();
        }
        return res;
    }

    public static void task2(int[] intArray, int d, int index) {
        try {
            double catchedRes1 = intArray[index] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You are accessing a non-existent array element: " + index);
        } catch (ArithmeticException e) {
            System.out.println("You are trying to divide by " + e);
        }
    }

    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }

    public static void inputStr() throws RuntimeException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод с клавиатуры: ");
        String data = sc.nextLine();
        if (data.isEmpty()){
            throw new RuntimeException("Пустая строка. Повторите ввод.");
        }
    }
    public static void getData(){
        try {
            inputStr();
        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            getData();
        }
    }
}
