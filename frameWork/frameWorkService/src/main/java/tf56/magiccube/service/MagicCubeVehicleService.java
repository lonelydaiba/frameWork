package tf56.magiccube.service;

import tf56.magiccube.domain.MagicCubeVehicle;
import tf56.magiccube.exception.MagicCubeException;
import tf56.magiccube.query.MagicCubeVehicleListQuery;
import tf56.magiccube.util.dubbo.PageModel;
/**
 * 车辆服务接口
 * @author daili
 *
 */
public interface MagicCubeVehicleService {
    /**
     * 分页查询车辆列表
     * 
     * @param magicCubeVehicleListQuery 产品车辆类
     * @return 分页结果
     */
    PageModel<MagicCubeVehicle> listMagicCubeVehiclePage(MagicCubeVehicleListQuery magicCubeVehicleListQuery)
    		throws MagicCubeException;


}
