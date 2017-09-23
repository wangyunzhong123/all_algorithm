package Hikvison;

/**
 * Created by yzwang on 2017/9/14.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) throws ParseException {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()) {
            String string=in.nextLine();
            String[] sp=string.split(",");
            int n=Integer.parseInt(sp[0]);
            if (n<3) {
                System.out.println("incorrect data");
                continue;
            }
            if (!IsTime(sp[1])||!IsTime(sp[2])) {
                System.out.println("incorrect data");
                continue;
            }
            DateFormat dfDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1=dfDateFormat.parse(sp[1]);
            Date d2=dfDateFormat.parse(sp[2]);
            long diff=d2.getTime()-d1.getTime();
            long zheng=diff/(15*60*1000);
            long yu=diff%(15*60*1000);
            if (yu==0) {
                int t=(int) (zheng%n);
                int p=(int) (zheng/n);
                System.out.println((p+1)+";"+(t+1)+"-"+(t+1));
            }else {
                int t=(int) (zheng%n);
                int p=(int) (zheng/n);
                System.out.println((p+1)+";"+(t+1)+"-"+(t+2));
            }

        }
    }
    public static boolean IsTime(String time) {
        String[] tsp=time.split(" ");
        String[] ttsp=tsp[1].split(":");
        if (Integer.parseInt(ttsp[0])<0||Integer.parseInt(ttsp[0])>=24) {
            return false;
        }
        if (Integer.parseInt(ttsp[1])<0||Integer.parseInt(ttsp[1])>=60) {
            return false;
        }
        if (Integer.parseInt(ttsp[2])<0||Integer.parseInt(ttsp[2])>=60) {
            return false;
        }
        return true;

    }

}