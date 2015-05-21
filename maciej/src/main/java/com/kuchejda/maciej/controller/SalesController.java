package com.kuchejda.maciej.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kuchejda.maciej.model.Person;
import com.kuchejda.maciej.model.SalesFigures;
import com.kuchejda.maciej.services.PersonService;
import com.kuchejda.maciej.services.SalesService;
import com.kuchejda.maciej.util.JsonUntil;
import com.kuchejda.maciej.viewModel.FilterViewModel;
import com.kuchejda.maciej.viewModel.PersonViewModel;
import com.kuchejda.maciej.viewModel.SalesDescriptionViewModel;
import com.kuchejda.maciej.viewModel.SalesFiguresViewModel;


@PreAuthorize("hasAnyRole('ROLE_USER')")
@Controller
@RequestMapping("sales")
public class SalesController {
	ClassPathXmlApplicationContext _context;
	SalesService _salesService;
	PersonService _personService;
	JsonUntil _json;
	public SalesController() {
		_context = new ClassPathXmlApplicationContext("spring.xml");
		_personService = new PersonService(_context);
		_salesService = new SalesService(_context);
		_json = new JsonUntil();
	}
	@RequestMapping("/user")  
	public ModelAndView getLoginForm( ) {  
		return new ModelAndView("user");  
	}
	
	@RequestMapping(value = "/userDescription", headers = "Accept=application/json", method = RequestMethod.POST)
	public ResponseEntity<String> getPersonInformation()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		String json = null;
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			Person modelPerson = _personService.getPersonByLogin(username);
			PersonViewModel personViewModel = _personService.fromPersonDBToPersonViewModel(modelPerson);
			json = _json.toJson(personViewModel);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(json,headers,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/userSales", headers = "Accept=application/json", method = RequestMethod.POST)
	public ResponseEntity<String> getSalesByPerson(@RequestBody String payLoad)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if(payLoad == null || payLoad.isEmpty())
		{
			return new ResponseEntity<String>("The payload is empty",headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String json = null;
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			Person modelPerson = _personService.getPersonByLogin(username);
			FilterViewModel filterViewModel = _json.fromJson(payLoad, FilterViewModel.class);
			List<SalesFigures> modelSales = _salesService.getSalesFiguresByUserId(modelPerson.getId(),filterViewModel);
			List<SalesFiguresViewModel> salesViewModel = _salesService.fromSalesFiguresListToSaleFiguresViewModelList(modelSales);
			List<Long> amounts = _salesService.getPropertiesForSalesViewModel(modelPerson.getId(),filterViewModel);
			SalesDescriptionViewModel viewModel = _salesService.fromSalesViewModelAndAmountsToSalesDescriptionViewModel(salesViewModel, amounts);
			json = _json.toJson(viewModel);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(json,headers,HttpStatus.OK);
	}
}
