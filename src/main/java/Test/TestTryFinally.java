package Test;

/**
 * Created by yzwang on 2017/12/12.
 */
public class TestTryFinally {

    static String s = "A";

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(s);

        Object a = new Object();
    }
    private static String test(){

        try{
            System.out.println("A");
            return s = "A";
        }finally {
            System.out.println("B");
            s = "B";
        }
    }
}
