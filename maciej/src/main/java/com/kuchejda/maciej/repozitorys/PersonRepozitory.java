package com.kuchejda.maciej.repozitorys;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kuchejda.maciej.model.Person;

/*
 * Class used to operation's on Person entity
 */
public class PersonRepozitory implements com.kuchejda.maciej.repozitory.interfaces.PersonRepozitory {
	
	private Session _session;
	 
    public void setSessionFactory(SessionFactory sessionFactory) {
        _session = sessionFactory.openSession();
    }
	
    /*
     * Query on database, where user has been search by user login
     * @param login username login
     * @return Person class
     * @author Maciej Kuchejda
     */
	public Person findPersonByLogin(String login) {
		if(login != null)
		{
			Query query = _session.createQuery("from Person where userLogin = :userLogin");
			query.setParameter("userLogin", login);
			Object obj = query.uniqueResult();
			if(obj != null){
				return (Person)obj;
			}
		}
		return null;
	}

}
