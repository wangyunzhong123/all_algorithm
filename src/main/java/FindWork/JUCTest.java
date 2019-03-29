package FindWork;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yzwang on 2019/3/25.
 */
public class JUCTest {

    public static void main(String[] args) {

        LinkedHashMap a = new LinkedHashMap();

        CPUTestThread cpuTestThread = new CPUTestThread();
        for (int i = 0; i < 3; i++) {
            Thread cpuTest = new Thread(cpuTestThread);
            cpuTest.start();
        }

        //Windows Task Manager shows
        try {
            Runtime.getRuntime().exec("taskmgr");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

class CPUTestThread implements Runnable {

    @Override
    public void run() {
        int busyTime = 10;
        int idleTime = busyTime;
        long startTime = 0;
        while (true) {
            startTime = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis()+","+startTime+","+(System.currentTimeMillis() - startTime));

            // busy loop
            while ((System.currentTimeMillis() - startTime) <= busyTime)
                ;
            // idle loop
            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

}
