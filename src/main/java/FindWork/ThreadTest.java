package FindWork;

/**
 * Created by yzwang on 2019/3/25.
 */
public class ThreadTest {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final ThreadTest test = new ThreadTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

//        while(Thread.activeCount()>0)  //保证前面的线程都执行完
//            Thread.yield();
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
        System.out.println(test.inc);

        Thread thread = new Thread(() -> System.out.println("In another thread"));
    }

}
