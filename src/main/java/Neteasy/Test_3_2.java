package Neteasy;

import java.util.Scanner;
/**
 * Created by yzwang on 2017/9/9.
 */

public class Test_3_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int count=scanner.nextInt();
            int arr[]=new int[n-1];
            for(int i=0;i<arr.length;i++){
                arr[i]=scanner.nextInt();
            }
            System.out.println(get(arr, count));
        }
    }
    public static int get(int arr[],int count){
        int res=0;
        boolean re_arr[]=new boolean[arr.length+1];
        re_arr[0]=true;
        for(int i=1;i<re_arr.length;i++){
            re_arr[i]=false;
        }

        for(int i=0;i<arr.length;i++){
            if(count>0&&!re_arr[arr[i]+1]&&re_arr[arr[i]]){
                count--;
                re_arr[arr[i]+1]=true;
            }
        }

        for(int i=0;i<re_arr.length;i++){
            if(re_arr[i]==true)
                res++;
        }
        return res;
    }
}