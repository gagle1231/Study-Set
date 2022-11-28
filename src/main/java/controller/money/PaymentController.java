package controller.money;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Payment;
import model.StudyGroup;
import model.service.MoneyManager;
import model.service.GroupManager;

public class PaymentController implements Controller{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      HttpSession session = request.getSession();
      MoneyManager manager = MoneyManager.getInstance();
      GroupManager groupManager = GroupManager.getInstance();
      StudyGroup studyGroup = groupManager.getGroup(request.getParameter("groupName"));
      List<Payment> paymentList = manager.getPaymentList(request.getParameter("groupId"));
      session.setAttribute("studyGroup", studyGroup);
      request.setAttribute("paymentList", paymentList);
      
      return "redirect:/group/money/payment";
   }
   
   public void addPayment(Payment payment) throws SQLException, ParseException {
      MoneyManager manager = MoneyManager.getInstance();
      manager.addPayment(payment);
   }

}