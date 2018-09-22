package daily.framework.facade.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import daily.framework.TestSupport;
import daily.framework.dto.VehicleDto;
import daily.framework.query.VehicleListQuery;
import daily.framework.response.model.ResultModel;
import daily.framework.service.VehicleFacadeService;

import java.util.List;

public class VehicleFacadeServiceImplTest extends TestSupport {

    @Autowired
    private VehicleFacadeService vehicleFacadeService;

    @Test
    public void testListVehiclePage(){
        VehicleListQuery vehicleListQuery = new VehicleListQuery();
        //vehicleListQuery.setVehicleNumber("浙A12345");
        ResultModel<List<VehicleDto>> result = vehicleFacadeService.listVehicle(vehicleListQuery);
        Assert.assertArrayEquals(new String[]{"success", "200"}, new String[]{result.getResult(), result.getCode()});
        //logger.info("列表记录："+list.list +"记录数：" + list.getCount());
    }

}
