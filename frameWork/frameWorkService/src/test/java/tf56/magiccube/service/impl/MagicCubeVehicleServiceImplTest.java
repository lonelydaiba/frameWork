package tf56.magiccube.service.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tf56.magiccube.TestSupport;
import tf56.magiccube.domain.MagicCubeVehicle;
import tf56.magiccube.query.MagicCubeVehicleListQuery;
import tf56.magiccube.service.MagicCubeVehicleService;
import tf56.magiccube.util.dubbo.PageModel;
/**
 * 车辆管理单元测试类
 * @author daili
 *
 */
public class MagicCubeVehicleServiceImplTest extends TestSupport {
	
	private static final Logger logger = Logger.getLogger(MagicCubeVehicleServiceImplTest.class);
	
	@Autowired
	private MagicCubeVehicleService magicCubeVehicleService;
	
	
	
	@Test
	public void testListMagicCubeVehiclePage(){
		MagicCubeVehicleListQuery magicCubeVehicleListQuery = new MagicCubeVehicleListQuery();
		//magicCubeVehicleListQuery.setVehicleNumber("浙A12345");
		PageModel<MagicCubeVehicle> list = magicCubeVehicleService.listMagicCubeVehiclePage(magicCubeVehicleListQuery);
		logger.info("列表记录："+list.getDatas() +"记录数：" + list.getCount());
	}
	

	
	
	

}
