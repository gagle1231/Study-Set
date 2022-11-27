package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.*;
import controller.group.AddChartController;
import controller.group.ChartController;
import controller.group.GroupController;
import controller.group.GroupMemberController;
import controller.group.ViewGroupController;
import controller.group.ViewScheduleController;
import controller.user.LoginController;

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
        mappings.put("/group", new GroupController());
        mappings.put("/group/register", new GroupController());
        mappings.put("/group/main", new ForwardController("/group/main.jsp"));
        mappings.put("/group/member", new GroupMemberController());
        mappings.put("/schedule/chart", new ChartController());
        mappings.put("/schedule/addchart", new AddChartController());
        mappings.put("/schedule/calendar", new ViewScheduleController());
        mappings.put("/schedule/calendar/detail", new ForwardController("/group/schedule/scheduleForm.jsp"));
        
    }

    public Controller findController(String uri) {	
        return mappings.get(uri);
    }
}