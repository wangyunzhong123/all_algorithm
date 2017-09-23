package wyz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Executors;

/**
 * Created by yzwang on 2017/9/20.
 */
public class Test5 extends parent{

    private int id;
    public int name;
    protected int uid;

    public Test5(Integer a){
        id = a;
    }

    @Override
    public String toString() {
        return "Test5{" +
                "id=" + id +
                '}';
    }

    {
        System.out.println("Sub Instance Code");
    }
    private PrintTmp p1 = new PrintTmp("Sub Instance Member");

    static {
        System.out.println("Sub Static Code");
    }
    private static PrintTmp p2 = new PrintTmp("Sub Static Member");


    public Test5() {
        System.out.println("Sub Constuctor");
    }

    public static void main(String[] args) throws Exception{

//        Constructor<Test5> constructor = Test5.class.getDeclaredConstructor(Integer.class);
////                .getConstructor(Integer.class);
//        Test5 stu3 = constructor.newInstance(123);
//
////        stu3.getClass();
//
//        System.out.println(stu3);

//        String class_name = Test5.class.getName();
//        Field[] obj_fields = Test5.class.getDeclaredFields();
////        System.out.println(Test5.class.getGenericSuperclass().getTypeName());
//        for (Field field : obj_fields) {
//            field.setAccessible(true);
//            System.out.println(class_name + ":" + field.getName());
//        }

//        Method[] methods = Test5.class.getDeclaredMethods();
//        for (Method method : methods) {
//            method.setAccessible(true);
//            System.out.println(class_name + ":" + method.getName());
//        }


        Test5 test5 = new Test5();
    }
}

class parent extends haha{

    private int a;
    protected int b;
    public int c;
    int d;



    private PrintTmp p1 = new PrintTmp("Parent Instance Member");

    {
        System.out.println("Parent Instance Code");
    }


    private static PrintTmp p2 = new PrintTmp("Parent Static Member");

    static {
        System.out.println("Parent Static Code");
    }

    public parent() {
        System.out.println("Parent Constuctor");
    }

}
class haha{
    private int aa;
    protected int bb;
    public int cc;
    int dd;

}
class PrintTmp {
    public PrintTmp(String strOut) {
        System.out.println(strOut);
    }
}