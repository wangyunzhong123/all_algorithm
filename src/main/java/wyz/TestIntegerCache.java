package wyz;

/**
 * Created by tianxi on 12/26/16.
 */
public class TestIntegerCache {

    public static void main(String[] args){

        Integer a = new Integer(12);
        Integer b = new Integer(12);
        Integer bb = 12;

        System.out.println(a == b);
        System.out.println(a == bb);

        Integer c = new Integer(212);
        Integer d = new Integer(212);
        System.out.println(c == d);

        System.out.println("######################");
        Integer e = Integer.valueOf(128);//-128~127
        Integer f = Integer.valueOf(128);
        System.out.println(e == f);

        System.out.println("######################");
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program"+"ming";
        System.out.println(s1 ==s2);
        System.out.println(s1 ==s3);
        System.out.println(s1 ==s1.intern());
    }
}
