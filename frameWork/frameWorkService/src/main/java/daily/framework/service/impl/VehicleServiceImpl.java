package daily.framework.service.impl;
/**
 *  车辆管理服务类
 */
import daily.framework.domain.Vehicle;
import daily.framework.service.VehicleService;
import daily.framework.dao.VehicleDao;
import daily.framework.query.VehicleListQuery;
import daily.framework.util.dubbo.PageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Service
public class VehicleServiceImpl implements VehicleService {
    
	@Autowired
    VehicleDao vehicleDao;

	@Override
	public PageModel<Vehicle> listVehiclePage(
			VehicleListQuery vehicleListQuery) {
        PageHelper.startPage(vehicleListQuery.getPageNo(), vehicleListQuery.getPageSize());
        //PageHelper.orderBy("vehicleId desc");
        Page<Vehicle> vehicleLists = (Page<Vehicle>) vehicleDao.listVehicle(vehicleListQuery);
        PageModel<Vehicle> objectPageModel = new PageModel<Vehicle>();
        objectPageModel.setDatas(vehicleLists);
        objectPageModel.setCount((int) vehicleLists.getTotal());
        return objectPageModel;
	}


}
