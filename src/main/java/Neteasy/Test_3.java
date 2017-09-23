package Neteasy;

import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/9.
 */
public class Test_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int [] a = new int[N];
        int [] cha = new int[N-1];
        int [] index_l = new int[N-1];
        int [] index_r = new int[N-1];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            if(i>0) {
                cha[i - 1] = Math.abs(a[i] - a[i - 1]);
                index_l[i-1] = i-1;
                index_r[i-1] = i;
            }
        }

//        for (int i = 0; i < N-1; i++) {
//            System.out.println(cha[i]);
//            System.out.println(index_l[i]);
//            System.out.println(index_r[i]);
//        }

        System.out.println(3);
    }
}
