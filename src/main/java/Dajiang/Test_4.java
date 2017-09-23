package Dajiang;

/**
 * Created by yzwang on 2017/9/3.
 */
public class Test_4 {

    public static char getChOfNum(int a){

        return (char)(a+97);
    }

    public static int getNumOfCh(char ch){

        return Integer.valueOf(ch)-48;
    }


    public static void main(String[] args) {

        System.out.println(getChOfNum(0));

        System.out.println(getNumOfCh('0'));
        System.out.println(getNumOfCh('9'));
        System.out.println(getNumOfCh('8'));
    }
}
