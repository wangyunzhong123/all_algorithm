package Java;

/**
 * Created by yzwang on 2019/9/22.
 */
public class StringTest {

    public static void main(String[] args) {
        String a = "";
//        System.out.println(a.substring(1, 2));

        a = "中国sdfs";
        System.out.println(a.length());

        String tt = "我喜欢?这个字符";
        System.out.println(tt.length()); // 9

        /**
         * Unicode基本字符，增补字符
         * https://zhuanlan.zhihu.com/p/35172335
         */
        String str = "𐐷";
        System.out.println(str.length()); // 2
    }
}
