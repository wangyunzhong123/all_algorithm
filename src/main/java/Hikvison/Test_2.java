package Hikvison;

import java.util.*;

/**
 * Created by yzwang on 2017/9/14.
 */
public class Test_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List list = new ArrayList();

        while(sc.hasNext()){

            String line = sc.nextLine();
            String [] str = line.split(";");
            if(str.length < 3){
                list.add("incorrect data");
                continue;
            }

        }
    }

    public static String fun(String[] str){

        Map<String,List<String>> map = new HashMap();
        Map ma = new HashMap();
        for (int i = 0; i < str.length; i++) {
            String[] haha = str[i].split(",");
            ma.put(haha[0],haha[1]);

            if(haha[0] == haha[2]){
                return "incorrect data";
            }

            List temp = map.get(haha[1]);
            if(temp == null)
                temp = new ArrayList();
            temp.add(haha[1]);

            map.put((String)ma.get(haha[2]),temp);

        }

        return "";
    }

    public static String fun_2(Map map, Map ma, String a){


        return "";

    }
}
