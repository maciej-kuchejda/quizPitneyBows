package com.kuchejda.maciej.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kuchejda.maciej.model.Person;
import com.kuchejda.maciej.repozitorys.PersonRepozitory;
import com.kuchejda.maciej.viewModel.PersonViewModel;
/*
 * In this Class included all method's for Person model
 * @author Maciej Kuchejda 
 */
public class PersonService implements com.kuchejda.maciej.service.interfaces.PersonService {
	
	private PersonRepozitory _repository;
	
	public PersonService(ClassPathXmlApplicationContext context) {
		_repository = context.getBean(PersonRepozitory.class);
	}
	

	public Person getPersonByLogin(String login) {
		if(login != null){
			return _repository.findPersonByLogin(login);
		}
		return null;
	}
	
	public PersonViewModel fromPersonDBToPersonViewModel(Person person) {
		if(person != null)
		{
			PersonViewModel viewModel = new PersonViewModel();
			viewModel.setFirstName(person.getFirstName());
			viewModel.setLastName(person.getLastName());
			viewModel.setId(person.getId());
			return viewModel;
		}
		return null;
	}
}
