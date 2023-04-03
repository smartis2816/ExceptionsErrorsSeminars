package HW3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        createIndividual();
    }

    public static void createIndividual() {
        ArrayList<String> newInd = inputInfo();
        checkInfo(newInd);
        Individual ind = new Individual(newInd.get(0), newInd.get(1), newInd.get(2), newInd.get(3), Long.parseLong(newInd.get(4)), newInd.get(5).charAt(0));
        String info = ind.joinFields() + "\n";
        addIndividual(ind.lastName, info);
    }

    public static ArrayList<String> inputInfo() {
        System.out.println("Input the data separated by a space.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Format: LastName FirstName Patronymic Birthday PhoneNumber Sex");
        String info = sc.nextLine();
        return new ArrayList<String>(List.of(info.split(" ")));
    }

    public static void checkInfo(ArrayList<String> info) {
        try {
            if (info.size() > 6)
                throw new Exception("You have entered more information than is required. Try again.");
            if (info.size() < 6)
                throw new Exception("You have entered less information than is required. Try again.");

            String inputLastName = info.get(0);
            String inputFirstName = info.get(1);
            String inputPatronymic = info.get(2);
            String inputBirthday = info.get(3);
            String inputPhoneNumber = info.get(4);
            char inputSex = info.get(5).charAt(0);

            if (inputBirthday.length() != 10) {
                throw new Exception("The date of birth is incorrect. Try typing again in the format dd.mm.yyyy.");
            }

            if (inputPhoneNumber.length() != 11) {
                throw new Exception("The phone number is incorrect. There must be 11 integers. Try again.");
            }
            long phoneNumber = Long.parseLong(inputPhoneNumber);

            if ((inputSex != 'f') && (inputSex != 'm') && (inputSex != 'F') && (inputSex != 'M')) {
                throw new Exception("The sex is incorrect. Try this again by typing 'm' or 'f'.");
            }

            Individual newInd = new Individual(inputLastName, inputFirstName, inputPatronymic, inputBirthday, phoneNumber, inputSex);
            String indInfo = newInd.joinFields();
            System.out.println(indInfo);

        } catch (NumberFormatException e) {
            System.out.println("The phone number is incorrect. There must be 11 integers. Try again.");
            inputInfo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputInfo();
        }
    }

    public static void addIndividual(String fileName, String userData) {
        try {
            Files.write(Paths.get(fileName), (userData + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (NoSuchFileException e) {
            createNewIndFile(fileName, userData);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewIndFile(String lastName, String info) {
        String fileName = lastName + ".txt";
        try {
            Files.write(Paths.get(fileName), info.getBytes());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
