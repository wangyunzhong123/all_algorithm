package Dajiang;


import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/3.
 */
public class Test_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String [] result = new String [N];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String num = sc.nextLine();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();

            result[i] = num;

            char[] ch = num.toCharArray();
            int max = getMax(a,b,c);
            for (int j = 0; j < ch.length; j++) {
                if(getNumOfCh(ch[j]) < max){
                    result[i] = num.replace(ch[j],getChOfNum(max));
                    break;
                }
            }

        }

        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }


    }

    public static int getMax(int a,int b,int c){

        int temp = Math.max(a,b);

        return Math.max(temp,c);
    }

    public static char getChOfNum(int a){

        return (char)(a+97-49);
    }

    public static int getNumOfCh(char ch){

        return Integer.valueOf(ch)-48;
    }


}
