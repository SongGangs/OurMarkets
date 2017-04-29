/**
 * 
 */
package ourmarket.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ourmarket.componet.IMessageUtility;

/**
 * Title:MessageUtilityImplTest
 * 
 * Description:
 * 
 * @author SGang
 * @date 2017年4月29日下午11:17:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MessageUtilityImplTest {

	@Autowired
	private IMessageUtility messageUtility;

	@Test
	public void testCheckPhoneNumberIsExist() {
		String phoneNumber = "18980741420";
		assertTrue(messageUtility.CheckPhoneNumberIsExist(phoneNumber));
		phoneNumber = "14568245621";
		assertFalse(messageUtility.CheckPhoneNumberIsExist(phoneNumber));
		phoneNumber = "1456824562";
		assertFalse(messageUtility.CheckPhoneNumberIsExist(phoneNumber));
	}

	@Test
	public void testSendSecurityCode() {
		String phoneNumber = "18980741420";
		assertNotNull(messageUtility.SendSecurityCode(phoneNumber));
		phoneNumber = "15984872339";
		assertNotNull(messageUtility.SendSecurityCode(phoneNumber));
		phoneNumber = "1898074142";
		assertNull(messageUtility.SendSecurityCode(phoneNumber));
	}

}