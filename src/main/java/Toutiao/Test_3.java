package Toutiao;

/**
 * Created by yzwang on 2017/9/10.附加题
 */

import java.util.HashMap;
import java.util.Scanner;

public class Test_3 {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String str=scanner.next();
        int n=scanner.nextInt();

        int res=0;
        if(str.length()==1){
            System.out.println(1);
            return;
        }

        HashMap map =new HashMap<Character, Integer>();
        HashMap<Character, Integer> count =new HashMap<Character, Integer>();
        int max=1;
        char arr[]=str.toCharArray();
        for(int i=1;i<str.length();i++){
            if(arr[i]==arr[i-1]){
                max++;
                res=max>res?max:res;
            }
            else
                max=1;
        }
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], i);
                count.put(arr[i],1);
            }else{
                max= count.get(arr[i])+1;
                count.put(arr[i],max);
                res=max>res?max:res;
                map.put(arr[i], i);
            }
        }
        System.out.println(res);
    }
}
