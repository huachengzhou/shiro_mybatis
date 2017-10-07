package com.blake.spring.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionRedisDao extends EnterpriseCacheSessionDAO {
//	@Autowired
	Redis_Help redis_Help;

	// ����session�����浽���ݿ�
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = super.doCreate(session);
		redis_Help.setObject(sessionId.toString().getBytes(), sessionToByte(session));

		return sessionId;
	}

	// ��ȡsession
	@Override
	protected Session doReadSession(Serializable sessionId) {
		// �ȴӻ����л�ȡsession�����û����ȥ���ݿ��л�ȡ
		Session session = super.doReadSession(sessionId);
		if (session == null) {
			byte[] bytes = redis_Help.getObject(sessionId.toString().getBytes());
			if (bytes != null && bytes.length > 0) {
				session = byteToSession(bytes);
			}
		}
		return session;
	}

	// ����session�����һ�η���ʱ��
	@Override
	protected void doUpdate(Session session) {
		super.doUpdate(session);
		redis_Help.setObject(session.getId().toString().getBytes(), sessionToByte(session));
	}

	// ɾ��session
	@Override
	protected void doDelete(Session session) {
		super.doDelete(session);
		redis_Help.delString(session.getId() + "");
	}

	// ��session����ת��Ϊbyte���浽redis��
	public byte[] sessionToByte(Session session) {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		byte[] bytes = null;
		try {
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(session);
			bytes = bo.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}

	// ��byte��ԭΪsession
	public Session byteToSession(byte[] bytes) {
		ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
		ObjectInputStream in;
		SimpleSession session = null;
		try {
			in = new ObjectInputStream(bi);
			session = (SimpleSession) in.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return session;
	}
}
