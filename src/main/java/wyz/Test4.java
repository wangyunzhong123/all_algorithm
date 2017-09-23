package wyz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by tianxi on 4/7/17.
 */
public class Test4 {
    
    private static void print(){
        System.out.println("ppppp");
    }
    public void Test4(int a){

    }
    public void Test4(int a,int b){
        Test4(a);
    }
    public static void main1(String[] args){
        ((Test4)null).print();

        int x = 5, y =5;
        int a,b;
        a = x++;
        b = ++y;
        System.out.printf(a+"");
        System.out.printf(b+"");
        String str = "sdfsd";



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个二进制数: ");
        String a = sc.nextLine();
        int d = Integer.parseInt(a, 2); // 2进制
        int o = Integer.parseInt(a, 8); // 8进制
        System.out.println("二进制转为十进制: " + d);
        System.out.println("八进制转为十进制: " + o);

//        System.out.println(cal(9,011));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE * 2);
        System.out.println(Integer.MAX_VALUE <<1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println();
        System.out.println(Integer.SIZE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.SIZE);

        return;
    }

    public static int cal(int a,int b){
        try{
            return a / b;
        }catch(Exception e){
            System.out.println("eeee");
        }

        Map map = new HashMap();

        return 0;
    }

}

