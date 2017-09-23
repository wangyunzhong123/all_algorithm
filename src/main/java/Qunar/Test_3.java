package Qunar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/20.
 */
public class Test_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(fun_fun(a,b,m));
    }

    public static int fun_fun(int a,int b,int p) {

        long temp=a,t=1;

        while(b>0)
        { if((b & 1) !=0)          //如果幂b是奇数多乘一次，因为后边会除2变偶数，（7/2=3）

            t=(t%p)*(temp%p)%p;

            temp=(temp%p)*(temp%p)%p;

            b/=2;    }

        return (int)(t%p);

    }



}
