package controller.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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


		if(request.getMethod().equals("POST"))  
		{
			manager.deleteUserTimeSlot(studyGroup.getGroupId(), member.getUserId());
			String stringJson = (String) request.getParameter("editTime"); 
			
			JSONObject obj = null;
			JSONParser parser = new JSONParser();
			if(stringJson!=null)
				 obj = (JSONObject) parser.parse(stringJson);
			System.out.println(obj);
			JSONArray list = (JSONArray) obj.get("list");
			
			TimeSlot timeslot = null;
			int day = -1;
			int startTime=-1, endTime=-1;
			int time=-1;
			for(int i=0; i<list.size(); i++) {
				JSONObject timeCell = (JSONObject) list.get(i);
				Long cellDay = (Long) (timeCell.get("day"))-1;
				Long cellTime = (Long) timeCell.get("time")-1;
				time=cellTime.intValue(); //현재 셀의 시간 위치

				System.out.println(day+"/time:" + time+", endTime:" + endTime);
				if(cellDay!=day) //요일이 바뀌는 시점
				{
					if(endTime!=-1) { //이전 요일 셀 저장, 타임 슬롯 생성
						timeslot = new TimeSlot(null, null, day, startTime, endTime, null);
						manager.setTimeSlot(timeslot, member.getUserId(), studyGroup.getGroupId());  
					}
					//요일 전환점
					day =cellDay.intValue();
					startTime=time; 
					endTime=time;
					
				}else if(endTime+1==time){ //이어지는 셀은 하나의 타임슬롯으로 저장
					endTime++;
				}
				else{ //하나의 TimeSlot 구간 끝
					
					timeslot = new TimeSlot(null, null, day, startTime, endTime, null);
					manager.setTimeSlot(timeslot, member.getUserId(), studyGroup.getGroupId());
					System.out.println("타임슬롯 생성"+day+",,"+startTime+",,"+endTime);
					startTime=time;
					endTime=time;
				}
			}
		
			if(startTime!=endTime) {
				timeslot = new TimeSlot(null, null, day, startTime, endTime, null);
				manager.setTimeSlot(timeslot, member.getUserId(), studyGroup.getGroupId());
			}

			return "redirect:/schedule/chart";
		}

		List<TimeSlot> userTimeSlotList =  manager.getUserChar(studyGroup.getGroupId(), member.getUserId());

		int[][] chart = new int[24][7];

		for(TimeSlot t: userTimeSlotList) {
			for(int i = t.getStartTime(); i<=t.getEndTime(); i++)
				chart[i][t.getDay()] += 1;
		}

		request.setAttribute("chart", chart);
		return "/group/schedule/addChart.jsp";
	}

}
