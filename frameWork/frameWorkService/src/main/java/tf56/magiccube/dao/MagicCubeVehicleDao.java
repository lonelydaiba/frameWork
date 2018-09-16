package tf56.magiccube.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tf56.magiccube.domain.MagicCubeVehicle;
import tf56.magiccube.query.MagicCubeVehicleListQuery;
/**
 * 
 * @author daili
 *
 */
@Mapper
public interface MagicCubeVehicleDao {

	
	/**
     * 获取列表数据
     */
	List<MagicCubeVehicle> listMagicCubeVehicle(MagicCubeVehicleListQuery query);


}