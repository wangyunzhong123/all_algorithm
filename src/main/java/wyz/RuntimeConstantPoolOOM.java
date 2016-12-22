package wyz;

/**
 * Created by tianxi on 12/22/16.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args){

//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);


        //案例一：声明对象中含直接定义的字符串
        String str1=new StringBuffer("计算机").append("软件").toString();
        String str2=new StringBuffer("计算机软件").toString();
        String str3=new StringBuffer("计算机软件").append("").toString();
        String str4=new StringBuffer().append("计算").append("机软件").toString();
        String str5=new StringBuffer().append("计算机").append("软件").toString();
        String str6="计算机软件";

        System.out.println("str1.intern()==str6\t"+(str1.intern()==str6));
        System.out.println("str2.intern()==str6\t"+(str2.intern()==str6));
        System.out.println("str3.intern()==str6\t"+(str3.intern()==str6));
        System.out.println("str4.intern()==str6\t"+(str4.intern()==str6));
        System.out.println("str5.intern()==str6\t"+(str5.intern()==str6));
        System.out.println("str6.intern()==str6\t"+(str6.intern()==str6));
        /*
        * 分析：当字符串中有直接字符串常量“计算机软件”，且赋值给str6，所以str6直接引用常量池对象，
        * 即str6.intern()=str6，其他字符串的intern方法也对应常量池中str6对象。
        * */





        //案例二：声明对象中不含直接定义的字符串，但是通过StringBuffer对象经过两次以上append方法生成
        String str7=new StringBuffer().append("计算").append("机网络").toString();
        String str8=new StringBuffer().append("计算机").append("网络").toString();
        String str9=new StringBuffer("计").append("算机网络").toString();

        System.out.println("str7.intern()==str7"+(str7.intern()==str7));
        System.out.println("str8.intern()==str7"+(str8.intern()==str7));
        System.out.println("str9.intern()==str7"+(str9.intern()==str7));
        System.out.println("str8.intern()==str8"+(str8.intern()==str8));
        System.out.println("str9.intern()==str9"+(str9.intern()==str9));
        /*
        * 分析：当字符串中没有完整的最终字符串（“计算机网络”），且每个字符串均由两个（及其以上的）
        * 小的字符串拼接而成，则第一个生成的字符串和常量池中的字符串相同，谁先生成则将常量池中字符串赋值给谁
        * （此处为str7）。若上述字符串.intern()和str8或者str9比较，则结果为false。
        * */



        //案例三：声明对象中不含有直接定义的字符串，但是有通过一次StringBuffer对象生成的字符串
        String str11=new StringBuffer("计算机").append("软件").toString();
        String str12=new StringBuffer("计算机软件").toString();
//        String str3=new StringBuffer("计算机软件").append("").toString();
        String str14=new StringBuffer().append("计算").append("机软件").toString();
        String str15=new StringBuffer().append("计算机").append("软件").toString();

        System.out.println("str11.intern()==str12\t"+(str11.intern()==str12));
        System.out.println("str12.intern()==str12\t"+(str12.intern()==str12));
//        System.out.println("str3.intern()==str3\t"+(str3.intern()==str3));
        System.out.println("str14.intern()==str12\t"+(str14.intern()==str12));
        System.out.println("str15.intern()==str12\t"+(str15.intern()==str12));
        /*
        * 分析：当字符串中有通过StringBuffer一次生成的String对象，则不会将字符串常量付给任何字符串对象。
        * 同样如果字符串str2注销，换成str3，结果依然为false。
        * */



        /*
        * 总结：

        字符串对象通过字面值直接生成时则直接对应常量池对象。
        如果每个字符串都是通过两个及其以上的小的字符串通过StringBuffer对象拼接而成，
        并且没有全由字面值生成的字符串对象，则第一个生成的字符串对应常量池中的该字符串对象。
        如果生成的字符串对象中有由一个完整字符串或者一个完整字符串拼接空串通过StringBuffer对象生成，
        并且没有全由字面值生成的字符串对象，则所有的字符串对象均不对应常量池中的对象
        * */
    }
}
