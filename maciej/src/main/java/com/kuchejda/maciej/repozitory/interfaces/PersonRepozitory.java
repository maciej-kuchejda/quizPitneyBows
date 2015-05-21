package com.kuchejda.maciej.repozitory.interfaces;

import com.kuchejda.maciej.model.Person;

public interface PersonRepozitory {
	public Person findPersonByLogin(String login);
}
