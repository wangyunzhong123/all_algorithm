package Didi;

import java.util.*;

/**
 * Created by yzwang on 2017/9/10.
 */
public class Test_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int index_b;
        int i;
        int ans = 0;
        int res = 0;
        Map<Integer,Integer> w = new HashMap<Integer, Integer>();
        int [] dp = new int[N+1];
        w.put(0,0);
        for (i = 1; i <= N; i++) {
            index_b = sc.nextInt();
            res = res ^ index_b;
            if(w.containsKey(res))
                dp[i] = Math.max(ans,dp[w.get(res)]+1);
            else
                dp[i] = ans;

            ans = Math.max(ans,dp[i]);
            w.put(res,i);

        }
        System.out.println(ans);

//        System.out.println(N);
    }
}
