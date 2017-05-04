/**

 * 
 */

package ourmarket.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ourmarket.models.User;
import ourmarket.services.IUserService;

/**
 * Title:CustomUserDetailsService
 *
 * Description:
 * 
 * @author SGang
 * @date 2017年5月2日下午5:14:43
 */
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private IUserService userService = null;

	// 登陆验证时，通过username获取用户的所有权限信息，
	// 并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = userService.getUserByuNickName(arg0);
		System.out.println("User : " + user);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUnickName(), user.getUpassword(), true,
				true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority(
				userService.getRoleByuNickNameAnduPassword(user.getUnickName(), user.getUpassword())));
		System.out.print("authorities :" + authorities);
		return authorities;
	}

}
