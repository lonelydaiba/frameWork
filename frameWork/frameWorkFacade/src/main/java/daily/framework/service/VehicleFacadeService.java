package daily.framework.service;

import java.util.List;

import daily.framework.dto.VehicleDto;
import daily.framework.exception.FrameWorkException;
import daily.framework.query.VehicleListQuery;
import daily.framework.response.model.ResultModel;

/**
 * 
 * @author daili
 *
 */
public interface VehicleFacadeService {
	
    /**
     * 查询车辆列表
     * @param query
     * @return
     */
    ResultModel<List<VehicleDto>> listVehicle(VehicleListQuery query) throws FrameWorkException;

    /**
     * 新增车辆信息
     *
     * @param vehicleDto
     * @return ResultModel
     * @author daili 2018年3月30日 下午2:27:07
     */
    ResultModel<String> createVehicle(VehicleDto vehicleDto) throws FrameWorkException;
}
