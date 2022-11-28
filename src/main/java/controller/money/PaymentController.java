package controller.money;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.StudyGroup;
import model.Payment;
import model.service.MoneyManager;

public class PaymentController implements Controller{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      if (request.getMethod().equals("POST")) {
    	  HttpSession session = request.getSession();
    	  StudyGroup group = (StudyGroup) session.getAttribute("studygroup");
    	  request.setCharacterEncoding("utf-8");
    	  Payment payment = new Payment(
    			  group.getGroupId(),
    			  request.getParameter("paymentDate"),
    			  Integer.parseInt(request.getParameter("price")),
    			  request.getParameter("description"),
    			  null
    			  );
    	  try {
    		  session = request.getSession();
    		  MoneyManager manager = MoneyManager.getInstance();
    		  manager.addPayment(payment);
    		  
    		  return "redirect:/group/money/payment";
	      }catch (SQLException se) {
	    	  se.printStackTrace();
	    	  return "/group/money/payment";
	      }catch (Exception e) {
	          e.printStackTrace();
	          return "/group/money/payment";
	      }
      }
	  HttpSession session = request.getSession();
      MoneyManager manager = MoneyManager.getInstance();
      StudyGroup group = (StudyGroup) session.getAttribute("studygroup");
      List<Payment> paymentList = manager.getPaymentList(group.getGroupId());
      session.setAttribute("studyGroup", group);
      request.setAttribute("paymentList", paymentList);
      return "/group/money/payment";
   }

}