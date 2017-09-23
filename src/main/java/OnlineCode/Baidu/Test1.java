package OnlineCode.Baidu;

import java.util.*;

/**
 * Created by yzwang on 2017/9/2.
 */
public class Test1 {

    static ArrayList<Integer> fence(int numOfPlanks,int numOfColors,int numOfSteps,int[][] steps){

        ArrayList<Integer> result = new ArrayList<Integer>();

        int[] index = new int[numOfPlanks];
        for (int i = 0; i < numOfPlanks; i++) {
            index[i] = -1;
        }

        for (int i = 0; i < numOfSteps; i++) {

            for (int k = steps[i][0]-1; k <=steps[i][1]-1 ; k++) {
                index[k] = steps[i][2];

            }
            int temp = fun(index);
            result.add(temp);

        }
        return result;
    }
    static int fun(int[] index){

        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < index.length; i++) {
            if(!map.containsKey(index[i]))
                map.put(index[i],1);
            else {
                int temp = (int)map.get(index[i]);
                map.put(index[i],temp+1);
            }
        }
        int result = 0;
        //遍历map中的值
        for (Integer value : map.values()) {

            if(value>result)
                result = value;

        }
        return result;
    }

    public static void main(String[] args) {

        int a =5;
        int b = 5;
        int c = 4;
        int [][] d = new int[c][];

        d[0] = new int[]{2,3,5};
        d[1] = new int[]{4,5,2};
        d[2] = new int[]{4,5,1};
        d[3] = new int[]{1,5,4};

        System.out.println(fence(a,b,c,d));

    }
}
