package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class AuthService {
	
	private Session session;
	
	private AuthService(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}
	
	public void Test()
	{
		Query query = session.createQuery(
		        "select count(*) from Category");
		Long count = (Long)query.uniqueResult();
		System.out.println("---count---"+count);
	}
	
}
