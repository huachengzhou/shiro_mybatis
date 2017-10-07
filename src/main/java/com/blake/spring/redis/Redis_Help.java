package com.blake.spring.redis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Redis_Help {
    // session 在redis过期时间是30分钟30*60
    private static int expireTime = 1800;
    // 计数器的过期时间默认2天
    private static int countExpireTime = 2*24*3600; 
    
	@Autowired
	private JedisPool jedisPool;

	/** 回收redis连接 */
	public void recycleJedis(Jedis jedis) {
		if (jedis != null) {
			try {
				jedis.close();
			} catch (Exception e) {
				System.err.println("异常:"+e.getMessage());
			}
		}
	}

	/**保存字符串数据*/
	public void setString(String key, String value) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				jedis.set(key, value);
			} catch (Exception e) {
				System.err.println("异常:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}

	}

	/** 获取连接 */
	private Jedis getJedis() {
		Jedis jedis = jedisPool.getResource();
		return jedis;
	}

	/**获取字符串类型的数据*/
	public String getString(String key) {
		Jedis jedis = getJedis();
		String result = "";
		if (jedis != null) {
			try {
				result = jedis.get(key);
			} catch (Exception e) {
				System.err.println("异常:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}

		return result;
	}

	/**删除字符串数据*/
	public void delString(String key) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				jedis.del(key);
			} catch (Exception e) {
				System.err.println("异常:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
	}

	/**保存byte类型数据*/
	public void setObject(byte[] key, byte[] value) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				if (!jedis.exists(key)) {
					jedis.set(key, value);
				}
				jedis.expire(key, expireTime);
			} catch (Exception e) {
				System.err.println("异常:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
	}

	/**获取byte类型数据*/
	public byte[] getObject(byte[] key) {
		Jedis jedis = getJedis();
		byte[] bytes = null;
		if (jedis != null) {
			try {
				bytes = jedis.get(key);
				;
			} catch (Exception e) {
				System.err.println("异常:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
		return bytes;

	}

	/**更新byte类型的数据，主要更新过期时间*/
	public void updateObject(byte[] key) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				// redis中session过期时间
				jedis.expire(key, expireTime);
			} catch (Exception e) {
				System.err.println("异常:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}

	}

	/**key对应的整数value加1  */
	public void inc(String key) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				if (!jedis.exists(key)) {
					jedis.set(key, "1");
					jedis.expire(key, countExpireTime);
				} else {
					// 加1
					jedis.incr(key);
				}
			} catch (Exception e) {
				System.err.println("异常:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
	}

	/**获取所有keys*/
	public Set<String> getAllKeys(String pattern) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				return jedis.keys(pattern);
			} catch (Exception e) {
				System.err.println("异常:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
		return null;
	}
}
