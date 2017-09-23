package Dajiang;

/**
 * Created by yzwang on 2017/9/7.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小车移动
 */
public class Test_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List result = new ArrayList();

        while (true) {
            int len = sc.nextInt();

            double a_power = sc.nextInt();
            double a_location = sc.nextInt();
            double a_dire = sc.nextInt();

            double b_power = sc.nextInt();
            double b_location = sc.nextInt();
            double b_dire = sc.nextInt();

            //如果相反方向，各自判断

            // 左，右
            if (a_location < b_location && a_dire < b_dire) {

                int temp = fun_4(len, a_power, a_location, b_power, b_location);
                result.add(temp);
            }

            // 右 ，左
            if (b_location < a_location && b_dire < a_dire) {
                int temp = 0;
                if (b_power >= b_location)
                    temp++;
                if (a_power >= (len - a_location))
                    temp++;
                result.add(temp);
            }

            //相同方向。右，右

            if (a_location < b_location && a_dire == 1 && b_dire == 1) {

                int temp = fun_1(len, a_power, a_location, a_dire, b_power, b_location, b_dire);

                result.add(temp);

            }

            if (b_location < a_location && b_dire == 1 && a_dire == 1) {

                int temp = fun_1(len, b_power, b_location, b_dire, a_power, a_location, a_dire);

                result.add(temp);

            }

            // 左 左

            if (a_location < b_location && a_dire == -1 && b_dire == -1) {

                int temp = fun_2(len, b_power, b_location, b_dire, a_power, a_location, a_dire);

                result.add(temp);

            }

            if (b_location < a_location && b_dire == -1 && a_dire == -1) {

                int temp = fun_2(len, a_power, a_location, a_dire, b_power, b_location, b_dire);

                result.add(temp);

            }

            //对头了

            if (a_location < b_location && a_dire == 1 && b_dire == -1) {

                int temp = fun_3(len, a_power, a_location, a_dire, b_power, b_location, b_dire);

                result.add(temp);
            }

            if (b_location < a_location && b_dire == 1 && a_dire == -1) {

                int temp = fun_3(len, b_power, b_location, b_dire, a_power, a_location, a_dire);

                result.add(temp);
            }
//            sc.nextLine();

            for (int i = 0; i < result.size(); i++) {

                System.out.println(result.get(i));
            }
        }


//        System.out.println(result);


    }

    //右 右
    public static int fun_1(int len, double a_power, double a_location, double a_dire,
                     double b_power, double b_location, double b_dire){

        int temp = 0;
        //右边的车子可以走出去
        if(b_power >= (len - b_location))
            temp++;
        else {
            //走了多远
            double haha = b_power;
            //a 需要走多远赶上
            double hehe = b_location-a_location + haha;
            //a还剩的能量
            double a_last = a_power - hehe;
            if(a_last > 0){
                if(a_last >= (len - b_location - haha)*2) {
                    temp++;
                    if((len - b_location - haha) *2 - a_last >= 1)
                        temp ++;
                }

            }
        }

        return temp;

    }

    // 左 左

    public static int fun_2(int len, double a_power, double a_location, double a_dire,
                            double b_power, double b_location, double b_dire){

        int temp = 0;
        //左边的车子可以走出去
        if(a_power >= a_location)
            temp++;
        else {
            //走了多远
            double haha = a_power;
            //b 需要走多远赶上
            double hehe = b_location-a_location + haha;
            //b还剩的能量
            double b_last = b_power - hehe;
            if(b_last > 0){
                if(b_last >= (a_location - haha)*2) {
                    temp++;
                    if((a_location - haha) *2 - b_last >= 1)
                        temp ++;
                }

            }
        }

        return temp;

    }

    //左， 右
    public static int fun_3(int len, double a_power, double a_location, double a_dire,
                            double b_power, double b_location, double b_dire){

        //不撞
        if(b_location - a_location >= a_power + b_power){
            return 0;
        }
        else {
            //撞的位置
            double loca = a_location + (b_location - a_location)/2.0;
            double aa_location = a_location + loca;
            double aa_power = a_power - loca;

            double bb_location = b_location - loca;
            double bb_power = b_power - loca;

            int result = fun_4(len,aa_power,aa_location,bb_power,bb_location);
            return result;
        }
    }

    //左， 右
    public static int fun_4(int len,double a_power,double a_location,double b_power,double b_location){

        int temp = 0;
        if(a_power >= a_location + 1)
            temp++;
        if(b_power >= (len - b_location))
            temp++;

        return  temp;

    }
}
