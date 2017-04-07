package wyz;

import java.util.LinkedList;

/**
 * Created by tianxi on 3/1/17.
 */
public class Test {

    public static Test t1 = new Test();
    {
        System.out.println("A");

    }
    static{
        System.out.println("B");
    }
    String aa,bb;
    public  void method(String cc,String dd){
        System.out.println("B");
    }
    static char a ;
    public void Test(){
        a ='1';
    }
    public static void main(String[] args) {
        LinkedList list = null;

        String b = "张";
        System.out.print(a);
        System.out.print(b);
//        int[] a = { 1,3,5,10,2,7,11,3,6,12,1,8 };
//        int i=0;
//        int j=a.length-1;
//        int b = a[i];
//        int c = a[j];
//        int[] res=new int[3];
//        int cou = 0;
//        while(i<j){
//            if (b == c) {
//                i++;
//                j--;
//                while (a[i] == a[j]&&i<j) {
//                    i++;
//                    j--;
//                }
//                if (i < j)
//                {
//                    res[cou++] = a[i];
//                    res[cou++] = a[j];
//                }
//                else
//                {
//                    res[cou++] = a[i];
//                    break;
//                }
//                i++;
//                j--;
//                b=a[i];
//                c=a[j];
//            }
//            else if (b > c)
//            {
//                j--;
//                c += a[j];
//            }
//            else {
//                i++;
//                b += a[i];
//            }
//        }
//
//        System.out.println(res[0]+" "+res[1]+" "+res[2]);

//        String to = "Hello World";
//        System.out.println(to.indexOf("l",3));


        Test t2 = new Test();
        String str1 = "hello";
        String str2 = "he"+new String("llo");
        System.err.println(str1 == str2);

        int num1 =1;
        int num2 = 2;

    }
}
