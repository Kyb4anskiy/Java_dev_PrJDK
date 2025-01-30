package ru.kurbatov.oop.any.creatures.humans.Education;

import ru.kurbatov.oop.generics.GenericsComparable;

import java.util.*;

public class Student implements GenericsComparable<Student> {

    private String name;
    private List<Integer> marks;
    private RuleOfMarks rule;
    private final HistoryOfStudent saves;

    public Student(String name, RuleOfMarks rule, List<Integer> marks){
        this.name = name;
        setRule(rule);
        setMarks(marks);
        saves = new HistoryOfStudent();
        saves.pushInHistory(name, this.marks);
    }

    public Student(String name, RuleOfMarks rule, Integer... marks){
        this(name, rule, List.of(marks));
    }

    private Student(Student copyStudent){
        this(copyStudent.name, copyStudent.rule, copyStudent.marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
        saves.pushInHistory(name, marks);
    }

    public List<Integer> getMarks(){
        return new ArrayList<Integer>(marks);
    }

    private void setMarks(List<Integer> marks){
        this.marks = new ArrayList<>();
        this.addMarks(marks);
    }

    private void setRule(RuleOfMarks rule) {
        if (rule == null) throw new NullPointerException("Rule is null");
        this.rule = rule;
    }

    private void addMarks(List<Integer> marks){
        for (int mark: marks){
            addMark(mark);
        }
    }

    public void addMark(int mark){
        if (rule.checkMark(mark)) {
            marks.add(mark);
        }else throw new InvalidMarkException(name + " Incorrect value of mark");
        if (saves != null)
            saves.pushInHistory(name, marks);
    }

    public void removeMark(int mark){
        if (marks.contains(mark)) {
            marks.remove(Integer.valueOf(mark));
        }else throw new InvalidMarkException("Mark not founded");
        saves.pushInHistory(name, marks);
    }

    public double getAverageMark(){
        if (marks == null || marks.isEmpty()) return 0;
        double sum = 0;
        for(int mark: marks){
            sum += mark;
        }
        return sum/marks.size();
    }

    public boolean isExcellentStudent(){
        return getAverageMark() == 5;
    }

    public String toString() {
        return name + ": " + marks;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Student s = (Student) obj;
        return Objects.equals(name, s.name) && getAverageMark() == s.getAverageMark();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getAverageMark());
    }

    @Override
    public int compareTo(Student obj) {
        if (this.getAverageMark() == obj.getAverageMark()) return 0;
        if (this.getAverageMark() > obj.getAverageMark()) return 1;
        return -1;
    }

    public void undo(){
        HistoryOfStudent.Pair<String, List<Integer>> undoStudent = saves.undo();
        if (undoStudent != null){
            this.name = undoStudent.name;
            this.marks = new ArrayList<>(undoStudent.marks);
        }
        else System.out.println("Исходное состояние");
    }

    public void save(){
        saves.save(name, marks);
    }

    public void load(){
        HistoryOfStudent.Pair<String, List<Integer>> loadStudent = saves.load();
        this.name = loadStudent.name;
        this.marks = new ArrayList<>(loadStudent.marks);
    }

    private class HistoryOfStudent {

        private List<Pair<String, List<Integer>>> history;
        private Pair<String, List<Integer>> mainSave;

        public HistoryOfStudent() {
            history = new ArrayList<>();
        }

        public void pushInHistory(String name, List<Integer> lst){
            if (history.isEmpty())
                mainSave = new Pair<>(name, new ArrayList<>(lst));
            history.add(new Pair<>(name, new ArrayList<>(lst)));
        }

        public Pair<String, List<Integer>> undo(){
            if (history.size() <= 1) return null;
            Pair<String, List<Integer>> tmp = history.get(history.size() - 2);
            history.removeLast();
            return tmp;
        }

        public void save(String name, List<Integer> lst){
            history = new ArrayList<>();
            pushInHistory(name, lst);
        }

        public Pair<String, List<Integer>> load(){
            history = new ArrayList<>();
            return mainSave;
        }

        private class Pair<T, E>{
            private T name;
            private E marks;

            public Pair(T name, E marks) {
                this.name = name;
                this.marks = marks;
            }

//            @Override
//            public String toString() {
//                return name + " " + marks;
//            }
        }

    }

}
