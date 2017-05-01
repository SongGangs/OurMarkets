package ourmarket.encache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;

/**
 * Title:EncacheConfig
 *
 * Description:Encache的配置文件
 * 
 * @author SGang
 * @date 2017年5月1日下午1:57:40
 */

@Configuration
@EnableCaching
public class EncacheConfig {

	@Bean
	public EhCacheCacheManager cacheManager(CacheManager cm) {
		return new EhCacheCacheManager(cm);
	}

	@Bean
	public EhCacheManagerFactoryBean ehcache() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ourmarket/encache/ehcache.xml"));
		return ehCacheManagerFactoryBean;
	}
}
