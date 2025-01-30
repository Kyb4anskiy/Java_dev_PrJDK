package ru.kurbatov.oop.generics;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private List<T> stack = new ArrayList<>();

    public void push(T el){
        stack.addLast(el);
    }

    public T pop(){
        if (stack.isEmpty()) throw new IndexOutOfBoundsException("Stack is empty");
        T elTemp = stack.getLast();
        stack.removeLast();
        return elTemp;
    }

    public T peek(){
        if (stack.isEmpty()) throw new IndexOutOfBoundsException("Stack is empty");
        return stack.getLast();
    }

    @Override
    public String toString() {
        return "Stack: " + stack;
    }
}
