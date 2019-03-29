package wyz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/11/9.
 */
public class NimGame {

    public static void main(String[] args) {

        /**
         * 20 3 5 7 10 1 4
         * 19 2 6 6 9 1 9
         * ...
         */

        int[][] nim = new int[20][7];
        for (int i = 0; i < nim.length; i++) {

            nim[i][0] = nim.length -i;
        }

        for (int i = 0; i < 2; i++) {
            fun(nim, 20,new ArrayList());
        }


        display(nim);
    }

    public static boolean fun(int[][] nim, int num, List list){
        // lose
        if(num == 0){

            System.out.println("human success...");
            return false;
        }

        if(num <= 3){
            System.out.println(num +" : "+", compute's : "+num);
            System.out.println("human failure...");
            nim[20-num][num *2]++;
//            nim[20-num][num *2 - 1]++;
            list.add(num);
            System.out.println(list);

            display(nim);

            update(nim,list);
            return true;
        }

        int index = 20-num;

        int a1 = nim[index][1];
        int a2 = nim[index][2];
        int b1 = nim[index][3];
        int b2 = nim[index][4];
        int c1 = nim[index][5];
        int c2 = nim[index][6];

        int how = 0;

        int human = 0;

        int[] choice = {1,2,3};

        if(countZero(a2,b2,c2) > 0 || (!ifGreatHelf(a1,a2) && !ifGreatHelf(b1,b2) && !ifGreatHelf(c1,c2))){

            how = choice[new Random().nextInt(3)];

        }else {
            double a = Double.valueOf(a1) / Double.valueOf(a2);
            double b = Double.valueOf(b1) / Double.valueOf(b2);
            double c = Double.valueOf(c1) / Double.valueOf(c2);

            if(a >= Math.max(b,c))
                how = 1;
            if(b >= Math.max(a,c))
                how = 2;
            if(c >= Math.max(a,b))
                how = 3;
        }
        System.out.println((20-index-1) +" : "+", compute's : "+how);
        list.add(how);

        nim[index][how*2] ++;

//        if(num - how <= 3){
//            System.out.println((20-index-1) +" : "+", human's : "+(num - how));
//            list.add(num-how);
//            System.out.println("human success...");
//
//            return false;
//        }else {
//            human = choice[new Random().nextInt(3)];
//            System.out.println((20-index-1) + " : " + ", human's : " + human);
//            list.add(human);
//            return fun(nim, num - how - human,list);
//        }

        // human
        System.out.println("please input the item you want to take : ");
        human = new Scanner(System.in).nextInt();
        while (human < 1 || human > (num - how) || human > 3){
            System.out.println("error, please re input : ");
            human = new Scanner(System.in).nextInt();
        }

        if(num - how - human == 0){
            System.out.println((20-index-1) +" : "+", human's : "+ human);
            list.add(num-how);
            System.out.println("human success...");

            return false;
        }else {
            System.out.println((20-index-1) + " : " + ", human's : " + human);
            list.add(human);
            return fun(nim, num - how - human,list);
        }

    }

    private static int countZero(int a,int b,int c){
        int result = 0;
        if(a ==0)
            result ++;
        if(b ==0)
            result ++;
        if(c ==0)
            result ++;

        return result;
    }

    public static boolean ifGreatHelf(int a,int b){

        return Double.valueOf(a) / Double.valueOf(b) > 0.5;
    }

    private static void display(int[][] nim){
        for (int i = 0; i < nim.length; i++) {
            for (int j = 0; j < nim[i].length; j++) {
                System.out.print(nim[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    private static void update(int[][] nim, List list){
        int index = list.size()-1;
        int a= 0;

        if(index ==0){
            nim[20 - (Integer)list.get(0)][(Integer)list.get(0) * 2 -1]++;
            return;
        }

        while (index >= 0){

            int b = (Integer)list.get(index);

            a += b;
            nim[20-a][b * 2 -1]++;

            if(index ==0)
                break;

            index --;
            a += (Integer)list.get(index);

            index --;

        }

    }
}
