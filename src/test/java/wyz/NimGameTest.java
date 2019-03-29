package wyz;

import org.junit.*;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by yzwang on 2017/11/9.
 */
public class NimGameTest {
    @org.junit.Test
    public void ifGreatHelf() throws Exception {

        System.out.println(NimGame.ifGreatHelf(3,5));
        System.out.println(NimGame.ifGreatHelf(3,6));
        System.out.println(NimGame.ifGreatHelf(3,9));

        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(6));
        }

    }

}