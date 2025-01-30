package ru.kurbatov.oop.tools;

import ru.kurbatov.oop.patterns.visitor.*;
import ru.kurbatov.oop.any.communication.Connection;
import ru.kurbatov.oop.any.creatures.animals.Meowable;
import ru.kurbatov.oop.any.creatures.animals.birds.Bird;
import ru.kurbatov.oop.any.creatures.humans.Education.RuleOfMarks;
import ru.kurbatov.oop.any.creatures.humans.Education.Student;
import ru.kurbatov.oop.any.geometry.Coordinate;
import ru.kurbatov.oop.any.geometry.Shiftable;
import ru.kurbatov.oop.any.geometry.figures.Figure;
import ru.kurbatov.oop.any.geometry.figures.LengthCalculable;
import ru.kurbatov.oop.any.geometry.figures.Polyline;
import ru.kurbatov.oop.any.geometry.figures.PolylineCalculable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Utils{


    public static double pow(double num, int p){
        if(p == 0) return 1;

        double result = 1;
        boolean b = p > 0;
        if(!b) p *= -1;

        for(int i = 0; i < p; i++){
            result *= num;
        }
        if (!b) return 1 / result;

        return result;
    }

    public static double sum(double a, double b){
        return a + b;
    }

    public static double dif(double a, double b){
        return a - b;
    }

    public static double mul(double a, double b){
        return a * b;
    }

    public static double div(double a, double b){
        if (b == 0) return 0;
        return a / b;
    }

    public static double sqrt(double a){
        if (a < 0) return -1;
        if (a == 0) return 0;

        double start = 0, end = a + 1;
        double mid = 0;
        for (int i = 0; i < 60; i++) {
            mid = (start + end) / 2;

            if (mid * mid < a) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return mid;
    }

    public static  int[] concat(int[] arr1, int... arr2){
        int[] resArr = new int[arr1.length + arr2.length];
        int i = 0;

        for (int e : arr1) resArr[i++] = e;
        for (int e : arr2) resArr[i++] = e;

        return resArr;
    }


    public static double sumOfNumbers(SumVisitable... args){
        SummatorVisitor visitor = new SummatorVisitor();
        for(SumVisitable arg: args){
            arg.setInVisitor(visitor);
        }
        return visitor.getSum();
    }

    public static void singingOfBirds(Bird... birds){
        for (Bird bird : birds) {
            bird.sing();
        }
    }

    public static double sumOfAreas(Figure... figures){
        double sum = 0;
        for(Figure figure: figures){
            sum += figure.getArea();
        }
        return sum;
    }

    public static void meowingOfCats(Meowable... cats){
        for(Meowable cat: cats){
            cat.meow();
        }
    }

    public static double sumOfLengths(LengthVisiable... args){
        LengthSummatorVisitor visitor = new LengthSummatorVisitor();
        for(LengthVisiable arg: args){
            arg.setInVisitor(visitor);
        }
        return visitor.getSum();
    }

    public static Polyline PolygonalChain(PolylineCalculable... figures){
        Polyline polyline = new Polyline();
        for(PolylineCalculable figure: figures){
            polyline.addPoints(figure.getPolyline().getPoints());
        }
        return polyline;
    }

    public static double powArgs(String X, String Y){
        return pow(parseInt(X), parseInt(Y));
    }

    public static void connectionErmakov() {
        Connection connection = new Connection("ermakov.edu");
        for (int i = 0; i < 10; i++) {
            try{
                System.out.println(connection.dataRequest());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        connection.closeConnection();
    }

    public static double divStrings(String... strings){
        List<Double> numbers = new ArrayList<>();
        double nextNum;
        double res;
        for (String str: strings){
            try{
                nextNum = Double.parseDouble(str);
            }catch (RuntimeException e){
                continue;
            }
            numbers.add(nextNum);
        }
        try{
            res = numbers.getFirst();
        } catch (RuntimeException e) {
            return 0;
        }
        for (int i = 1; i < numbers.size(); i++){
            res /= numbers.get(i);
        }
        return res;
    }

    public static void addMarks(Student... students){
        int randMark = new Random().nextInt(11);
        for(int i = 0; i <  students.length; i++) {
            try {
                students[i].addMark(randMark);
            } catch (RuntimeException e) {
                for (int j = i-1; j >=0; j--){
                    students[j].removeMark(randMark);
                }
                System.out.println(e.getMessage() + " Mark is " + randMark);
                //System.out.println(" Mark is " + randMark);
                return;
            }
        }
    }

    public static List<Student> convertToStudent(
            List<String> constructorArgs,
            List<String> addArgs
    ){
        List<Student> students = new ArrayList<>();
        List<String> listNames = new ArrayList<>();
        List<String> listRules = new ArrayList<>();
        for (int i = 0; i < constructorArgs.size(); i++){
            if (i%2 == 0) listNames.add(constructorArgs.get(i));
            else listRules.add(constructorArgs.get(i));
        }

        Student tmpStudent;
        for (int i = 0; i < listNames.size(); i++){
            final int[] rules;
            try{
                rules = convertStringToRule(listRules.get(i));
            }catch (RuntimeException e){
                System.out.println("Студента " + listNames.get(i) + " невозможно создать");
                continue;
            }
            tmpStudent = (new Student(listNames.get(i), mark -> mark >= rules[0] && mark <= rules[1]));

            if (addArgs != null){
                int newMark;
                for (String mark : addArgs) {
                    try {
                        newMark = Integer.parseInt(mark);
                        tmpStudent.addMark(newMark);
                    } catch (RuntimeException e) {
                        tmpStudent = convertToStudent(Arrays.asList(listNames.get(i), listRules.get(i)), null).get(0);
                        break;
                    }
                }
            }
            students.add(tmpStudent);
        }
        return students;
    }

    private static int[] convertStringToRule(String string){
        String[] stringRules =  string.split("-");
        if (stringRules.length != 2) throw new IllegalArgumentException("Incorrect string for rules");
        int[] rules = new int[2];
        try{
            rules[0] = Integer.parseInt(stringRules[0]);
            rules[1] = Integer.parseInt(stringRules[1]);
        }catch (RuntimeException e){
            throw new NumberFormatException();
        }
        return rules;
    }

    public static void shiftGeometry(List<Shiftable> figures, Coordinate coord, int shift){
        for(Shiftable figure: figures){
            figure.shift(coord, shift);
        }
    }
}

