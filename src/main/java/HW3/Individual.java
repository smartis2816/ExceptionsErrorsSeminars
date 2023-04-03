package HW3;

import java.util.StringJoiner;

public class Individual {
    String lastName;
    String firstName;
    String patronymic;
    String birthday;
    long phoneNumber;
    char sex;

    public Individual(String lastName, String firstName, String patronymic, String birthday, long phoneNumber, char sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Individual.class.getSimpleName() + "[", "]")
                .add("lastName='" + lastName + "'")
                .add("firstName='" + firstName + "'")
                .add("patronymic='" + patronymic + "'")
                .add("birthday='" + birthday + "'")
                .add("phoneNumber=" + phoneNumber)
                .add("sex=" + sex)
                .toString();
    }

    public String joinFields() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.lastName);
        sb.append(" ");
        sb.append(this.firstName);
        sb.append(" ");
        sb.append(this.patronymic);
        sb.append(" ");
        sb.append(this.birthday);
        sb.append(" ");
        sb.append(this.phoneNumber);
        sb.append(" ");
        sb.append(this.sex);
        return sb.toString();
    }

}
