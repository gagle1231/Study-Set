package model;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import controller.group.GroupController;
import model.dao.ScheduleDAO;
import model.dao.TimeSlotDAO;
import model.service.GroupManager;
import model.service.ScheduleManager;
import model.dao.GroupDAO;
import model.dao.MemoDAO;

public class ScheduleTest {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		ScheduleDAO dao = new ScheduleDAO();

		//dao.create(new Schedule(null, "1", "스캐줄1", "20221231", "2000", null, null, "d", 'Y'));
		ScheduleManager manager = ScheduleManager.getInstance();
		//manager.create(new Schedule(null, "1", "스캐줄2", "20221231", "1000", null, null, "d", 'Y'));
		for(Schedule s: manager.find("1")) {
			System.out.println(s.toString());
		}
		// ArrayList<Schedule> s = (ArrayList)dao.getList("1");

		//System.out.println(s.get(0).getScheduleId());
		
		// 타임슬롯 작성 
		// TimeSlotDAO time = new TimeSlotDAO();
		// time.addTimeSlot(new TimeSlot("t0001", 2, 16, 20), "gagle1231", "1");
		
		// 타임슬롯 가져오기 (그룹아이디)
		// ArrayList<TimeSlot> arr = (ArrayList)time.getTimeSlot("g28");
		// System.out.println(arr.get(0).getUserId() + " " + arr.get(0).getStartTime());
		
		// 타임슬롯 가져오기 (유저아이디&그룹아이디)
		// ArrayList<TimeSlot> arr2 = (ArrayList)time.getUserTimeSlot("1", "gagle1231");
		// System.out.println(arr2.get(0).getUserId() + " " + arr2.get(0).getStartTime());
		
		// 메모 작성
		// MemoDAO dao = new MemoDAO();
		// dao.addMemo(new Memo("m01", "메모ㅋㅋ"), "hyooojing", "g28");
		// dao.addMemo(new Memo("m02", "메모ㅋㅋ"), "gagle1231", "g28");
		// dao.addMemo(new Memo("m03", "메모ㅋㅋ"), "admin", "g28");
		// dao.addMemo(new Memo("m04", "메모ㅋㅋ"), "zzimnii", "g28");
		// dao.addMemo(new Memo("m05", "메모ㅋㅋ"), "hyooojing", "1");
		// dao.addMemo(new Memo("m06", "메모ㅋㅋ"), "gagle1231", "1");
		// dao.addMemo(new Memo("m08", "메모ㅎㅎ"), "hyooojing", "g28");
		
		// 메모리스트 가져오기
		// ArrayList<Memo> arr = (ArrayList)dao.getMemoList("g28", "hyooojing");
		// System.out.println(arr.get(0).getMemoContents() + "\n" + arr.get(1).getMemoContents());
		
		// 메모 가져오기
		// Memo memo = dao.getMemo("m1");
		// System.out.println("m1의 메모내용은 " + memo.getMemoContents());
		StudyGroup s = new StudyGroup(null, "스터디그룹", 1, "임시로 생성한 스터디 그룹", "A3r24");
		 //GroupDAO dao = new GroupDAO();
		 //dao.create(s);
		//GroupManager manager = GroupManager.getInstance();
		//manager.create(s);
	}
}

