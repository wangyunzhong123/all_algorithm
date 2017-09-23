package Sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/8.
 */
public class Test_1 {

    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(reader.readLine());
            double [] num = new double[N];


            for (int i = 0; i < N; i++) {

                String input = reader.readLine();

                BigDecimal   b   =   new   BigDecimal(Double.parseDouble(input));

                num[i]  =  b.setScale(8,   BigDecimal.ROUND_HALF_UP).doubleValue();


            }

            double dou_180 = Double.parseDouble("180.00000000");
            double dou_360 = Double.parseDouble("360.00000000");

            if(num[N-1] <= Double.parseDouble("180.00000000"))
                System.out.println(num[N-1] - num[0]);
            else {

//                System.out.println(Double.parseDouble("360.00000000") - num[N-1] + num[0]);

                double max_ = Double.MIN_VALUE;

                for (int i = 0; i < N; i++) {
                    List list = binarySearch(num,dou_180+num[i],i);
                    double max = Double.MIN_VALUE;
                    for (int j = 0; j < list.size(); j++) {
                        double haha = num[(Integer) list.get(j)];
                        double temp =haha - num[i];
                        if( temp <= dou_180){
                            if(temp > max)
                                max = temp;
                        }
                        else {
                            double hehe = dou_360 - temp;
                            if(hehe > max)
                                max = hehe;
                        }
                    }

                    if(max > max_)
                        max_ = max;

                }
                System.out.println(max_);
            }

//            for (int i = 0; i < N; i++) {
//
//                System.out.println(num[i]);
//            }




            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {

            e.printStackTrace();
        }
    }

    public static List binarySearch(double[] srcArray,Double des,int Start){
        //第一个位置.
        int low=Start;
        //最高位置.数组长度-1,因为下标是从0开始的.
        int high=srcArray.length-1;
        int middle  = 0;

        List result = new ArrayList();
        //当low"指针"和high不重复的时候.
        while(low<=high){
            //中间位置计算,low+ 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2
            middle=low+((high-low)>>1);
            //与最中间的数字进行判断,是否相等,相等的话就返回对应的数组下标.
            if(des == srcArray[middle]){
                result.add(middle);

                return result;
                //如果小于的话则移动最高层的"指针"
            }else if(des<srcArray[middle]){
                high=middle-1;
                //移动最低的"指针"
            }else{
                low=middle+1;
            }
        }
        //如果没有找到
        if(low < srcArray.length)
            result.add(low);
        if(high < srcArray.length)
            result.add(high);

        return result;
    }

}
