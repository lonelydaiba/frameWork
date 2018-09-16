package tf56.magiccube.query;

import java.io.Serializable;

import tf56.magiccube.request.BaseQuery;

/**
 * 发票查询条件
 * 
 * @author yangfang 2018年3月29日 下午6:54:22
 */
public class MagicCubeVehicleListQuery extends BaseQuery implements Serializable {

	private static final long serialVersionUID = 2635053457817287014L;

    private String    vehicleNumber;

    private String    vehicleType;

    private String    vehicleOverallLength;

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleOverallLength() {
		return vehicleOverallLength;
	}

	public void setVehicleOverallLength(String vehicleOverallLength) {
		this.vehicleOverallLength = vehicleOverallLength;
	}

	
}
