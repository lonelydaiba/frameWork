package daily.framework.service;

import daily.framework.domain.Vehicle;
import daily.framework.util.dubbo.PageModel;
import daily.framework.exception.FrameWorkException;
import daily.framework.query.VehicleListQuery;
/**
 * 车辆服务接口
 * @author daili
 *
 */
public interface VehicleService {
    /**
     * 分页查询车辆列表
     * 
     * @param query 产品车辆类
     * @return 分页结果
     */
    PageModel<Vehicle> listVehiclePage(VehicleListQuery query)
    		throws FrameWorkException;


}
