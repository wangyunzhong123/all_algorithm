package Dajiang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/3.
 */
public class Test2 {

    public static void main(String[] args) throws ParseException{

        SimpleDateFormat sdf  =   new SimpleDateFormat( "MM.dd HH:mm:ss" );

//        Date date1 = sdf.parse( " 08.10 15:30:22 " );
//        Date date2 = sdf.parse( " 08.11 15:30:22 " );
//
//        System.out.println(date1);
//        System.out.println(date2);

        Scanner sc = new Scanner(System.in);

        ArrayList<String> timeList = new ArrayList<String>();

        ArrayList<Date> dateList = new ArrayList<Date>();

        int N = sc.nextInt();

        sc.nextLine();//

        for (int i = 0; i < N; i++) {
            timeList.add(sc.nextLine());
        }

        /**
         * 字符串转时间
         */
        for (String str : timeList) {
            try {
                dateList.add(sdf.parse(str));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        /**
         * 打印时间
         */
        System.out.println("排序前：");
        for(Date d:dateList){
            System.out.println(sdf.format(d));
        }

        /**
         * 冒泡排序
         * 如果不喜欢可以使用其他的排序方法
         */
        Date tempDate = null;
        for (int i = dateList.size()- 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                /**
                 * 从大到小的排序
                 */
                if(dateList.get(j+1).after(dateList.get(j))){
//                    tempDate = dateList.get(j);
//                    dateList.set(j, dateList.get(j+1));
//                    dateList.set(j+1, tempDate);
                }else{
                    /**
                     * 从小到大
                     */
                  tempDate = dateList.get(j);
                  dateList.set(j, dateList.get(j+1));
                  dateList.set(j+1, tempDate);
                }
            }
        }
        /**
         * 打印排序之后的时间
         */

        System.out.println("排序后：");
        for(Date d:dateList){
            System.out.println(sdf.format(d));
        }




    }
}
