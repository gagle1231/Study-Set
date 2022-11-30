package controller.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.StudyGroup;
import model.TimeSlot;
import model.service.ChartManager;

public class AddChartController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		StudyGroup studyGroup = (StudyGroup) session.getAttribute("studyGroup");
		Member member = (Member) session.getAttribute("loginmember");
		ChartManager manager = ChartManager.getInstance();
		List<TimeSlot> userTimeSlotList =  manager.getUserChar(studyGroup.getGroupId(), member.getUserId());
		
		int[][] chart = new int[24][7];
		
		for(TimeSlot t: userTimeSlotList) {
			for(int i = t.getStartTime(); i<=t.getEndTime(); i++)
				chart[i][t.getDay()] += 1;
		}
		
		request.setAttribute("chart", chart);
		//request.setAttribute("userTimeSlotList", userTimeSlotList);
		return "/group/schedule/addChart.jsp";
	}

}
