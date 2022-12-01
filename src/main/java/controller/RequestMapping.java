package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.*;
import controller.group.GroupController;
import controller.group.GroupMemberController;
import controller.group.ViewGroupController;
import controller.user.LoginController;
import controller.user.RegisterUserController;
import controller.money.*;
import controller.schedule.AddChartController;
import controller.schedule.ChartController;
import controller.schedule.ScheduleController;
import controller.schedule.ViewScheduleController;
import controller.task.*;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	// 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
	private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {

		// 각 uri에 대응되는 controller 객체를 생성 및 저장
		mappings.put("/", new ForwardController("index.jsp"));
		mappings.put("/main", new ForwardController("/user/login.jsp"));
		mappings.put("/user/join/form", new ForwardController("/user/join.jsp"));
		mappings.put("/user/login", new LoginController());
		mappings.put("/user/group/list", new ViewGroupController());
		mappings.put("/user/main", new ForwardController("/user/main.jsp"));
		mappings.put("/user/register", new RegisterUserController());

		// 그룹
		mappings.put("/group", new GroupController());
		mappings.put("/group/register", new GroupController());
		mappings.put("/group/main", new ForwardController("/group/main.jsp"));
		mappings.put("/group/member", new GroupMemberController());

		// 스캐줄
		mappings.put("/schedule/chart", new ChartController());
		mappings.put("/schedule/addchart", new AddChartController());
		mappings.put("/schedule/calendar", new ViewScheduleController());
		// mappings.put("/schedule/calendar/detail", new
		// ForwardController("/group/schedule/scheduleForm.jsp"));
		mappings.put("/schedule/calendar/detail", new ScheduleController());

		// 과제
		mappings.put("/group/task/main", new ViewTaskController());
		mappings.put("/group/task/form", new TaskController());
		mappings.put("/group/task/detail", new TaskDetailController());
		mappings.put("/group/task/view", new SubmitController());
		mappings.put("/group/task/submit", new ForwardController("/group/task/submit.jsp"));

		// 회비
		mappings.put("/group/money/dues", new DuesController());
		mappings.put("/group/money/payment", new PaymentController());
		mappings.put("/group/money/addPayment", new PaymentController());
		mappings.put("/group/money/addDues", new DuesController());
	}

	public Controller findController(String uri) {
		return mappings.get(uri);
	}
}