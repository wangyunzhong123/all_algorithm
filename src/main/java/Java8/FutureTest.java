package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by yzwang on 2019/6/23.
 */
public class FutureTest {

    private static final ExecutorService exec= Executors.newCachedThreadPool();


    public static void main(String[] args) throws InterruptedException {
        Callable<String> c1 = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"::正在执行计算");
                return "AA";
            }
        };
        Callable<String> c2 = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"::正在执行计算");
                Thread.sleep(3000);
                return "BB";
            }
        };
        Callable<String> c3 = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"::正在执行计算");
                Thread.sleep(1000);
                return "CC";
            }
        };

        List<Callable<String>> list = new ArrayList<Callable<String>>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        List<Future<String>> futures = exec.invokeAll(list, 2000, TimeUnit.MILLISECONDS); //阻塞方法，当所有任务执行完毕，中断或超时时返回。

        for(Future<String> future:futures){
            try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                System.out.println("异常");
            } catch (CancellationException e) {
                System.out.println("超时");
            }
        }

        exec.shutdown();
    }
}
