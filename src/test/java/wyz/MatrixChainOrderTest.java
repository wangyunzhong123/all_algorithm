package wyz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 7/31/16.
 */
public class MatrixChainOrderTest {

    MatrixChainOrder matrixChainOrder;
    @Before
    public void setUp() throws Exception {
        matrixChainOrder = new MatrixChainOrder();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        int p[]={30,35,15,5,10,20,25};
        matrixChainOrder.execute(p);
        matrixChainOrder.print_optimal_parens(1,6);
    }
}