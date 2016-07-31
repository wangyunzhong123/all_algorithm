package wyz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 7/31/16.
 */
public class LCSLengthTest {

    LCSLength lcsLength;
    @Before
    public void setUp() throws Exception {
        lcsLength  = new LCSLength();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        char x[] = {'0','A','B','C','B','D','A','B'};//8
        char y[] = {'0','B','D','C','A','B','A'};//7

        lcsLength.execute(x,y);
        System.out.println("最大公共子序列长度： "+lcsLength.LCS_length(x.length-1,y.length-1));
        System.out.print("最大公共子序列是： ");
        lcsLength.print_LCS(x,x.length-1,y.length-1);
    }
}