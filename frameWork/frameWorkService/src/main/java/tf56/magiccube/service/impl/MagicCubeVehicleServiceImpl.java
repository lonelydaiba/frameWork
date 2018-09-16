package tf56.magiccube.service.impl;
/**
 *  车辆管理服务类
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import tf56.magiccube.dao.MagicCubeVehicleDao;
import tf56.magiccube.domain.MagicCubeVehicle;
import tf56.magiccube.query.MagicCubeVehicleListQuery;
import tf56.magiccube.service.MagicCubeVehicleService;
import tf56.magiccube.util.dubbo.PageModel;

@Service
public class MagicCubeVehicleServiceImpl implements MagicCubeVehicleService{
    
	@Autowired
    MagicCubeVehicleDao magicCubeVehicleDao;

	@Override
	public PageModel<MagicCubeVehicle> listMagicCubeVehiclePage(
			MagicCubeVehicleListQuery magicCubeVehicleListQuery) {
        PageHelper.startPage(magicCubeVehicleListQuery.getPageNo(), magicCubeVehicleListQuery.getPageSize());
        //PageHelper.orderBy("vehicleId desc");
        Page<MagicCubeVehicle> magicCubeVehicleLists = (Page<MagicCubeVehicle>) magicCubeVehicleDao.listMagicCubeVehicle(magicCubeVehicleListQuery);
        PageModel<MagicCubeVehicle> objectPageModel = new PageModel<MagicCubeVehicle>();
        objectPageModel.setDatas(magicCubeVehicleLists);
        objectPageModel.setCount((int) magicCubeVehicleLists.getTotal());
        return objectPageModel;
	}


}
