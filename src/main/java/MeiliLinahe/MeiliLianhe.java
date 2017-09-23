package MeiliLinahe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/23.
 */
public class MeiliLianhe {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        List result = new ArrayList();

        while (sc.hasNext()) {

            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();

            sc.nextLine();

            int sum = 0;
            int hehe = 0;

            sum += allDays(month);
            sum = sum + day;
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
                hehe = 1;
            else
                hehe = 0;
            if (hehe == 1 && month > 2)
                sum++;

            result.add(sum);

        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static int allDays(int month){

        int result = 0;

        if(month==2)
            result = 31;
        else if(month==3)
            result = 59;
        else if(month==4)
            result = 90;
        else if(month==5)
            result = 120;
        else if(month==6)
            result = 151;
        else if(month==7)
            result = 181;
        else if(month==8)
            result = 212;
        else if(month==9)
            result = 243;
        else if(month==10)
            result = 273;
        else if(month==11)
            result = 304;
        else if(month==12)
            result = 334;
        return result;
    }
}
