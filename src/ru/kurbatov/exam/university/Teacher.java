package ru.kurbatov.exam.university;

public class Teacher extends People{

    private final Integer number;
    private final String post;

    public Teacher(String name, Integer number, String post) {
        super(name);
        this.number = number;
        this.post = post;
    }

    public Integer getNumber() {
        return number;
    }

    public String getPost() {
        return post;
    }

    @Override
    public boolean checkUser() {
        if (name != null)
            if (number != null || post != null)
                return true;
        return false;
    }
}
