package Java;

import java.awt.image.RasterFormatException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

/**
 * Created by yzwang on 2019/9/28.
 */
public class ExceptionTest {

    public static void main(String[] args) {

        System.out.println("start");
        try {
            fun();

        } catch (Exception e) {
            System.out.println("main exception");
        }
        System.out.println("end");

        fun();
        Hashtable hashMap;
        ObjectOutputStream a;


    }

    public static void fun() {
        try {
            throw new RasterFormatException("123");
        } catch (IllegalAccessError e) {
            System.out.println("IllegalAccessError");
        } finally {
            System.out.println("finally");
        }
    }
}
