package model.service;

import model.dao.PaymentDAO;
import model.dao.DuesDAO;
import model.Payment;
import model.Dues;
import java.util.List;


public class MoneyManager {
	private static MoneyManager moneyManager = new MoneyManager();
	private PaymentDAO paymentDao;
	private DuesDAO duesDao;
	
	private MoneyManager() {
		try {
			paymentDao = new PaymentDAO();
			duesDao = new DuesDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MoneyManager getInstance() {
		return moneyManager;
	}
	
	public List<Payment> getPaymentList(String gid) {
		return paymentDao.getList(gid);
	}
	
	public List<Dues> getDuesList(String gid) {
		return duesDao.getList(gid);
	}
}
