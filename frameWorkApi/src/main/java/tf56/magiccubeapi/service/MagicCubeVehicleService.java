package tf56.magiccubeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tf56.magiccube.dto.VehicleDto;
import tf56.magiccube.exception.MagicCubeException;
import tf56.magiccube.query.MagicCubeVehicleListQuery;
import tf56.magiccube.response.model.ResultModel;
import tf56.magiccube.service.MagicCubeVehicleFacadeService;

/**
 * 车辆管理服务类
 * 
 * @author daili
 *
 */
@Service
public class MagicCubeVehicleService {

	@Autowired
	private MagicCubeVehicleFacadeService magicCubeVehicleFacadeService;

	public ResultModel<List<VehicleDto>> getMagicCubeVehicleList(MagicCubeVehicleListQuery query) {
		if (query.getPageNo() == null) {
			query.setPageNo(1);
		}
		if (query.getPageSize() == null || query.getPageSize() <= 0) {
			query.setPageSize(10);
		}
		if (query != null) {
			throw new MagicCubeException("111");
		}
		return magicCubeVehicleFacadeService.listMagicCubeVehicle(query);
	}

	public ResultModel<String> createVehicle(VehicleDto vehicleDto) {
		return magicCubeVehicleFacadeService.createVehicle(vehicleDto);
	}


}
