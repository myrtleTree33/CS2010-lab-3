import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author A0108165J
 *
 */
public class TopKTest {

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    TopK k = new TopK();
    k.configure(7, 3);
    k.printSalaries();
    System.out.println("TOP SALARIES: " + k.getTopSalaries().toString());
//    fail("Not yet implemented");
  }

}
