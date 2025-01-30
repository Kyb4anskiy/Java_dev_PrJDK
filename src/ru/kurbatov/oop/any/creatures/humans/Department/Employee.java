package ru.kurbatov.oop.any.creatures.humans.Department;

import java.util.List;

public class Employee {

    private String name;
    Department department;

    public Employee(){
        this(null,null);
    }

    public Employee(String name){
        this(name,null);
    }

    public Employee(String name, Department department){
        this.name = name;
        setDepartment(department);
    }

    public Employee(Employee copyEmployee){
        this.name = copyEmployee.name;
        this.department = copyEmployee.department;
    }

    public String getName(){ return name; }

    public Department getDepartment(){ return department; }

    public void setDepartment(Department department) {
        if (department == null) return;
        if (this.department == department) return;
        if (this.department != null){
            if (this == this.department.chief)
                this.department.chief = null;
            this.department.removeEmployee(this);
        }
        department.addEmployee(this);
        this.department = department;
    }

    public List<Employee> getAllStaff() {
        return department.getStaff();
    }

    public String toString() {
        return name;
        //if (department == null) return name + " не работает";
        //if (this == department.getChief()) return String.format("%s начальник отдела %s", name, department.getName());
        //if (department.getChief() == null) return String.format("%s работает в отделе %s без начальника", name , department.getName());
        //return String.format("%s работает в отделе %s, начальник которого %s", name , department.getName(), department.getChief().getName());
    }
}
