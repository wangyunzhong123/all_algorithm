package Java.data;

/**
 * Created by yzwang on 2019/9/22.
 */

public class Person {

    @Override
    public Variant clone() {
        return new Variant();
    }

    protected Person fun(int a) {
        return new Person();
    }
}
