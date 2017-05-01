/**
 * 
 */
package ourmarket.encache.test;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Title:EncacheTestServiceImpl
 *
 * Description:
 * 
 * @author SGang
 * @date 2017年5月1日下午2:09:01
 */
@Service
public class EncacheTestServiceImpl implements EncacheTestService {

	@Override
	@Cacheable(value = "cacheTest", key = "#param")
	public String getTimestamp(String param) {
		Long timestamp = System.currentTimeMillis();
		return timestamp.toString();
	}

}
