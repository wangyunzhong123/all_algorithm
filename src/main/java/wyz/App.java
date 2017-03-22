package wyz;

/**
 * Hello world!
 *
 */

class base{
    public static void fun1(){
        System.out.println("xxx");
    }
    public void fun2(){

    }
}
public class App extends base
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        fun1();
        base.fun1();
    }

    public void sayHello(){
        System.out.println( "Hello World!!" );

        fun2();
        Thread.interrupted();
    }
}
