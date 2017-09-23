package Jingdong;

import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/8.
 */
public class Test_2_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();

            int result = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    double temp_1 = Math.pow(i,j);

                    for (int k = 1; k <=n ; k++) {
                        for (int l = 1; l <=n ; l++) {

                            double a_2 = Math.pow(k,l);
                            if(temp_1 == a_2)
                                result ++;
                        }
                    }
                }
            }

            System.out.println(result);
        }
    }
}
