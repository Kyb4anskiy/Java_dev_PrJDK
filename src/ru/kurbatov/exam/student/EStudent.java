package ru.kurbatov.exam.student;

import java.util.*;

public class EStudent implements Iterable<Integer>{

    private List<Integer> marks;
    private String name;
    private final ERule rule;
    private Deque<Runnable> historyUpdate = new ArrayDeque<>();

    public EStudent(String name, ERule rule ,List<Integer> marks) {
        this.name = name;
        this.rule = rule;
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public void setMarks(List<Integer> marks) {
        this.marks = new ArrayList<>();
        addMarks(marks);
    }


    public void addMarks(List<Integer> newMarks){
        for(Integer mark: newMarks)
            checkRule(mark);
        this.marks.addAll(newMarks);
        historyUpdate.push(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < newMarks.size(); i++)
                    EStudent.this.marks.remove(EStudent.this.marks.size()-1);
            }
        });
    }

    public void addMark(Integer mark){
        checkRule(mark);
        this.marks.add(mark);
        historyUpdate.push(new Runnable() {
            @Override
            public void run() {
                EStudent.this.marks.remove(EStudent.this.marks.size() - 1);
            }
        });
    }

    private void checkRule(Integer mark){
        if (!rule.checkRule(mark))
            throw new IllegalArgumentException("Incorrect mark");
    }

    public void undo(){
        if (historyUpdate.isEmpty())
            System.out.println("Исходное состояние");
        else historyUpdate.pop().run();
    }

    @Override
    public String toString(){
        return name + " " + marks;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StudentIterator(this);
    }


}
