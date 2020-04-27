import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String name, group;
    private char gender;
    private int birthDay, birthMonth, birthYear;

    public Student(String name, String group, char gender, int birthYear, int birthMonth, int birthDay)  {
        this.name = name;
        this.group = group;
        this.gender = gender;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public char getGender() {
        return gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }



    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Group: " + group + "\n"
                + "gender: " + gender + "\n"
                + "Birthday: " + birthDay + "." + birthMonth + "." + birthYear + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getGender() == student.getGender() &&
                getBirthDay() == student.getBirthDay() &&
                getBirthMonth() == student.getBirthMonth() &&
                getBirthYear() == student.getBirthYear() &&
                getName().equals(student.getName()) &&
                getGroup().equals(student.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGroup(), getGender(), getBirthDay(), getBirthMonth(), getBirthYear());
    }
}