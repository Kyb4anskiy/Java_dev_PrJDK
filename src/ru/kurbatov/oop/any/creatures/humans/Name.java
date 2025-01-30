package ru.kurbatov.oop.any.creatures.humans;

public class Name {

    private String surname;
    private String name;
    private String patronymic;

    public Name(String name){
        this(name, null, null);
    }

    public Name(String name, String surname){
        this(name, surname, null);
    }

    public Name(String name, String surname, String patronymic){
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Argument is null");
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getName(){ return name; }
    public String getSurname(){ return surname; }

    public String getPatronymic(){ return patronymic; }

    public String toString() {      // REWORK
        String strName = surname;
        if (surname != null){
            if (name != null) strName += " " + name;
            if (patronymic != null) strName += " " + patronymic;
        }else if (name != null){
            strName = name;
            if (patronymic != null) strName += " " + patronymic;
        }else if (patronymic != null) strName = patronymic;

        return strName;
    }
}