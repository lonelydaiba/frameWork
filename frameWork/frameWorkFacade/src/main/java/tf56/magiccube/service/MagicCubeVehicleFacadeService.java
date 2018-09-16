package tf56.magiccube.service;

import java.util.List;

import tf56.magiccube.dto.VehicleDto;
import tf56.magiccube.exception.MagicCubeException;
import tf56.magiccube.query.MagicCubeVehicleListQuery;
import tf56.magiccube.response.model.ResultModel;

/**
 * 
 * @author daili
 *
 */
public interface MagicCubeVehicleFacadeService {
	
    /**
     * 查询车辆列表
     * @param magicCubeVihicleListquery
     * @return
     */
    ResultModel<List<VehicleDto>> listMagicCubeVehicle(MagicCubeVehicleListQuery magicCubeVihicleListquery) throws MagicCubeException;

    /**
     * 新增车辆信息
     *
     * @param vehicleDto
     * @return ResultModel
     * @author daili 2018年3月30日 下午2:27:07
     */
    ResultModel<String> createVehicle(VehicleDto vehicleDto) throws MagicCubeException;
}
