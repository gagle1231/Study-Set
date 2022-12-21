package controller.schedule;
import java.util.Date;
import java.util.List;

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
		HttpSession session = request.getSession();
		StudyGroup group = (StudyGroup) session.getAttribute("studyGroup");
		ScheduleManager manager = ScheduleManager.getInstance();
		
		if(request.getMethod().equals("POST")) { //스캐줄 생성
			
			String title = request.getParameter("sTitle");
			String date = request.getParameter("sDate");
			String startTime = request.getParameter("statTime");
			String endTime = request.getParameter("endTime");
			String location = request.getParameter("location");
			String description = request.getParameter("description");

			String i = request.getParameter("importance");
			char imp = i==null ? 'N' : 'Y';
			Schedule newSchedule = new Schedule(null, group.getGroupId(), title, date, startTime, endTime, location, description, imp);
			
			try{
				manager.create(newSchedule);
				return "redirect:/schedule/calendar";
			}catch(Exception e) {
				
			}
		}
		
		
		String sid = (String) request.getAttribute("sid");
		Schedule s = manager.getSchedule(sid);
		request.setAttribute("schedule", s);
        return "/group/schedule/calendar.jsp";	
	}

}
