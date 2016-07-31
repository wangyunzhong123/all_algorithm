package wyz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Data;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 7/30/16.
 */
public class HeapSortTest {

    HeapSort heapSort;
    @Before
    public void setUp() throws Exception {
        heapSort = new HeapSort();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        int a[]={3,6,2,9,4,8,4,1,12,56,34};

        System.out.print("排序前： ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();

        heapSort.execute(a);

        //
        System.out.print("排序后： ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();
        System.out.println();

        System.out.println("测试优先队列");
        int b[]={3,6,2,9,4,8,4,1,12,56,34};
        heapSort.execute2(b);
        heapSort.heap_max(b);
        heapSort.heap_increase_key(b,1,100);
        heapSort.heap_max(b);
        heapSort.heap_extract_max(b);
        heapSort.heap_max(b);

    }
}