package tf56.magiccube.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tf56.magiccube.domain.*;
import tf56.magiccube.dto.*;
import tf56.magiccube.exception.MagicCubeException;
import tf56.magiccube.query.MagicCubeVehicleListQuery;
import tf56.magiccube.response.model.ResultModel;
import tf56.magiccube.service.*;
import tf56.magiccube.util.dozer.DozerBeanMapperWrapper;
import tf56.magiccube.util.dubbo.PageModel;

/**
 * 车辆管理接口实现类
 * 
 * @author daili
 *
 */
@Service("magicCubeVehicleFacadeService")
public class MagicCubeVehicleFacadeServiceImpl implements MagicCubeVehicleFacadeService {

	private static final Logger logger = LoggerFactory.getLogger(MagicCubeVehicleFacadeServiceImpl.class);

/*	@Value("${magicCubeAppId}")
	private String magicCubeAppId;*/

	@Autowired
	private MagicCubeVehicleService magicCubeVehicleService;

    @Autowired
    private DozerBeanMapperWrapper dozerBeanMapperWrapper;


    @Override
	public ResultModel<List<VehicleDto>> listMagicCubeVehicle(MagicCubeVehicleListQuery query)
			throws MagicCubeException {
        PageModel<MagicCubeVehicle> magicCubeVehiclePageModel = magicCubeVehicleService.listMagicCubeVehiclePage(query);
		List<MagicCubeVehicle> vehiclelist = magicCubeVehiclePageModel.getDatas();
        List<VehicleDto> vehicleDtos = new ArrayList<VehicleDto>();
		if (CollectionUtils.isNotEmpty(vehiclelist)) {
			for (MagicCubeVehicle magicCubeVehicleRecord : vehiclelist) {
				vehicleDtos.add(dozerBeanMapperWrapper.mapper(magicCubeVehicleRecord, VehicleDto.class));
			}
		}
        return ResultModel.successResult(String.valueOf(magicCubeVehiclePageModel.getCount()), vehicleDtos,"查询车辆列表成功");
        
	}

	/**
	 * 新增车辆信息
	 *
	 * @param vehicleDto
	 * @return ResultModel
	 * @author daili 2018年3月30日 下午2:27:07
	 */
	@Override
	public ResultModel<String> createVehicle(VehicleDto vehicleDto) throws MagicCubeException {
		return ResultModel.successResult("111");
	}


}
