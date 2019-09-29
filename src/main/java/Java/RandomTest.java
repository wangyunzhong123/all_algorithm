package Java;

import java.util.Random;

/**
 * Created by yzwang on 2019/9/22.
 */
public class RandomTest {

    public static void main(String[] args) {
        Random rnd = new Random();
        int a = Integer.MIN_VALUE;
        System.out.println(Math.abs(a)); // 这还会返回负值
        System.out.println(Math.abs(-123));
    }
}
