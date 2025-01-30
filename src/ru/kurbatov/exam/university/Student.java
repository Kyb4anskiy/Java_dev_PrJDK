package ru.kurbatov.exam.university;

public class Student extends People{

    private final Integer number;

    public Student(String name, Integer number) {
        super(name);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean checkUser() {
        if (name != null && number != null)
            return true;
        return false;
    }
}
