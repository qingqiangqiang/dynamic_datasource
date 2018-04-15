package spring.boot.dynamicdatasource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.dynamicdatasource.dao.model.AppointmentClassInfo;
import spring.boot.dynamicdatasource.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDatasourceApplicationTests {



	@Autowired
	private UserService userService;

	@Test
	@Transactional
	public void test() {

		System.out.println(userService.ds1(44L));
		AppointmentClassInfo appointmentClassInfo = new AppointmentClassInfo();
		appointmentClassInfo.setAppointId(1L);
		appointmentClassInfo.setAppointChannel(1);
		appointmentClassInfo.setAppointmentBeginTime((int)(System.currentTimeMillis()/1000));
		appointmentClassInfo.setAppointmentEndTime((int)(System.currentTimeMillis()/1000));
		appointmentClassInfo.setAppointmentTime((int)(System.currentTimeMillis()/1000));
		appointmentClassInfo.setCtime((int)(System.currentTimeMillis()/1000));
		appointmentClassInfo.setClassInfoName("");
		appointmentClassInfo.setCoachId(110L);
		appointmentClassInfo.setCoachLoginMobile("18098070009");
		appointmentClassInfo.setStoreAreaId(10L);
		appointmentClassInfo.setStoreAreaName("创立方");
		appointmentClassInfo.setCoachStageName("hahah");
		appointmentClassInfo.setClassTypeId(1);
		appointmentClassInfo.setStatus(1);
		appointmentClassInfo.setUserAvailId(1L);
		appointmentClassInfo.setUserId(120890L);
		appointmentClassInfo.setUserMobile("18098070009");
		appointmentClassInfo.setUserNick("nihao");
		appointmentClassInfo.setCoachMobile("18098070009");
		System.out.println(userService.insertToDS1(appointmentClassInfo));
		appointmentClassInfo = userService.ds2(44L);

		if (appointmentClassInfo==null){
			System.out.println(appointmentClassInfo.getAppointChannel());
		}

	}


}
