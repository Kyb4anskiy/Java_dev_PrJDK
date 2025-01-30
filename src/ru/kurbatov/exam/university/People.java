package ru.kurbatov.exam.university;

public class People implements UniversityCheckable{

    protected final String name;

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean checkUser() {
        return false;
    }
}
