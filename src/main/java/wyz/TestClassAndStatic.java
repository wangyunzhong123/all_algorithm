package wyz;

/**
 * Created by yzwang on 2017/9/23.
 */
public class TestClassAndStatic {

    private static TestClassAndStatic test = new TestClassAndStatic();

    {
        System.out.println("AAAAAA");
    }
    static {
        System.out.println("BBBBBB");


    }

    public static void main(String[] args) {

        TestClassAndStatic test = new TestClassAndStatic();


    }
}

/**
 * 为什么是这个输出？？？
 */
