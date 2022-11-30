package controller.schedule;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Schedule;
import model.StudyGroup;
import model.service.ScheduleManager;
public class ScheduleController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")) {
			HttpSession session = request.getSession();
			StudyGroup group = (StudyGroup) session.getAttribute("studyGroup");
			String title = request.getParameter("sTitle");
			String date = request.getParameter("sDate");
			String startTime = request.getParameter("statTime");
			String endTime = request.getParameter("endTime");
			String location = request.getParameter("location");
			String description = request.getParameter("description");

			String i = request.getParameter("importance");
			char imp = i==null ? '0' : '1';
			Schedule newSchedule = new Schedule(null, group.getGroupId(), title, date, startTime, endTime, location, description, 'Y');
			
			ScheduleManager manager = ScheduleManager.getInstance();
			try{
				manager.create(newSchedule);
				return "redirect:/schedule/calendar";
			}catch(Exception e) {
				
			}
		}
		
		
		return "/schedule/calendar/detail.jsp";
	}

}
