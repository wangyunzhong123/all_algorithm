package Xiaomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/18.
 */
public class Test_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<List<String>> result = new ArrayList<List<String>>();



        while(sc.hasNext()){

            String line = sc.nextLine();

            //长度为1
            List<String> temp = new ArrayList<String>();
            if(line.length() == 1)
                temp.add(String.valueOf(getChOfNum(Integer.valueOf(line))));
            else if(line.length() == 2){
                if(Integer.valueOf(line) <=26){
                    temp.add(String.valueOf(getChOfNum(Integer.valueOf(line.substring(0,1)))) +
                            String.valueOf(getChOfNum(Integer.valueOf(line.substring(1,2)))));

                    temp.add(String.valueOf(getChOfNum(Integer.valueOf(line))));
                }else {
                    temp.add(String.valueOf(getChOfNum(Integer.valueOf(line.substring(0,1)))) +
                            String.valueOf(getChOfNum(Integer.valueOf(line.substring(1,2)))));
                }
            }else if(line.length() ==3){
                temp.add(String.valueOf(getChOfNum(Integer.valueOf(line.substring(0,1)))) +
                        String.valueOf(getChOfNum(Integer.valueOf(line.substring(1,2)))) +
                        String.valueOf(getChOfNum(Integer.valueOf(line.substring(2,3)))));

                if(Integer.valueOf(line.substring(0,2)) <= 26){
                    temp.add(String.valueOf(getChOfNum(Integer.valueOf(line.substring(0,2)))) +
                            String.valueOf(getChOfNum(Integer.valueOf(line.substring(2,3)))));
                }
                if(Integer.valueOf(line.substring(1,3)) <= 26){
                    temp.add(String.valueOf(getChOfNum(Integer.valueOf(line.substring(0,1)))) +
                            String.valueOf(getChOfNum(Integer.valueOf(line.substring(1,3)))));
                }
            }

            result.add(temp);
//            line = sc.nextLine();

        }

        for (int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
            for (int j = 0; j < result.get(i).size()-1; j++) {
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println(result.get(i).get(result.get(i).size()-1));
        }

//        System.out.println(getChOfNum(1));
//        System.out.println(getChOfNum(20));
//        System.out.println(getChOfNum(26));
    }



    public static char getChOfNum(int a){

        return (char)(a+97-1);
    }

}
