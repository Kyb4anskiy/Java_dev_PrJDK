package ru.kurbatov.oop.any.creatures.humans;

public class Human {

    private final Name fullName;
    private int height;
    private final Human father;

    public Human(String name, int height){
        this(new Name(name), height, null);
    }

    public Human(String name, int height, Human father){
        this(new Name(name), height, father);
    }

    public Human(Name fullName, int height){
        this(fullName, height, null);
    }

    public Human(Name fullName, int height, Human father){
        if (father != null) {
            this.fullName = fatherName(fullName, father);
        }else{
            this.fullName = fullName;
        }
        this.father = father;
        setHeight(height);
    }

    public Human(Human copyHuman){
        this.fullName = copyHuman.fullName;
        this.height = copyHuman.height;
        this.father = copyHuman.father;
    }

    private Name fatherName(Name firstName, Human father){  //REWORK
        String surname = firstName.getSurname();
        String patronymic = firstName.getPatronymic();
        Name fatherName = father.fullName;
        if (surname == null && fatherName.getSurname() != null){
            surname = fatherName.getSurname();
        }
        if (patronymic == null && fatherName.getName() != null){
            String endPatronymic = "ович";
            patronymic = fatherName.getName() + endPatronymic;
        }
        return new Name(firstName.getName(), surname, patronymic);
    }

    public int getHeight() { return height; }

    public void setHeight(int height) {
        if (0 >= height || height > 500) throw new IllegalArgumentException("Incorrect value of height");
        this.height = height;
    }

    public Name getFullName(){ return fullName; }

    public Human getFather() {
        if (father == null) return null;
        return new Human(father);
    }

    public String toString() {
        return fullName + ", " + height;
    }
}
