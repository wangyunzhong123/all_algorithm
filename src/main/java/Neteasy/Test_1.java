package Neteasy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/9.
 */
public class Test_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < N; i++) {

            int Length = sc.nextInt();

            BigInteger [] bigInteger = new BigInteger[Length];

            int four=0, one =0, two = 0;
            for (int j = 0; j < Length; j++) {

//                bigInteger[i] = sc.nextBigInteger();
                BigInteger haha  = sc.nextBigInteger();

                BigInteger[] temp = haha.divideAndRemainder(BigInteger.valueOf(4));
                BigInteger[] temp_2 = haha.divideAndRemainder(BigInteger.valueOf(2));

                if(temp[1] == BigInteger.valueOf(0)){
                    four ++;
                }
                else if(temp_2[1] == BigInteger.valueOf(0)){
                    two ++;
                }else
                    one ++;

            }
            if(one > four +1 || (one == four +1 && two !=0))
                result.add("No");
            else
                result.add("Yes");
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
