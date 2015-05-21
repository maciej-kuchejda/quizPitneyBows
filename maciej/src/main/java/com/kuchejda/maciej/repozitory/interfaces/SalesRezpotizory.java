package com.kuchejda.maciej.repozitory.interfaces;

import java.util.List;

import com.kuchejda.maciej.model.SalesFigures;
import com.kuchejda.maciej.viewModel.FilterViewModel;

public interface SalesRezpotizory {
	public List<SalesFigures> findSalesFiguresByUserId(int id,FilterViewModel filters);
	public Long findCountSalesByUserIdAndFilterViewModel(int id,FilterViewModel filters);
	public Long findSumSalesByUserIdAndFilterViewModel(int id,FilterViewModel filters);
}
