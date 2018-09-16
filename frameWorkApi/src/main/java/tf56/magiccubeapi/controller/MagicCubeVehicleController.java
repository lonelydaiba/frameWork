package tf56.magiccubeapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tf56.magiccube.dto.VehicleDto;
import tf56.magiccube.query.MagicCubeVehicleListQuery;
import tf56.magiccube.response.model.ResultModel;
import tf56.magiccube.util.ValidateUtils;
import tf56.magiccubeapi.service.MagicCubeVehicleService;

@RestController
@RequestMapping("/vehicle")
@Api(tags = "车辆相关接口")
public class MagicCubeVehicleController {
	
	@Autowired
	private MagicCubeVehicleService magicCubeVehicleService;
	

    /**
     * 查询车辆列表
     *
     * @return
     */
	@ResponseBody
	@RequestMapping(value = "/listVehicles", method = RequestMethod.GET)
    @ApiOperation(value = "查询车辆列表", notes = "查询车辆列表")
    public ResultModel<List<VehicleDto>> listVehicles(@ModelAttribute @Valid MagicCubeVehicleListQuery query) {
    	return magicCubeVehicleService.getMagicCubeVehicleList(query);
    }


	@ResponseBody
	@RequestMapping(value = "/insertVehicle", method = RequestMethod.POST)
	@ApiOperation(value = "保存车辆", notes = "保存车辆")
	public ResultModel<String> insertVehicles(@ModelAttribute @Valid VehicleDto vehicleDto,BindingResult result)
	     throws Exception {
		ValidateUtils.validParams(result);
		return magicCubeVehicleService.createVehicle(vehicleDto);
	}

	

}
