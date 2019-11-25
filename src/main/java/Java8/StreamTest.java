package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by yzwang on 2019/8/24.
 */
public class StreamTest {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(1, 2));
        list.add(new User(11, 21));

        List<? extends Number> eList = null;
        eList = new ArrayList<Integer>();
//        Number numObject = eList.get(0);  //语句1，正确
//
////Type mismatch: cannot convert from capture#3-of ? extends Number to Integer
//        Integer intObject = eList.get(0);  //语句2，错误
//
////The method add(capture#3-of ? extends Number) in the type List<capture#3-of ? extends Number> is not applicable for the arguments (Integer)
//        eList.add(new Object());  //语句3，错误
//
//
//        List<? super Integer> sList = null;
//        sList = new ArrayList<Number>();
//
////Type mismatch: cannot convert from capture#5-of ? super Integer to Number
//        Number numObj = sList.get(0);  //语句1，错误
//
////Type mismatch: cannot convert from capture#6-of ? super Integer to Integer
//        Object intObj = sList.get(0);  //语句2，错误
//
//        sList.add(new Integer(1));  //语句3，正确
//        sList.add(new Long(1));  //语句3，正确


//        Map map = list.stream().collect(Collectors.toMap(User::getId, Function.identity()));
//        System.out.println(map);

    }

    static class User {
        int id;
        int age;

        public User(int id, int age) {
            this.id = id;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", age=" + age +
                    '}';
        }
    }
}
