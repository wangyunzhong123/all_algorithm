package wyz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 7/31/16.
 */
public class Knapsack_0_1_DPTest {

    Knapsack_0_1_DP knapsack_0_1_dp;
    @Before
    public void setUp() throws Exception {
        knapsack_0_1_dp = new Knapsack_0_1_DP();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        int w[]={11,5,4,6,3,1};
        int v[]={100,5000,4000,3000,500,200};
        int W =10;
        knapsack_0_1_dp.execute(v,w,w.length,W);
        knapsack_0_1_dp.print_result(w.length-1,W);
    }
}