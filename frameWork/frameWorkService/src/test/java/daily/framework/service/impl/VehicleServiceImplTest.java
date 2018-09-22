package daily.framework.service.impl;


import daily.framework.domain.Vehicle;
import daily.framework.query.VehicleListQuery;
import daily.framework.service.VehicleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import daily.framework.TestSupport;
import daily.framework.util.dubbo.PageModel;
/**
 * 车辆管理单元测试类
 * @author daili
 *
 */
public class VehicleServiceImplTest extends TestSupport {
	
	private static final Logger logger = Logger.getLogger(VehicleServiceImplTest.class);
	
	@Autowired
	private VehicleService vehicleService;
	
	
	
	@Test
	public void testListMagicCubeVehiclePage(){
		VehicleListQuery vehicleListQuery = new VehicleListQuery();
		//vehicleListQuery.setVehicleNumber("浙A12345");
		PageModel<Vehicle> list = vehicleService.listVehiclePage(vehicleListQuery);
		logger.info("列表记录："+list.getDatas() +"记录数：" + list.getCount());
	}
	

	
	
	

}
