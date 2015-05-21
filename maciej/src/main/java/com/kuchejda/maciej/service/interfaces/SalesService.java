package com.kuchejda.maciej.service.interfaces;

import java.util.List;

import com.kuchejda.maciej.model.SalesFigures;
import com.kuchejda.maciej.viewModel.FilterViewModel;
import com.kuchejda.maciej.viewModel.SalesDescriptionViewModel;
import com.kuchejda.maciej.viewModel.SalesFiguresViewModel;

public interface SalesService {
	public List<SalesFigures> getSalesFiguresByUserId(int id,FilterViewModel filters);
	public List<Long> getPropertiesForSalesViewModel(int id,FilterViewModel filters);
	public List<SalesFiguresViewModel> fromSalesFiguresListToSaleFiguresViewModelList(List<SalesFigures> modeldb);
	public SalesDescriptionViewModel fromSalesViewModelAndAmountsToSalesDescriptionViewModel(List<SalesFiguresViewModel> sales, List<Long> amounts);
}
