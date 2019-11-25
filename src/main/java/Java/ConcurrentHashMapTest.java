package Java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collector;

/**
 * Created by yzwang on 2019/8/25.
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        List<Parent> list = new ArrayList<>();
//        list.add(new Parent(1));
        list.add(new Parent(2));
        list.add(new Sub(22, "wang"));
//        fun1(list);

        List<Parent> list1 = get();
        System.out.println(list1);
//        fun1(list1);

        List<Sub> subList = new ArrayList<>();
        list.addAll(subList);
        List<Parent> list2 = new ArrayList<>();
//        list2 = subList;
        List<SubSub> list3 = new ArrayList<>();
//        fun(list2);
        Info<SubSub> infoSubsub = new Info<>();
        Info<Sub> infoSub = new Info<>();
        Info<Parent> infoParent = new Info<>();
        fun2(infoSubsub);
        fun2(infoSub);
//        fun2(infoParent);

//        fun(infoSubsub);
        fun(infoSub);
        fun(infoParent);

    }

//    static Object reduce(List list, Function f, Object initValue) {
//        synchronized (list) {
//            Object result = initValue;
//            for (Object o : list) {
////                result = f.apply(result, o);
//            }
//            return result;
//        }
//    }

    public static void fun1(List<? extends String> list) {
        list.stream().forEach(e -> {
            System.out.println(e);


        });
    }
    public static List<Parent> get() {
        List<Parent> list = new ArrayList<>();
//        list.add(new Parent(1));
//        list.add(new Parent(2));
        list.add(new Sub(22, "wang"));
        return list;
    }

    public static void fun(Info<? super Sub> temp) {
        System.out.print(temp + "、") ;
        temp.print();

    }
    public static void fun2(Info<? extends Sub> temp) {
        temp.print();
//        temp.add(new Sub());
//        temp.add(new SubSub());
//        temp.add(new Parent());

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Parent {

    int id;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Sub extends Parent {
    int age;
    String name;

    @Override
    public String toString() {
        return "Sub{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class SubSub extends Sub {
    int ext;
}

@Data
@AllArgsConstructor
class Info<E>  {

    E value;

    public Info() {
        value = (E)new Object();
    }

    public void print() {
        System.out.println("info" + value.toString());
    }
}