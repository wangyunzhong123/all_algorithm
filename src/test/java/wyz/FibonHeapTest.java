package wyz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 8/2/16.
 */

/*
* 斐波那契堆，抽取和删除操作时间复杂度是lgn，其余均为常数时间
* 用在这两个操作相比其他操作较少的场景下。但算法编程过于复杂，导致其更多的是作为研究
* */
public class FibonHeapTest {

    FibonHeap<Integer> fibonHeap;

    @Before
    public void setUp() throws Exception {
        fibonHeap = new FibonHeap<Integer>(100);
    }

    @After
    public void tearDown() throws Exception {

    }

//    @Test
    public void testInsert() throws Exception {//ok
        System.out.println("测试插入");
        fibonHeap.insert(35);
        fibonHeap.insert(23);
        fibonHeap.insert(2);
        fibonHeap.insert(72);
        fibonHeap.insert(15);
        fibonHeap.MiniMun();
    }

//    @Test
    public void testDeleteMin() throws Exception {//ok
        FibonHeap<Integer> fibonHeap = new FibonHeap<Integer>(18);
        System.out.println("测试删除最小值");
        fibonHeap.insert(35);
        fibonHeap.insert(20);
        fibonHeap.insert(42);
        fibonHeap.insert(9);
        fibonHeap.insert(31);
        fibonHeap.insert(23);
        fibonHeap.insert(6);
        fibonHeap.insert(48);
        fibonHeap.insert(11);
        fibonHeap.insert(24);
        fibonHeap.insert(52);
        fibonHeap.insert(13);
        fibonHeap.insert(2);
        fibonHeap.MiniMun();
        fibonHeap.deleteMin();
        fibonHeap.MiniMun();
        fibonHeap.deleteMin();
        fibonHeap.MiniMun();
        fibonHeap.deleteMin();
        fibonHeap.MiniMun();
        fibonHeap.deleteMin();
        fibonHeap.MiniMun();
        fibonHeap.deleteMin();
        fibonHeap.MiniMun();
        fibonHeap.deleteMin();
        fibonHeap.MiniMun();
        fibonHeap.deleteMin();
        fibonHeap.MiniMun();
        fibonHeap.deleteMin();
        fibonHeap.MiniMun();
    }

    @Test
    public void testDeleteNode() throws Exception {
        System.out.println("测试删除节点");
        fibonHeap.insert(2);
        fibonHeap.insert(72);
        fibonHeap.insert(15);
        fibonHeap.insert(9);
        fibonHeap.insert(31);
        fibonHeap.insert(23);
        fibonHeap.insert(6);
        fibonHeap.insert(48);
        fibonHeap.MiniMun();
        FibonNode<Integer> node = new FibonNode<Integer>(6);
        fibonHeap.deleteNode(node);
        fibonHeap.MiniMun();
        node = new FibonNode<Integer>(2);
        fibonHeap.deleteNode(node);
        fibonHeap.MiniMun();
        node = new FibonNode<Integer>(15);
        fibonHeap.deleteNode(node);
        fibonHeap.MiniMun();
        node = new FibonNode<Integer>(9);
        fibonHeap.deleteNode(node);
        fibonHeap.MiniMun();
        node = new FibonNode<Integer>(31);
        fibonHeap.deleteNode(node);
        fibonHeap.MiniMun();
        node = new FibonNode<Integer>(23);
        fibonHeap.deleteNode(node);
        fibonHeap.MiniMun();
    }

//    @Test
    public void testUnion() throws Exception {//ok
        System.out.println("测试合并堆");
        FibonHeap<Integer> fibonHeap1 = new FibonHeap<Integer>(78);
        fibonHeap1.insert(1);
        fibonHeap1.insert(8);
        fibonHeap1.insert(9);
        fibonHeap1.insert(4);
        FibonHeap<Integer> result =fibonHeap.union(fibonHeap,fibonHeap1);
        result.MiniMun();
    }

//    @Test
    public void testDecrease() throws Exception {//ok
        System.out.println("测试减小key值");
        fibonHeap.insert(9);
        FibonNode<Integer> node = new FibonNode<Integer>(100);
        fibonHeap.decrease(node,20);
        fibonHeap.MiniMun();
    }
}