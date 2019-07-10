package Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Created by yzwang on 2019/4/3.
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer integer = iterator.next();
//            if(integer==1)
//                iterator.remove();
////                list.remove(integer);
//        }

//        for(Integer i : list){
//            if(i == 3)
//                list.remove(3);
//        }

        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if(integer == 3)
                list.remove(integer);
        }

        Vector v = new Vector();
        Stack s = new Stack();
        List l = null;
        HashMap hashMap = null;
        ArrayBlockingQueue arrayBlockingQueue = null;
//        Arrays.asList({1,2,4});

        Thread thread = null;
        thread.start();

        Throwable throwable = null;
        Function f = null;
        ConcurrentHashMap c = new ConcurrentHashMap();
    }
}
