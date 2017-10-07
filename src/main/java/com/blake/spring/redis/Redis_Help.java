package com.blake.spring.redis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Redis_Help {
    // session ��redis����ʱ����30����30*60
    private static int expireTime = 1800;
    // �������Ĺ���ʱ��Ĭ��2��
    private static int countExpireTime = 2*24*3600; 
    
	@Autowired
	private JedisPool jedisPool;

	/** ����redis���� */
	public void recycleJedis(Jedis jedis) {
		if (jedis != null) {
			try {
				jedis.close();
			} catch (Exception e) {
				System.err.println("�쳣:"+e.getMessage());
			}
		}
	}

	/**�����ַ�������*/
	public void setString(String key, String value) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				jedis.set(key, value);
			} catch (Exception e) {
				System.err.println("�쳣:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}

	}

	/** ��ȡ���� */
	private Jedis getJedis() {
		Jedis jedis = jedisPool.getResource();
		return jedis;
	}

	/**��ȡ�ַ������͵�����*/
	public String getString(String key) {
		Jedis jedis = getJedis();
		String result = "";
		if (jedis != null) {
			try {
				result = jedis.get(key);
			} catch (Exception e) {
				System.err.println("�쳣:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}

		return result;
	}

	/**ɾ���ַ�������*/
	public void delString(String key) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				jedis.del(key);
			} catch (Exception e) {
				System.err.println("�쳣:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
	}

	/**����byte��������*/
	public void setObject(byte[] key, byte[] value) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				if (!jedis.exists(key)) {
					jedis.set(key, value);
				}
				jedis.expire(key, expireTime);
			} catch (Exception e) {
				System.err.println("�쳣:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
	}

	/**��ȡbyte��������*/
	public byte[] getObject(byte[] key) {
		Jedis jedis = getJedis();
		byte[] bytes = null;
		if (jedis != null) {
			try {
				bytes = jedis.get(key);
				;
			} catch (Exception e) {
				System.err.println("�쳣:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
		return bytes;

	}

	/**����byte���͵����ݣ���Ҫ���¹���ʱ��*/
	public void updateObject(byte[] key) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				// redis��session����ʱ��
				jedis.expire(key, expireTime);
			} catch (Exception e) {
				System.err.println("�쳣:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}

	}

	/**key��Ӧ������value��1  */
	public void inc(String key) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				if (!jedis.exists(key)) {
					jedis.set(key, "1");
					jedis.expire(key, countExpireTime);
				} else {
					// ��1
					jedis.incr(key);
				}
			} catch (Exception e) {
				System.err.println("�쳣:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
	}

	/**��ȡ����keys*/
	public Set<String> getAllKeys(String pattern) {
		Jedis jedis = getJedis();
		if (jedis != null) {
			try {
				return jedis.keys(pattern);
			} catch (Exception e) {
				System.err.println("�쳣:"+e.getMessage());
			} finally {
				recycleJedis(jedis);
			}
		}
		return null;
	}
}
