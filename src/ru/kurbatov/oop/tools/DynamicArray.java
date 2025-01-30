package ru.kurbatov.oop.tools;

import java.util.Arrays;

public class DynamicArray {     // REWORK

    private int[] storage;
    private int currentIndex;

    public DynamicArray(){
        storage = new int[1];
        currentIndex = 0;
    }

    public DynamicArray(int initialSize){
        storage = new int[initialSize];
    }

    public DynamicArray(DynamicArray tempArr){
        storage = new int[tempArr.storage.length];
        for(int i = 0; i < tempArr.currentIndex; i++)
            storage[i] = tempArr.storage[i];
        currentIndex = tempArr.currentIndex;
    }

    private void expand(){
        int[] newStorage = new int[currentIndex*2];
        currentIndex = 0;
        for (int num: storage){
            newStorage[currentIndex++] = num;
        }
        storage = newStorage;
    }

    public void add(int a){
        if(currentIndex == storage.length){
            expand();
        }
        storage[currentIndex++] = a;
    }

    public int getNum(int index){
        checkIndex(index);
        return storage[index];
    }

    private void checkIndex(int index){
        if (index <0 || index > currentIndex) throw new ArrayIndexOutOfBoundsException();
    }

    public int getSize(){
        return currentIndex;
    }

    public int remove (int index){
        checkIndex(index);
        for (int i = index; i < currentIndex-1; i++){
            storage[i] = storage[i+1];
        }
        currentIndex--;
        return storage[index];
    }

    public void insert(int index, int num){
        checkIndex(index);
        if (currentIndex == storage.length) expand();

        for (int i = currentIndex; i > index; i--){
            storage[i] = storage[i-1];
        }
        storage[index] = num;
        currentIndex++;
    }

    public void Replace(int index, int num){
        checkIndex(index);
        storage[index] = num;
    }

    public String toString(){ return Arrays.toString(storage) + " " + currentIndex; }

}
