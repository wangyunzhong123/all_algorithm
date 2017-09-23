package Dajiang;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/3.
 */
public class Test_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N =  sc.nextInt();

        sc.nextLine();

        String[] str = new String[N];

        String[] result = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = sc.nextLine();

            int a = new Random().nextInt()*100;
            if(a % 2 == 0)
                result[i] = "yes";
            else result[i] = "no";

        }

        for (int i = 0; i < N; i++) {

            System.out.println(result[i]);
        }

    }
}
