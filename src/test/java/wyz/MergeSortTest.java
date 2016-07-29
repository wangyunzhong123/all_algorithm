package wyz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import util.Data;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 7/29/16.
 */
public class MergeSortTest {

    MergeSort mergeSort;
    @Before
    public void setUp() throws Exception {
        mergeSort = new MergeSort();
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

        mergeSort.execute(a,0,a.length-1);

        //
        System.out.print("排序后： ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();
        System.out.println();


        //测试是否稳定
        System.out.println("测试稳定性");
        Data b[]={new Data("0",3),new Data("1",6),new Data("2",9),new Data("3",9),new Data("4",4),new Data("5",8),
                new Data("6",4),new Data("7",1),new Data("8",12),new Data("9",56),new Data("10",34)};

        System.out.println("排序前： ");
        for(int i=0;i<b.length;i++){
            System.out.print(b[i].index+"  ");
        }
        System.out.println();
        for(int i=0;i<b.length;i++){
            System.out.print(b[i].value+"  ");
        }
        System.out.println();

        mergeSort.execute2(b,0,b.length-1);

        System.out.println("排序后： ");
        for(int i=0;i<b.length;i++){
            System.out.print(b[i].index+"  ");
        }
        System.out.println();
        for(int i=0;i<b.length;i++){
            System.out.print(b[i].value+"  ");
        }
        System.out.println();
    }
}