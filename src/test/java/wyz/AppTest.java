package wyz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 7/29/16.
 */
public class AppTest {

    private App app;
    @Before
    public void setUp() throws Exception {
        app = new App();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMain() throws Exception {
        app.main(null);
    }

    @Test
    public void testSayHello() throws Exception {
        app.sayHello();
    }

}