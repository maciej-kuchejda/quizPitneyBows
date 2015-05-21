package com.kuchejda.maciej.repozitorys;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kuchejda.maciej.model.SalesFigures;
import com.kuchejda.maciej.repozitory.interfaces.SalesRezpotizory;
import com.kuchejda.maciej.viewModel.FilterViewModel;

/*
 * Class used to operation's on Person entity
 * @author Maciej Kuchejda
 */
public class SalesRepozitory implements SalesRezpotizory {
	private Session _session;
    public void setSessionFactory(SessionFactory sessionFactory) {
        _session = sessionFactory.openSession();
    }

    /*
     * Database query, where List of SalesFigures has been found by userId and filters
     * @param id User id
     * @param filters filter's
     * @return List of SalesFigures
     * @author Maciej Kuchejda
    */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<SalesFigures> findSalesFiguresByUserId(int id,FilterViewModel filters) {
		int first = filters.getItemsPerPage() * (filters.getCurrentPage()-1);
		if(filters.getStartDate().equals(filters.getEndDate()))
		{
			Date date = filters.getEndDate();
			date.setHours(filters.getEndDate().getHours() + 1);
			filters.setEndDate(date);
		}
		Query query = _session.createQuery("FROM SalesFigures WHERE person.id = :id "
				+ "AND saleDate BETWEEN :startDate AND :endDate")
				.setFirstResult(first)
				.setMaxResults(filters.getItemsPerPage());
		query.setParameter("id", id);
		query.setParameter("startDate", filters.getStartDate());
		query.setParameter("endDate", filters.getEndDate());
		List<SalesFigures> sales = query.list();
		return sales;
	}
	
	/*
     * Database query, return count of Sales by filters and user Id
     * @param id User id
     * @param filters filter's
     * @return Long: count of Sales
     * @author Maciej Kuchejda
    */
	public Long findCountSalesByUserIdAndFilterViewModel(int id, FilterViewModel filters) {
		if(filters != null && id != 0)
		{
			String sql = "SELECT count(*) FROM SalesFigures WHERE person.id = :id AND saleDate BETWEEN :startDate AND :endDate";
			Query query = _session.createQuery(sql);
			query.setParameter("id", id);
			query.setParameter("startDate", filters.getStartDate());
			query.setParameter("endDate", filters.getEndDate());
			Object obj = query.uniqueResult();
			return Long.parseLong(obj.toString());
		}
		return 0l;
	}
	/*
     * Database query, return Sum of Sales by filters and user Id
     * @param id User id
     * @param filters filter's
     * @return Long: sum of Sales
     * @author Maciej Kuchejda
    */
	public Long findSumSalesByUserIdAndFilterViewModel(int id, FilterViewModel filters) {
		if(filters != null && id != 0)
		{
			String sql = "SELECT sum(amount) FROM SalesFigures WHERE person.id = :id AND saleDate BETWEEN :startDate AND :endDate";
			Query query = _session.createQuery(sql);
			query.setParameter("id", id);
			query.setParameter("startDate", filters.getStartDate());
			query.setParameter("endDate", filters.getEndDate());
			Object obj = query.uniqueResult();
			if(obj != null)
			{
				Double value = Double.parseDouble(obj.toString());
				return Math.round(value);
			}
		}
		return 0l;
	}
	
}
