package wyz;

/**
 * Created by yzwang on 2017/9/28.
 */
public class Test6 {

    public static void main(String[] args) {

        int a = 1;
        int b =100;

        System.out.println((a^b)^(b^a));
//        System.out.println(a^(a^b) &  ~(a<b));

        System.out.println(a^(a^b));

    }
}
