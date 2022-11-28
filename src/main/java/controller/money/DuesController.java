package controller.money;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.StudyGroup;
import model.Dues;
import model.service.GroupManager;
import model.service.MoneyManager;

public class DuesController implements Controller{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      HttpSession session = request.getSession();
      MoneyManager manager = MoneyManager.getInstance();
      GroupManager groupManager = GroupManager.getInstance();
      StudyGroup studyGroup = groupManager.getGroup(request.getParameter("groupName"));
      List<Dues> duesList = manager.getDuesList(request.getParameter("groupId"));
      session.setAttribute("studyGroup", studyGroup);
      request.setAttribute("duesList", duesList);
      return "redirect:/group/money/dues";
   }
   public void addDues(Dues dues) throws SQLException, ParseException {
      MoneyManager manager = MoneyManager.getInstance();
      manager.addDues(dues);
   }

}