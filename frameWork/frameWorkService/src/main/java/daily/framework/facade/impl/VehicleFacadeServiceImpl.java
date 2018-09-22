package daily.framework.facade.impl;

import java.util.ArrayList;
import java.util.List;

import daily.framework.domain.Vehicle;
import daily.framework.service.VehicleFacadeService;
import daily.framework.service.VehicleService;
import daily.framework.dto.*;
import daily.framework.exception.FrameWorkException;
import daily.framework.query.VehicleListQuery;
import daily.framework.response.model.ResultModel;
import daily.framework.util.dozer.DozerBeanMapperWrapper;
import daily.framework.util.dubbo.PageModel;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 车辆管理接口实现类
 * 
 * @author daili
 *
 */
@Service("vehicleFacadeService")
public class VehicleFacadeServiceImpl implements VehicleFacadeService {

	private static final Logger logger = LoggerFactory.getLogger(VehicleFacadeServiceImpl.class);

	@Autowired
	private VehicleService vehicleService;

    @Autowired
    private DozerBeanMapperWrapper dozerBeanMapperWrapper;


    @Override
	public ResultModel<List<VehicleDto>> listVehicle(VehicleListQuery query)
			throws FrameWorkException {
        PageModel<Vehicle> vehiclePageModel = vehicleService.listVehiclePage(query);
		List<Vehicle> vehiclelist = vehiclePageModel.getDatas();
        List<VehicleDto> vehicleDtos = new ArrayList<VehicleDto>();
		if (CollectionUtils.isNotEmpty(vehiclelist)) {
			for (Vehicle vehicleRecord : vehiclelist) {
				vehicleDtos.add(dozerBeanMapperWrapper.mapper(vehicleRecord, VehicleDto.class));
			}
		}
        return ResultModel.successResult(String.valueOf(vehiclePageModel.getCount()), vehicleDtos,"查询车辆列表成功");
        
	}

	/**
	 * 新增车辆信息
	 *
	 * @param vehicleDto
	 * @return ResultModel
	 * @author daili 2018年3月30日 下午2:27:07
	 */
	@Override
	public ResultModel<String> createVehicle(VehicleDto vehicleDto) throws FrameWorkException {
		return ResultModel.successResult("111");
	}


}
