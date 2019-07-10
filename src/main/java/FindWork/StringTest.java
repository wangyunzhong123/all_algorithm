package FindWork;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 找工作
 * Created by yzwang on 2019/3/25.
 */
public class StringTest {

    public static void main(String[] args) {
        String a= "12";//final

        StringBuffer b = new StringBuffer();//线程安全的，用syc修饰方法。继承AbstractStringBuilder

        StringBuilder c = new StringBuilder();//线程不安全的

        LinkedList d = new LinkedList();

        ConcurrentHashMap h = new ConcurrentHashMap();

        Hashtable i = new Hashtable();




    }
}
