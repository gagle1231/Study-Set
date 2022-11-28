package controller.group;

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
		    	//log.debug("Create Community : {}", comm);
		        return "/group/schedule/calendar.jsp";	// 성공 시 커뮤니티 리스트 화면으로 redirect
		        
			} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
	            request.setAttribute("creationFailed", true);
				request.setAttribute("exception", e);
				//request.setAttribute("comm", comm);
				return "/community/creationForm.jsp";
			}
	}

}
