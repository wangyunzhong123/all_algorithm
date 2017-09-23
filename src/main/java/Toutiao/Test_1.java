package Toutiao;

import java.util.*;

/**
 * Created by yzwang on 2017/9/10.
 */
public class Test_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        Map<Integer,List<Integer>> map = new HashMap();


        for (int i = 0; i < N; i++) {
            List list = null;
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                int temp = sc.nextInt();
                list = map.get(temp);
                if(list == null)
                    list = new ArrayList();
                list.add(i);
            }
        }

        //求一个排序数组中，是否有连续m个是连续的。其中，首尾成环
        int result = 0;
        for (int i = 1; i < c+1; i++) {
            List<Integer> list = map.get(i);
            Collections.sort(list);
            int size = list.size();

            for (int j = m-1; j < size; j++) {
                if(list.get(j) - list.get(0) >=m-1)
                    result ++;
            }

        }

        System.out.println(result);
    }
}
