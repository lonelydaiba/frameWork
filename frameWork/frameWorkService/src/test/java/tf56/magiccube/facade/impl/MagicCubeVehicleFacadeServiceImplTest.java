package tf56.magiccube.facade.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tf56.magiccube.TestSupport;
import tf56.magiccube.dto.VehicleDto;
import tf56.magiccube.query.MagicCubeVehicleListQuery;
import tf56.magiccube.response.model.ResultModel;
import tf56.magiccube.service.MagicCubeVehicleFacadeService;

import java.util.List;

public class MagicCubeVehicleFacadeServiceImplTest extends TestSupport {

    @Autowired
    private MagicCubeVehicleFacadeService magicCubeVehicleFacadeService;

    @Test
    public void testListMagicCubeVehiclePage(){
        MagicCubeVehicleListQuery magicCubeVehicleListQuery = new MagicCubeVehicleListQuery();
        //magicCubeVehicleListQuery.setVehicleNumber("浙A12345");
        ResultModel<List<VehicleDto>> result = magicCubeVehicleFacadeService.listMagicCubeVehicle(magicCubeVehicleListQuery);
        Assert.assertArrayEquals(new String[]{"success", "200"}, new String[]{result.getResult(), result.getCode()});
        //logger.info("列表记录："+list.list +"记录数：" + list.getCount());
    }

}
