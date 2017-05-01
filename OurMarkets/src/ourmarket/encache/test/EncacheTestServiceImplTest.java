/**
 * 
 */
package ourmarket.encache.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Title:EncacheTestServiceImplTest
 *
 * Description:
 * 
 * @author SGang
 * @date 2017年5月1日下午2:11:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EncacheTestServiceImplTest {

	@Autowired
	private EncacheTestService encacheTestService = null;

	@Test
	public void testGetTimestamp() throws InterruptedException {
		System.out.println("第一次调用：" + encacheTestService.getTimestamp("param"));
		Thread.sleep(2000);
		System.out.println("2秒之后调用：" + encacheTestService.getTimestamp("param"));
		Thread.sleep(11000);
		System.out.println("再过11秒之后调用：" + encacheTestService.getTimestamp("param"));
	}

}
