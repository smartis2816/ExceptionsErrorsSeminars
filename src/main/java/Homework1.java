import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {
        int[] arr1 = {1, 7, 1, 6, 3};
        int[] arr2 = {8, 5, 0, 5, 7};
        System.out.println();
        try {
            System.out.println("Результат сложения массивов: " + Arrays.toString(subtractArrays(arr1, arr2)));
        } catch (RuntimeException e) {
            switch (Integer.parseInt(e.getMessage())) {
                case -1 -> System.out.println("Один из массивов имеет значение null");
                case -2 -> System.out.println("Длина первого массива больше, чем второго");
                case -3 -> System.out.println("Длина второго массива больше, чем первого");
            }
        }
        System.out.println();
        try {
            System.out.println("Результат деления массива №1 на массив №2: " + Arrays.toString(divideArrays(arr1, arr2)));
        } catch (RuntimeException e) {
            switch (Integer.parseInt(e.getMessage())) {
                case -1 -> System.out.println("Один из массивов имеет значение null");
                case -2 -> System.out.println("Длина первого массива больше, чем второго");
                case -3 -> System.out.println("Длина второго массива больше, чем первого");
                case -4 -> System.out.println("В массиве №2 присутствует 0, на который делить нельзя");
            }
        }
    }

    public static void checkExceptions(int[] arr1, int[] arr2) throws RuntimeException {
        if (arr1 == null || arr2 == null)
            throw new RuntimeException("-1");
        if (arr1.length > arr2.length)
            throw new RuntimeException("-2");
        if (arr2.length > arr1.length)
            throw new RuntimeException("-3");
    }

    public static void checkValueForZero(int[] arr2) throws RuntimeException {
        for (int j : arr2) {
            if (j == 0)
                throw new RuntimeException("-4");
        }
    }

    public static int[] subtractArrays(int[] arr1, int[] arr2) {
        checkExceptions(arr1, arr2);
        int[] result = new int[arr1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    public static float[] divideArrays(int[] arr1, int[] arr2) {
        checkExceptions(arr1, arr2);
        checkValueForZero(arr2);
        float[] result = new float[arr1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (float) arr1[i] / arr2[i];
        }
        return result;
    }
}
