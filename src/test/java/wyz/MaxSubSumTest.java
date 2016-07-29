package wyz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 7/29/16.
 */
public class MaxSubSumTest {

    MaxSubSum maxSubSum;
    @Before
    public void setUp() throws Exception {
        maxSubSum = new MaxSubSum();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        int a[]={1,2,4,-8,8,4,-1,3};
        maxSubSum.execute(a);
    }
}