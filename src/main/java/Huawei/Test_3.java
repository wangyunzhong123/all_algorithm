package Huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/6.
 */

/**
 * 接啤酒，人数5，啤酒龙头个数3，按顺序，每人需要4，4，1，2，1。每接一个单位需要1s，问所有人都完成需要多少秒
 */
public class Test_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] w = new int[n];
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {

            w[i] = sc.nextInt();

            temp[i] = 0;
        }

        if(n<=m){
            System.out.println(getMax(w));
            return;
        }

        int time = 0;

        int [] mm = new int[m];
        for (int i = 0; i < m; i++) {
            mm[i] = w[i];
        }

        int cur = m-1;

        boolean flag = false;
        while (true){

            MinAndList minAndList = getIndexOfMin(mm);
            int min = minAndList.min;
            List list = minAndList.list;
            time += min;

            for (int i = 0; i < m; i++) {
                mm[i] -=min;
            }

            for (int i = 0; i < list.size(); i++) {
                cur ++;
                if(cur > n-1){
                    flag =true;
                    break;
                }
                else
                    mm[(Integer) list.get(i)] += w[cur];
            }
            if(flag){
                time +=getMax(mm);
                System.out.println(time);
                return;
            }
        }

//        int[] a = new int[]{1,2,3,1,5,3,7,4,2,1};
//        getIndexOfMin(a);


    }

    public static int getMax(int [] a){

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > result)
                result = a[i];
        }

        return result;
    }

    public static MinAndList getIndexOfMin(int[] a){

        List result  = new ArrayList();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(a[i] < min)
                min = a[i];
        }


        for (int k = 0; k < a.length; k++) {
            if(a[k] == min)
                result.add(k);
        }

        MinAndList ha = new MinAndList(min,result);

        return ha;

    }

    static class MinAndList{
        public int min;
        public List list;

        public MinAndList(int a ,List b){
            min = a;
            list = b;
        }
    }
}
