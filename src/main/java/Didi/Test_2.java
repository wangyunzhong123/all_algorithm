package Didi;

import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/10.
 */
public class Test_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if(N <= 0)
            System.out.println(0);

        if(N < 7)

            System.out.println(N);

        int [] result = new int[N];
        result[0] = 1;
        int num_2 = 0;
        int num_3 = 0;
        int num_5 = 0;

        int i = 1;

        for (; i < N; i++) {
            result[i] = Math.min(result[num_2]*2,Math.min(result[num_3]*3,result[num_5]*5));
            if(result[i] == result[num_2]*2)
                num_2++;

            if(result[i] == result[num_3]*3)
                num_3++;

            if(result[i] == result[num_5]*5)
                num_5++;
        }

        System.out.println(result[N-1]);
    }
}
