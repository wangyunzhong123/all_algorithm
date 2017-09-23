package Jingdong;

/**
 * Created by yzwang on 2017/9/8.
 */

import java.util.Scanner;
import java.util.Stack;

public class Test_1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String abc = sc.nextLine();
        Stack<Character> stack=new Stack<Character>();

        char[] NM = abc.toCharArray();

        int count = 1;
        for(int i=0;i<NM.length;i++){
            if(NM[i]=='('){
                stack.push(NM[i]);
            }else {
                count*=stack.size();
                stack.pop();
            }
        }
        System.out.println(count);

    }
}