/**
 * 
 */
package ourmarket.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ourmarket.daos.UserDAO;
import ourmarket.models.User;
import ourmarket.services.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest {
	@Autowired
	IUserService userservice;
	@Autowired
	UserDAO userdao;

	@Test
	public void testCheckuNickNameIsExist() {
		assertTrue(userservice.CheckuNickNameIsExist("宋刚"));
		assertFalse(userservice.CheckuNickNameIsExist("宋刚2"));
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setImageListId(1);
		user.setRid(1);
		user.setUnickName("测试");
		user.setUphone("18281714844");
		user.setUpassword("123456a");
		// assertEquals(userservice.AddUser(user), (User)
		// userdao.findByUnickName("测试").get(0));
		assertEquals(userservice.AddUser(user), null);
	}

	@Test
	public void testIdentifyLoginInfo() {
		assertTrue(userservice.IdentifyLoginInfo("宋刚", "sg123456").getUid() == 2);
		assertNull(userservice.IdentifyLoginInfo("宋刚", "sg1234567"));

	}

}
