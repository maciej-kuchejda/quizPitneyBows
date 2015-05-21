package com.kuchejda.maciej.viewModel;

import java.util.List;

public class SalesDescriptionViewModel {
	private List<SalesFiguresViewModel> sales;
	private double totalAmountInRow;
	private double totalAmount;
	private double countOfSales;
	public double getCountOfSales() {
		return countOfSales;
	}
	public void setCountOfSales(double countOfSales) {
		this.countOfSales = countOfSales;
	}
	public List<SalesFiguresViewModel> getSales() {
		return sales;
	}
	public void setSales(List<SalesFiguresViewModel> sales) {
		this.sales = sales;
	}
	public double getTotalAmountInRow() {
		return totalAmountInRow;
	}
	public void setTotalAmountInRow(double totalAmountInRow) {
		this.totalAmountInRow = totalAmountInRow;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
