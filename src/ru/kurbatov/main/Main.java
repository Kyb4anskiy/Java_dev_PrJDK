package ru.kurbatov.main;

import ru.kurbatov.exam.converter.Converter;
import ru.kurbatov.exam.delivery.Order;
import ru.kurbatov.exam.document.DepartmentAccounting;
import ru.kurbatov.exam.document.DepartmentHR;
import ru.kurbatov.exam.document.DepartmentSecurity;
import ru.kurbatov.exam.document.Document;
import ru.kurbatov.exam.macros.Action;
import ru.kurbatov.exam.macros.Macros;
import ru.kurbatov.exam.student.EStudent;
import ru.kurbatov.exam.trafficLight.Green;
import ru.kurbatov.exam.trafficLight.*;
import ru.kurbatov.exam.university.Teacher;
import ru.kurbatov.exam.university.Watchman;
import ru.kurbatov.main.tmp.MusicKit;
import ru.kurbatov.oop.any.creatures.humans.Education.Student;
import ru.kurbatov.oop.patterns.karatist.*;
import ru.kurbatov.oop.patterns.observer.Bot;
import ru.kurbatov.oop.patterns.observer.Printer;
import ru.kurbatov.oop.patterns.observer.StockORCL;
import ru.kurbatov.oop.patterns.observer.StockTSLA;
import ru.kurbatov.oop.patterns.stream.StreamKub;

import java.lang.annotation.Documented;
import java.util.*;
import java.util.stream.Stream;


class Main {

    public static void main(String... args) throws CloneNotSupportedException {

        //karatist();
        //students();
        //stock();
        //func();
        //filter();
        //reduce();
        //collect();

        //streamFull();

        //examStudent();
        //examOrder();
        //examMacros();

        //MusicKit.startMusicKit();

        //trafficLight();

        //document();

        //docConvertor();

        //watchman();

        //basedate();

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("A", 2);
        System.out.println(map);
    }

    private static void basedate(){

    }

    private static void watchman(){
        Watchman watchman = new Watchman();
        ru.kurbatov.exam.university.Student student1 = new ru.kurbatov.exam.university.Student("A", null);
        ru.kurbatov.exam.university.Student student2 = new ru.kurbatov.exam.university.Student("B",  123);
        Teacher teacher1 = new Teacher("AA", null, "DDD");
        Teacher teacher2 = new Teacher("AA", 123, null);
        System.out.println(watchman.checkUser(student1));
        System.out.println(watchman.checkUser(student2));
        System.out.println(watchman.checkUser(teacher1));
        System.out.println(watchman.checkUser(teacher2));

    }

    private static void docConvertor(){
        Converter converter = new Converter(
                x -> x + " some data",
                x -> x + " new data",
                x -> x + " new name"
        );
        System.out.println(converter.convert("AA"));
    }

    private static void document(){

        Document d1 = new Document("AA", "Qwerty");
        Document d2 = new Document("A", "qwerty");

        DepartmentSecurity ds = new DepartmentSecurity(List.of("A","B"));
        DepartmentHR dhr = new DepartmentHR(true);
        DepartmentAccounting da = new DepartmentAccounting();

        ds.setNextDocumentCheckable(dhr);
        dhr.setNextDocumentCheckable(da);

        d1.checkDocument(ds);
        d2.checkDocument(ds);

        System.out.println(d1.getSignatures());
        System.out.println(d2.getSignatures());


    }

    private static void trafficLight(){
        TrafficLight tf = new TrafficLight(new Red());
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        TrafficLight tf2 = new TrafficLight(new NightYellow());
        tf2.next();
        tf2.next();
        tf2.next();
    }

    private static void examMacros(){

        List<Integer> list1 = List.of(1,-2,3,-4,5,6,-7,8,9,-10);
        List<Integer> list2 = List.of(1,2,3);
        Macros<Integer> macros1 = Macros.create("A", list1);
        macros1.addAction(x->x.stream().map(y->y*2).toList());
        System.out.println(macros1.run());

        Macros<Integer> macros2 = Macros.create("B", list2);
        macros2.addAction(macros1);
        macros2.addAction(x->x.stream().map(y->y*100).toList());
        System.out.println(macros2.run());

        Macros<Integer> macros3 = Macros.find("B");
        System.out.println(macros3.run());


    }

    private static void examStudent(){
        EStudent student = new EStudent("A", x->true, List.of(1,2,3,4,5,6,7));
//        for(Integer mark: student){
//            System.out.println(mark);
//        }
        student.addMark(3);
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.addMarks(List.of(1,1,1,1));
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.undo();
    }

    private static void examOrder(){
        Order order = new Order("A");
        System.out.println(order.getStatus());

        order.changeStatus();
        System.out.println(order.getStatus());

        order.changeStatus("AAA");
        System.out.println(order.getStatus());
        order.changeStatus("BBB");
        System.out.println(order.getStatus());

        order.changeStatus();
        System.out.println(order.getStatus());

        order.changeStatus();
    }


    private static void streamFull() {
        List<Integer> list1 = List.of(1,2,-3,4,6,7,0,8,-9,0,1,1,1,-2,100);
        Integer sumND = new StreamKub<>(list1)
                .function(x -> x*2)
                .filter(x -> x>=0 && x<=10)
                .filter(x->x!=0)
                .reduce(Integer::sum);
        System.out.println(sumND);

        List<String> list2 = List.of("0", "123", "Eqqq", "ad", "AAA");
        Integer size = new StreamKub<>(list2)
                .filter(x->Character
                        .isUpperCase(x.charAt(0))).
                function(x->1)
                .reduce(Integer::sum);//.count();
        System.out.println(size);

        List<String> list3 = List.of("0", "123", "99", "01", "333");
        Integer sum = new StreamKub<>(list3).function(x ->{
            Integer tmp = 0;
            for(int i=0 ;i < x.length(); i++){
                tmp += Character.getNumericValue(x.charAt(i));
            }
            return tmp;
        }).reduce(Integer::sum);
        System.out.println(sum);

    }


//    public static void func(){
//        List<?> res;
//        List<String> lst1 = List.of("000006", "00005", "02");
//        List<Integer> lst2 = List.of(1,-3,7);
//        List<Integer[]> lst3 = List.of(new Integer[]{1, 2, 3}, new Integer[]{2,2,2}, new Integer[]{10,9,9});
//
//        res = StreamKub.function(lst1, String::length);
//        System.out.println(res);
//        res = StreamKub.function(lst2, x -> x<0 ? x*=-1 : x);
//        System.out.println(res);
//        res = StreamKub.function(lst3, x -> {
//            Integer tmp = Integer.MIN_VALUE;
//            for (Integer val : x) {
//                tmp = Integer.max(tmp, val);
//            }
//            return tmp;
//        });
//        System.out.println(res);
//    }
//
//    public static void filter() {
//        List<?> res;
//        List<String> lst1 = List.of("000006", "00005", "02");
//        List<Integer> lst2 = List.of(1, -3, 7);
//        List<List<Integer>> lst3 = List.of(List.of(1, 2, -3), List.of(-2, -2, -2), List.of(10, 9, 9));
//
//        res = StreamKub.filter(lst1, x -> x.length()>=3);
//        System.out.println(res);
//        res = StreamKub.filter(lst2, x -> x>0);
//        System.out.println(res);
//        System.out.println(lst3);
//        res = StreamKub.filter(lst3, x -> {
//            for (Integer val : x)
//                if (val >= 0) return false;
//            return true;
//        });
//        System.out.println(res);
//    }
//
//    public static void reduce(){
//        List<String> lst1 = List.of("000006", "00005", "02");
//        List<Integer> lst2 = List.of(1, -3, 7);
//        List<List<Integer>> lst3 = List.of(List.of(1, 2, 3), List.of(2, 2, 2), List.of(10, 9, 9));
//
//        String res1 = StreamKub.reduce(lst1, (x, y) -> x+y);
//        System.out.println(res1);
//        Integer res2 = StreamKub.reduce(lst2, Integer::sum);
//        System.out.println(res2);
//        Integer res3 = StreamKub.reduce(StreamKub.function(lst3, List::size), Integer::sum);
//        System.out.println(res3);
//    }
//
//    public static void collect(){
//        List<String> lst1 = List.of("qwerty", "asdfg", "zx", "qw" );
//        List<Integer> lst2 = List.of(1, -3, 7, 0);
//        List<List<Integer>> lst3 = List.of(List.of(1, 2, 3), List.of(2, -10, 2), List.of(10, 9, 9));
//
//        List<List<Integer>> res1 = StreamKub.collect(lst2,
//                ()->{
//                    List<List<Integer>> newList = new ArrayList<>();
//                    newList.add(new ArrayList<>());
//                    newList.add(new ArrayList<>());
//                    newList.add(new ArrayList<>());
//                    return newList;
//                },
//                (lst, val) -> {
//                    if (val > 0) {
//                        lst.get(0).add(val);
//                    } else if (val < 0){
//                        lst.get(1).add(val);
//                    } else
//                        lst.get(2).add(val);
//                });
//        System.out.println(res1);
//
//
//        List<List<String>> res2 = StreamKub.collect(lst1,
//                ArrayList::new,
//                (lst, val) -> {
//                    if (lst.isEmpty())
//                        lst.add(new ArrayList<>());
//                    for (List<String> tmp: lst) {
//                        if (tmp.isEmpty()){
//                            tmp.add(val);
//                            return;
//                        }
//                        else if (val.length() == tmp.getFirst().length()) {
//                            tmp.add(val);
//                            return;
//                        }
//                    }
//                    lst.add(new ArrayList<>());
//                    lst.getLast().add(val);
//                });
//        System.out.println(res2);
//
//        Deque<Integer> res3 = StreamKub.collect(lst3, ArrayDeque::new,
//                (deq, val)->{
//                    Integer min = Integer.MAX_VALUE;
//                    for(Integer tmp: val){
//                        if (tmp<min) {
//                            min = tmp;
//                        }
//                    }
//                    deq.push(min);
//                });
//        System.out.println(res3);
//    }





    public static void students(){
        List<Integer> lst = List.of(1,2,3,4,5);
        Student a = new Student("A", x->true, lst);
        System.out.println(a);
        a.undo();
        System.out.println();

        a.addMark(1);
        a.addMark(1);
        System.out.println(a);
        a.undo();
        a.undo();
        System.out.println(a);
        a.addMark(2);
        System.out.println(a);
        a.removeMark(2);
        System.out.println(a);
        a.undo();
        System.out.println(a);

        System.out.println();
        a.addMark(10);
        a.addMark(10);
        a.addMark(10);
        System.out.println(a);
        a.load();
        System.out.println(a);
        a.undo();
        a.removeMark(5);
        a.removeMark(4);
        a.removeMark(3);
        System.out.println(a);
        a.save();
        a.removeMark(2);
        System.out.println(a);
        a.undo();
        System.out.println(a);
        a.undo();

    }

    public static void karatist(){
        Karatist karatist1 = new Karatist("A");
        Karatist karatist2 = new Karatist("B");

        HitHandWrapper hit1 = new HitHandWrapper(karatist1);
        HitJumpWrapper hit2 = new HitJumpWrapper(karatist1);
        HitLegWrapper hit3 = new HitLegWrapper(karatist2);

        Combo combo = new Combo(List.of(hit1, hit3, hit2));

        combo.hitCombo();
    }

    public static void stock(){
        Printer printer1 = new Printer("A");
        Printer printer2 = new Printer("B");
        Bot bot1 = new Bot("D");
        Bot bot2 = new Bot("E");

        StockORCL stockORCL = new StockORCL("ORCL", 70, List.of(printer1, printer2));
        StockTSLA stockTSLA = new StockTSLA("TSLA", 10, List.of(printer1, printer2, bot1, bot2));

        stockTSLA.changeCost(75);
        System.out.println();
        stockORCL.changeCost(12.2);
    }

//    public static void storage2_0(){
//        Storage<Integer> s = Storage.ofCount(123);
//        System.out.println("delay");
//        System.out.println(s.getValue(1));
//    }

}