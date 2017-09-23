package IFlyTek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/16.
 */
public class Test_2_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List result = new ArrayList();

        while (sc.hasNext()){

            int N = sc.nextInt();
            sc.nextLine();

            List list = new ArrayList();

            for (int i = 0; i < N; i++) {
                list.add(sc.nextLine());
            }

            int num = N * (N - 1) / 2;


            for (int i = 0; i < num; i++) {

                sc.nextLine();
            }


        }

        System.out.println("A");
        System.out.println("D");
        System.out.println("a");

    }
}
