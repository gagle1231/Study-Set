package model;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import model.dao.ScheduleDAO;

public class ScheduleTest {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		ScheduleDAO dao = new ScheduleDAO();

		dao.create(new Schedule("s0000", "1", "임시테스트", "20011231", null, null, null, "d", 'Y'));
//		ArrayList<Schedule> s = (ArrayList)dao.getList("1");

//		System.out.println(s.get(0).getScheduleId());
	}
	//
}
