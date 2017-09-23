package IFlyTek;

/**
 * Created by yzwang on 2017/9/16.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

class Node implements Comparable<Node>{
    String name;
    int score;
    int jingshengqiushu;
    public Node(String name, int score, int jingshengqiushu, int jinqiushu) {
        super();
        this.name = name;
        this.score = score;
        this.jingshengqiushu = jingshengqiushu;
        this.jinqiushu = jinqiushu;
    }

    int jinqiushu;



    public int compareTo(Node o) {
        if(o.score > score){
            return 1;
        }
        else if(o.score < score){
            return -1;
        }
        else {
            if(o.jingshengqiushu > jingshengqiushu) {
                return 1;
            }
            else if(o.jingshengqiushu > jingshengqiushu) {
                return -1;
            }
            else {
                if(o.jinqiushu > jinqiushu) {
                    return 1;
                }
                else if(o.jinqiushu > jinqiushu) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getScore() {
        return score;
    }



    public void setScore(int score) {
        this.score = score;
    }



    public int getJingshengqiushu() {
        return jingshengqiushu;
    }



    public void setJingshengqiushu(int jingshengqiushu) {
        this.jingshengqiushu = jingshengqiushu;
    }



    public int getJinqiushu() {
        return jinqiushu;
    }



    public void setJinqiushu(int jinqiushu) {
        this.jinqiushu = jinqiushu;
    }
}
public class Test_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = Integer.valueOf(sc.nextLine());

            int nn = n*(n-1)/2;
            Map<String, Node> hm = new HashMap<String, Node>();
            while(n > 0) {
                String name = sc.nextLine();
                hm.put(name, new Node(name,0,0,0));
                n--;
            }

            while(nn>0) {

                String temRes = sc.nextLine();
                String[] nameAndSco = temRes.split(" ");
                String[] nameAndScoFro = nameAndSco[0].split("-");
                String[] nameAndScoBeh = nameAndSco[1].split(":");
                int fronScor = Integer.valueOf(nameAndScoBeh[0]);
                int behScore = Integer.valueOf(nameAndScoBeh[1]);
                Node temFron = hm.get(nameAndScoFro[0]);
                Node temBeh = hm.get(nameAndScoFro[1]);
                if(fronScor > behScore) {
                    temFron.setScore(temFron.getScore()+3);
                }
                else if(fronScor < behScore) {
                    temBeh.setScore(temBeh.getScore()+3);
                }
                else if(fronScor == behScore) {
                    temFron.setScore(temFron.getScore()+1);
                    temBeh.setScore(temBeh.getScore()+1);
                }
                temFron.setJingshengqiushu(temFron.getJingshengqiushu()+fronScor-behScore);
                temFron.setJinqiushu(temFron.getJinqiushu()+fronScor);
                temBeh.setJingshengqiushu(temBeh.getJingshengqiushu()+behScore-fronScor);
                temBeh.setJinqiushu(temBeh.getJinqiushu()+behScore);
                nn--;
            }


            List<Node> list = new ArrayList<Node>();
            for(Map.Entry<String, Node> tem : hm.entrySet()) {
                list.add(tem.getValue());
            }

            Collections.sort(list);
            TreeSet<String> ts = new TreeSet<String>();
            for(int i=0; i<=list.size()/2-1; i++) {
                ts.add(list.get(i).getName());
            }
            for(String s : ts) {
                System.out.println(s);
            }
        }

    }
}
