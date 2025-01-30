package ru.kurbatov.oop.any.creatures.humans.Department;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    Employee chief;
    private List<Employee> staff = new ArrayList<>();

    public Department(String name){
        this(name, null);
    }

    public Department(String name, Employee chief){
        this.name = name;
        setChief(chief);
        staff = new ArrayList<>();
    }

    public String getName(){ return name; }

    public Employee getChief() { return chief; }

    public void setChief(Employee chief) {
        if (chief == null)
            return;
        this.chief = chief;
        chief.setDepartment(this);
    }

    public void setStaff(ArrayList<Employee> staff){
        this.staff = new ArrayList<>();
        addStaff(staff);
    }
    public List<Employee> getStaff(){
        return staff;
    }

    public void addEmployee(Employee newEmployee){
        if (staff.contains(newEmployee)) return;
        if (newEmployee.department != null) {
            if (newEmployee == newEmployee.department.chief)
                newEmployee.department.chief = null;
            newEmployee.department.removeEmployee(newEmployee);
        }
        staff.add(newEmployee);
        newEmployee.setDepartment(this);
    }

    public void addStaff(ArrayList<Employee> newStaff){
        if (newStaff == null) return;
        for (int i = 0; i < newStaff.size(); i++){
            Employee newEmployee = newStaff.get(i);
            addEmployee(newEmployee);
        }
    }

    public void removeEmployee(Employee delEmployee){
        if (staff.contains(delEmployee)){
            if (this.chief == delEmployee)
                setChief(null);
            staff.remove(delEmployee);
            delEmployee.setDepartment(null);
        }
    }

    public String toString(){
        return chief + " " + staff;
    }

    public String toStringStaff(){
        return staff.toString();
    }
}
