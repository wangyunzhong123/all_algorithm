package util;

import java.security.PublicKey;

/**
 * Created by yzwang on 2017/9/11.
 */
public class InnerClassTest {

    private int x = 200;

    public class Inner{
        private int y = 100;
        public int innerAdd(){
            return x + y;
        }
    }

    public static void main(String[] args) {

        InnerClassTest test = new InnerClassTest();
//        test.Inner inner = new test.Inner();

        int a = 0x10;
        int b = 010;
        System.out.println(a);
        System.out.println(b);
    }
}
