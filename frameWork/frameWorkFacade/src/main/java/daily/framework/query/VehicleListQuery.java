package daily.framework.query;

import java.io.Serializable;

import daily.framework.request.BaseQuery;

/**
 * 查询条件
 *
 */
public class VehicleListQuery extends BaseQuery implements Serializable {

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
