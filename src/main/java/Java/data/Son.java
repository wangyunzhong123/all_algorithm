package Java.data;

/**
 * Created by yzwang on 2019/9/22.
 */
public class Son extends Person {

    @Override
    public Son fun(int a) {
        return new Son();
    }
}
