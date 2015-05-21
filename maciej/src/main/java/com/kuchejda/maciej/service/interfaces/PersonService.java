package com.kuchejda.maciej.service.interfaces;

import com.kuchejda.maciej.model.Person;
import com.kuchejda.maciej.viewModel.PersonViewModel;

public interface PersonService {
	public PersonViewModel fromPersonDBToPersonViewModel(Person person);
	public Person getPersonByLogin(String login);
}
