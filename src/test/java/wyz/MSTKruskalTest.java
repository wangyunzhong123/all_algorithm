package wyz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 8/1/16.
 */
public class MSTKruskalTest {

    MSTKruskal kr;
    @Before
    public void setUp() throws Exception {
        kr = new MSTKruskal();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testKruskal() throws Exception {
        kr.init();
        kr.kruskal();
    }
}