package controller.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.StudyGroup;
import model.TimeSlot;
import model.service.ChartManager;

public class ChartController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		StudyGroup studyGroup = (StudyGroup) session.getAttribute("studyGroup");
		ChartManager manager = ChartManager.getInstance();
		
		
		
		
		List<TimeSlot> timeSlotList =  manager.getChart(studyGroup.getGroupId());
		
		int[][] chart = new int[24][7];
		
		for(TimeSlot t: timeSlotList) {
			for(int i = t.getStartTime(); i<=t.getEndTime(); i++)
				chart[i][t.getDay()] += 1;
		}
		
		request.setAttribute("chart", chart);
		request.setAttribute("timeSlotList", timeSlotList);
		return "/group/schedule/chart.jsp";
	}

}
