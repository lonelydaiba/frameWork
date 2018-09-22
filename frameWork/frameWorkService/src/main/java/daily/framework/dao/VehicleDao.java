package daily.framework.dao;

import java.util.List;

import daily.framework.domain.Vehicle;
import daily.framework.query.VehicleListQuery;
import org.apache.ibatis.annotations.Mapper;
/**
 * 
 * @author daili
 *
 */
@Mapper
public interface VehicleDao {

	
	/**
     * 获取列表数据
     */
	List<Vehicle> listVehicle(VehicleListQuery query);


}