package ru.kurbatov.exam.student;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentIterator implements Iterator<Integer> {

    private final EStudent student;
    private Integer currentIndex;

    public StudentIterator(EStudent student){
        this.student = student;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < student.getMarks().size();
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return student.getMarks().get(currentIndex++);
    }
}
