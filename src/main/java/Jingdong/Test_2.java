package Jingdong;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test_2 {
    public static Set<String> setRes = new TreeSet<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            for(int i=1; i<=n; i++) {
                compute(i, 0, 0, 0, n);
            }

            System.out.println(setRes.size() % 1000000007);
        }
    }
    public static void compute(int a, int b, int c, int d, int n) {
        if(a!=0 && b!=0 && c!=0 && d!=0 && c>a && d>b) {
            return ;
        }
        else if(a!=0 && b!=0 && c!=0 && d!=0 && a>c && b>d) {
            return ;
        }
        else if (a!=0 && b!=0 && c!=0 && d!=0 && a==c && b == d){
            String tem = a+" "+b+" "+c+" "+d;
            //System.out.println(tem);
            setRes.add(tem);
            return ;
        }
        else if(a!=0 && b!=0 && c!=0 && d!=0 && a==b && b==c && c==d){
            String tem = a+" "+b+" "+c+" "+d;
            //System.out.println(tem);
            setRes.add(tem);
            return ;
        }
        else if(a!=0 && b!=0 && c!=0 && d!=0) {
            if(Math.pow(a, b) == Math.pow(c, d)) {
                String tem = a+" "+b+" "+c+" "+d;
                //System.out.println(tem);
                setRes.add(tem);
            }
            return ;
        }

        if(b == 0) {
            for(int i=1; i<=n; i++) {
                compute(a, i, c, d, n);
            }
        }
        else if(c == 0) {
            for(int i=1; i<=n; i++) {
                compute(a, b, i, d, n);
            }
        }
        else if(d == 0) {
            for(int i=1; i<=n; i++) {
                compute(a, b, c, i, n);
            }
        }
    }
}