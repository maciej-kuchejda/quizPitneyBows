package com.kuchejda.maciej.services;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kuchejda.maciej.model.SalesFigures;
import com.kuchejda.maciej.repozitorys.SalesRepozitory;
import com.kuchejda.maciej.viewModel.FilterViewModel;
import com.kuchejda.maciej.viewModel.SalesDescriptionViewModel;
import com.kuchejda.maciej.viewModel.SalesFiguresViewModel;
/*
 * In this Class included all method's for Sales model
 * @author Maciej Kuchejda 
 */
public class SalesService implements com.kuchejda.maciej.service.interfaces.SalesService {
	
	private SalesRepozitory _repozitory;
	
	public SalesService(ClassPathXmlApplicationContext context) {
		_repozitory = context.getBean(SalesRepozitory.class);
	}
	
	

	public List<SalesFiguresViewModel> fromSalesFiguresListToSaleFiguresViewModelList(List<SalesFigures> modeldb) {
		if(modeldb != null)
		{
			List<SalesFiguresViewModel> toReturn = new LinkedList<SalesFiguresViewModel>();
			for (SalesFigures salesFigures : modeldb) {
				SalesFiguresViewModel viewModel = new SalesFiguresViewModel();
				viewModel.setId(salesFigures.getId());
				viewModel.setAmount(salesFigures.getAmount());
				viewModel.setSaleDate(salesFigures.getSaleDate());
				toReturn.add(viewModel);
			}
			return toReturn;
		}
		return null;
	}

	public SalesDescriptionViewModel fromSalesViewModelAndAmountsToSalesDescriptionViewModel(
			List<SalesFiguresViewModel> sales, List<Long> amounts) {
		SalesDescriptionViewModel toReturn = new SalesDescriptionViewModel();
		toReturn.setSales(sales);
		toReturn.setTotalAmount(amounts.get(1));
		toReturn.setCountOfSales(amounts.get(0));
		Double tmp = 0d;
		for (SalesFiguresViewModel salesFiguresViewModel : sales) {
			tmp += salesFiguresViewModel.getAmount();
		}
		toReturn.setTotalAmountInRow(tmp);
		return toReturn;
	}



	public List<SalesFigures> getSalesFiguresByUserId(int id,FilterViewModel filters) {
		if(id != 0 && filters != null){
			return _repozitory.findSalesFiguresByUserId(id, filters);
		}
		return null;
	}



	/*
     * Method who return's properties for SalesViewModel (in future this properties,
     * can be modified) Actually return's:
     *  - Count of Sales
     *  - Sum of Sales Amount
     *  
     *  If someone modified this method must complete this comment.
     *  
     * @param id User id
     * @param filterViewModel filter's
     * @return Properties in List of Long
     * @author Maciej Kuchejda
    */
	@SuppressWarnings("deprecation")
	public List<Long> getPropertiesForSalesViewModel(int id,FilterViewModel filterViewModel) {
		if(filterViewModel != null && id != 0){
			List<Long> result = new LinkedList<Long>();
			if(filterViewModel.getStartDate().equals(filterViewModel.getEndDate()))
			{
				Date date = filterViewModel.getEndDate();
				date.setHours(filterViewModel.getEndDate().getHours() + 1);
				filterViewModel.setEndDate(date);
			}
			result.add(_repozitory.findCountSalesByUserIdAndFilterViewModel(id, filterViewModel));
			result.add(_repozitory.findSumSalesByUserIdAndFilterViewModel(id, filterViewModel));
			return result;
		}
		return null;
	}

}
