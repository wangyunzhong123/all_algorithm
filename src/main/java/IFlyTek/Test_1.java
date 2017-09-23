package IFlyTek;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yzwang on 2017/9/16.
 */
public class Test_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        char[] ch = line.toCharArray();

        int m =0;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == 'L')
                m++;
            else
                break;
        }

        int nn = 0;
        for (int i = ch.length-1; i >=0 ; i--) {
            if(ch[i] == 'R')
                nn++;
            else
                break;
        }

        if((m+nn+1) > ch.length)
            System.out.println(ch.length);
        else
            System.out.println(m+nn+1);

    }
}
