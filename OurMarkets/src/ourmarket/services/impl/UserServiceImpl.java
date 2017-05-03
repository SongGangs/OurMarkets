/**
 * 
 */
package ourmarket.services.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import ourmarket.daos.UserDAO;
import ourmarket.models.User;
import ourmarket.services.IUserService;

/**
 * 
 * @Title:UserServiceImp
 * @Description:
 * @author : SGang
 * @date : 2017年4月29日
 */
@Service
public class UserServiceImpl implements IUserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Resource
	private ServletContext servletContext;
	@Autowired
	private UserDAO userdao = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ourmarket.services.IUserService#CheckuNickNameIsExist(java.lang.String)
	 * 检查用户名是否存在
	 */
	@Cacheable(value = "userCache", key = "#uNickName")
	@Override
	public boolean checkuNickNameIsExist(String uNickName) {

		int result = userdao.findByUnickName(uNickName).size();
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#AddUser(ourmarket.models.User) //
	 * 添加用户
	 */
	@CachePut(value = "userCache", key = "#result.getUnickName()", condition = "#result!=null")
	@Override
	public User addUser(User user) {
		if (!checkuNickNameIsExist(user.getUnickName())) {
			return userdao.save(user);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#IdentifyLoginInfo(java.lang.String,
	 * java.lang.String) 检查账号信息是个正确
	 */

	@Override
	public User identifyLoginInfo(String uNickName, String uPassword) {
		if (checkuNickNameIsExist(uNickName)) {
			User user = (User) userdao.findByUnickName(uNickName).get(0);
			if (user.getUpassword().equals(uPassword)) {
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#GetIdByNickName(java.lang.String)
	 * 根据用户名查找ID
	 */
	@Cacheable(value = "userCache", key = "#result", condition = "#result>0")
	@Override
	public int getIdByNickName(String uNickName) {
		if (checkuNickNameIsExist(uNickName)) {
			return ((User) userdao.findByUnickName(uNickName).get(0)).getUid();
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#GetUserByuNickName(java.lang.String)
	 * 
	 * 根据用户名查找用户信息
	 */
	@Override
	public User getUserByuNickName(String uNickName) {
		if (checkuNickNameIsExist(uNickName)) {
			return (User) userdao.findByUnickName(uNickName).get(0);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ourmarket.services.IUserService#getRoleByuNickNameAnduPassword(java.lang.
	 * String, java.lang.String)
	 * 
	 * 更加用户名密码查看角色
	 */
	@Override
	public String getRoleByuNickNameAnduPassword(String uNickName, String uPassword) {
		User user = identifyLoginInfo(uNickName, uPassword);
		if (user != null) {
			return user.getRid() == 0 ? "User" : "Admin";
		}
		return null;
	}

	private Element createUserElement(String userName, String password, String role, Document doc) {
		Element user = doc.createElement("user");
		user.setAttribute("username", userName);
		user.setAttribute("password", password);
		user.setAttribute("role", role);
		return user;
	}

	private boolean write(Source source, Result result) {
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tr;
		try {
			tr = tffactory.newTransformer();
			tr.transform(source, result);
			return true;
		} catch (TransformerConfigurationException e) {
			logger.error(e.getMessage());
			e.printStackTrace();

		} catch (TransformerException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	private Document getDocument(File file) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(file);
		return doc;
	}

	private File getUserXmlFile() {
		String path = servletContext.getRealPath("/WEB-INF/musicstore-users.xml");
		File file = new File(path);
		return file;
	}

}
