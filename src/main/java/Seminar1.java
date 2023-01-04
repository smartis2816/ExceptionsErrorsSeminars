import java.util.Scanner;

public class Seminar1 {
    /*
    public static void main(String[] args) {
        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                int num = Integer.parseInt(scanner.nextLine());
                System.out.println("Отлично, это число");
            } catch (NumberFormatException exception){
                System.out.println(exception.getMessage());
            }
        }
    }*/

    //    Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
//    Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
//    если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
//    если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
//    если вместо массива пришел null, метод вернет -3
//    придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
//    Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод запросит
//    искомое число у пользователя, вызовет первый, обработает возвращенное значение и покажет
//    читаемый результат пользователю. Например, если вернулся -2, пользователю выведется сообщение:
//    “Искомый элемент не найден”.
    public static void main(String[] args) {
        int[] array = {2, 4, 9, 7, 1};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        try {
            System.out.println("Индекс: " + checkIndex(array, number));
        } catch (Exception e) {
            switch (Integer.parseInt(e.getMessage())) {
                case -1 -> System.out.println("Массив слишком мал");
                case -2 -> System.out.println("Такого элемента нет");
                case -3 -> System.out.println("Пустой массив");
            }
        }
    }

    public static int checkIndex(int[] array, int number) throws Exception {
        int index = 0;
        if (array.length < 5)
            throw new Exception("-1");
        boolean flag = false;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == number) {
                flag = true;
                index = j;
                break;
            }
        }
        if (!flag)
            throw new Exception("-2");
        if (array.length == 0)
            throw new Exception("-3");
        return index;
    }

}

