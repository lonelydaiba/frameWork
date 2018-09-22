package daily.frameworkapi.controller;

import java.util.List;

import javax.validation.Valid;

import daily.framework.query.VehicleListQuery;
import daily.framework.dto.VehicleDto;
import daily.framework.response.model.ResultModel;
import daily.framework.util.ValidateUtils;
import daily.frameworkapi.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/vehicle")
@Api(tags = "车辆相关接口")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	

    /**
     * 查询车辆列表
     *
     * @return
     */
	@ResponseBody
	@RequestMapping(value = "/listVehicles", method = RequestMethod.GET)
    @ApiOperation(value = "查询车辆列表", notes = "查询车辆列表")
    public ResultModel<List<VehicleDto>> listVehicles(@ModelAttribute @Valid VehicleListQuery query) {
    	return vehicleService.getMagicCubeVehicleList(query);
    }


	@ResponseBody
	@RequestMapping(value = "/insertVehicle", method = RequestMethod.POST)
	@ApiOperation(value = "保存车辆", notes = "保存车辆")
	public ResultModel<String> insertVehicles(@ModelAttribute @Valid VehicleDto vehicleDto,BindingResult result)
	     throws Exception {
		ValidateUtils.validParams(result);
		return vehicleService.createVehicle(vehicleDto);
	}

	

}
