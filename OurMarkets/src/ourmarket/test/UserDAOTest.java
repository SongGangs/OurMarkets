package ourmarket.test;

import static org.junit.Assert.fail;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ourmarket.daos.UserDAO;
import ourmarket.models.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDAOTest {
	@Autowired
	private UserDAO userDao=null;
	@Test
	public void testFindAll() {
		@SuppressWarnings("unchecked")
		List<User> users=userDao.findAll();
		assertNotNull(users);
	}

}
