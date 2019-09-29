package Java.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yzwang on 2019/9/22.
 */
public class Son extends Person {

    @Override
    public Son fun(int a) {
        return new Son();
    }

    // 下面这两个方法只有在特定的javac下才能编译通过。参考《深入理解java虚拟机》第二版314页
//    public static int fun1(List<Integer> list) {
//        return 0;
//    }
//
//    public static String fun1(List<String> list) {
//        return "";
//    }

    public static void main(String[] args) {
//        System.out.println(fun1(new ArrayList<Integer>()));
//        System.out.println(fun1(new ArrayList<String>()));
    }
}
