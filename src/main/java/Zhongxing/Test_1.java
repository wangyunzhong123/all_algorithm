package Zhongxing;

/**
 * Created by yzwang on 2017/9/8.
 */
public class Test_1 {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int populationDifference(int years, int initialRats)
    {
        // WRITE YOUR CODE HERE

        if(years >=3){

            long white = white_gr_3(initialRats,years);


        }
        else if(years ==2){

        }else if(years ==1){

        }else if(years ==0){

        }


        return 0;
    }

    public static void main(String[] args) {
        System.out.println(populationDifference(3,5));
    }

    public static long white_gr_3(int initialRats,int years){

        //black
        long a_0 = initialRats;

        long a_1 = a_0 + 2 * a_0;
        long a_2 = a_1 + 3 * a_0 + 2 * (a_1 - a_0);
        long a_3 = a_2 + 3 * (a_1 - a_0) + 2 * (a_2 - a_1) - a_0;


        long temp = years / 3;
        int temp_1 = years % 3;
        for (int i = 1; i < temp; i++) {

            long ha = a_1 ;
            long he = a_0;
            a_0 = a_3;
            a_1 = a_2;
            a_2 = ha;
            a_3 = he;

        }

        if(temp_1 ==0)
            return a_3;
        else if(temp_1 ==1)
            return a_1;
        else if(temp_1 ==2)
            return a_2;

        return 0;

    }

    public static long black_gr_3(int initialRats,int years){

        //black
        long a_0 = initialRats;

        long a_1 = a_0 + 3 * a_0;
        long a_2 = a_1 + 3 * (a_1 - a_0) - a_0;


        long temp = years / 3;
        int temp_1 = years % 3;
        for (int i = 1; i < temp; i++) {

            long ha = a_1 ;
            a_0 = a_2;
            a_1 = a_2;
            a_2 = ha;

        }

        if(temp_1 ==0)
            return a_1;
        else if(temp_1 ==1)
            return a_1;
        else if(temp_1 ==2)
            return a_2;

        return 0;

    }

}
