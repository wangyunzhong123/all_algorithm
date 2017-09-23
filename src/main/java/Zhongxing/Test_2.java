package Zhongxing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yzwang on 2017/9/8.
 */
public class Test_2 {

    public static int miniNumberOfGunShots(int num, int shotDegrade,
                                           int remDegrade, int[] health) {
        List<Integer> list = new ArrayList<Integer>(num);
        for (int i = 0; i < num; i++) {
            list.add(health[i]);
        }
        Collections.sort(list);
        int cou = 0;
        while (list.size() > 0) {
            cou++;
            int temp = list.remove(list.size() - 1);
            temp = temp - shotDegrade;
            for (int i = 0; i < list.size(); i++) {
                int n = list.remove(0);
                n = n - remDegrade;
                if (n > 0) {
                    list.add(n);
                }
            }
            if (temp > 0) {
                list.add(temp);
            }
            Collections.sort(list);
        }
        return cou;
    }
}
