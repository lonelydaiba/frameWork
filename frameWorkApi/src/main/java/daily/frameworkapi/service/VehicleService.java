package daily.frameworkapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daily.framework.dto.VehicleDto;
import daily.framework.exception.FrameWorkException;
import daily.framework.query.VehicleListQuery;
import daily.framework.response.model.ResultModel;
import daily.framework.service.VehicleFacadeService;

/**
 * 车辆管理服务类
 * 
 * @author daili
 *
 */
@Service
public class VehicleService {

	@Autowired
	private VehicleFacadeService vehicleFacadeService;

	public ResultModel<List<VehicleDto>> getMagicCubeVehicleList(VehicleListQuery query) {
		if (query.getPageNo() == null) {
			query.setPageNo(1);
		}
		if (query.getPageSize() == null || query.getPageSize() <= 0) {
			query.setPageSize(10);
		}
		return vehicleFacadeService.listVehicle(query);
	}

	public ResultModel<String> createVehicle(VehicleDto vehicleDto) {
		return vehicleFacadeService.createVehicle(vehicleDto);
	}


}
