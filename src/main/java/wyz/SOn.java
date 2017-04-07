package wyz;

import java.applet.Applet;
import java.io.Externalizable;
import java.util.Map;
import java.util.Vector;

/**
 * Created by tianxi on 3/25/17.
 */
public class SOn extends Dad {
    private String name = "son";
    public static void main(String[] a){
//        SOn son = new SOn();
//        System.out.println(son.get());
//        System.out.println();
//
//        Class
        System.out.println(get(0));
        System.out.println(get(1));
        System.out.println(get(2));
        System.out.println(get(3));
        System.out.println( 3*0.1 ==3);
    }
    public static int get(int n){
        try{
            int result = 2 / n;
            return result;
        }catch (Exception e){
            return 0;
        }finally {
            if(n ==0){
                return -1;
            }
            if(n ==1){
                return 1;
            }
        }
    }

    public void get2(){


    }

}
class Dad {
    private String name = "f";
    public String get1(){
        return name;
    }
}