package Qunar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/20.
 */
public class Test_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        int K = sc.nextInt();

        String[] strs = line.split(" ");
        char[] ch = new char[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ch[i] = strs[i].toCharArray()[0];
        }

        Arrays.sort(ch);

//        for (int i = 0; i < ch.length; i++) {
//            System.out.println(ch[i]);
//        }

        for (int i = 0; i < K-1; i++) {
            System.out.print(ch[i]+" ");
        }
        System.out.print(ch[K-1]);

        System.out.println();

        for (int i = ch.length-1; i >ch.length-K ; i--) {
            System.out.print(ch[i]+" ");
        }
        System.out.print(ch[ch.length-K]);
    }
}
