package Zookeeper.lock;

/**
 * Created by yzwang on 2019/10/4.
 */
public interface Locker {
    void lock(String key, Runnable command);
}
