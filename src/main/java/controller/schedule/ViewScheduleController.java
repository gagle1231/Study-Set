package controller.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Schedule;
import model.StudyGroup;
import model.service.ScheduleManager;

public class ViewScheduleController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		StudyGroup studyGroup = (StudyGroup) session.getAttribute("studyGroup");
	        
			try {
				ScheduleManager manager = ScheduleManager.getInstance();
				List<Schedule> scheduleList = manager.find(studyGroup.getGroupId());
				request.setAttribute("scheduleList", scheduleList);
		        return "/group/schedule/calendar.jsp";	
		        
			} catch (Exception e) {	
	            e.printStackTrace();
			}
			return null;
	}

}
