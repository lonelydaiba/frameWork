package tf56.magiccube.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@ApiModel
public class VehicleDto implements Serializable {

	private static final long serialVersionUID = -48041850571206280L;

	
	/**
	 * 车辆Id
	 */

	@ApiModelProperty("车辆Id")
	private String vehicleId;
	
	/** 
	 *  车牌号 
	 */
    @ApiModelProperty(value = "车牌号",required = true)
	@NotBlank(message = "车牌号不能为空")
	private String vehicleNumber;
	
	/** 
	 *  车型 :0=厢车；1=高低板；2=平板；3=高栏；4=挂车；5=冷藏车 
	 */
	@ApiModelProperty(value = "车型 :0=厢车；1=高低板；2=平板；3=高栏；4=挂车；5=冷藏车 ",required = true)
	@NotBlank(message = "车型 :0=厢车；1=高低板；2=平板；3=高栏；4=挂车；5=冷藏车 ")
	@Min(value = 0, message = "车型 :0=厢车；1=高低板；2=平板；3=高栏；4=挂车；5=冷藏车")
	@Max(value = 5, message = "车型 :0=厢车；1=高低板；2=平板；3=高栏；4=挂车；5=冷藏车")
	private String vehicleType;
    
    /** 
	 *  车牌号类型：01=黄底黑字；02=蓝底白字；03=绿底黑字；09=其他
	 */
    @ApiModelProperty("车牌号类型：01=黄底黑字；02=蓝底白字；03=绿底黑字；09=其他 ")
	private String vehicleNumberType;
	
	/** 
	 *  车长（单位：米） 4.2、5.2、6.2、6.8、7.2、7.6、8.2、9.6、12.5、13.5、16.5、17.5 
	 */
    @ApiModelProperty("车长（单位：米） 4.2、5.2、6.2、6.8、7.2、7.6、8.2、9.6、12.5、13.5、16.5、17.5")
	private Double vehicleOverallLength;
	
	/** 
	 *  额定载重，上限100吨（单位：吨） 
	 */
    @ApiModelProperty("额定载重，上限100吨（单位：吨）")
	private Double canWeight;
	
	/** 
	 *  额定体积（单位：立方米）上限1000立主米 
	 */
    @ApiModelProperty("额定体积（单位：立方米）上限1000立主米 ")
	private Double canVolume;
	
	/** 
	 *  司机姓名 
	 */
    @ApiModelProperty("司机姓名")
	private String driverName;
	
	/** 
	 *  司机手机号码 
	 */
    @ApiModelProperty("司机手机号码")
	private String driverMobile;
	
	/** 
	 *  应用名称 
	 */
    @ApiModelProperty("应用名称")
	private String appName;


	/**
	 * 合作模式 1=自营 |2=合作 |3=临调
	 */
	@ApiModelProperty("合作模式 1=自营 |2=合作 |3=临调")
	private String cooperationModel;

	/**
	 * 所属机构
	 */
	@ApiModelProperty("所属机构")
	private String orgName;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date gmtCreate;


	/**
	 * 创建人
	 */
	@ApiModelProperty("创建人")
	private String inputMan;


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

	public Double getVehicleOverallLength() {
		return vehicleOverallLength;
	}

	public void setVehicleOverallLength(Double vehicleOverallLength) {
		this.vehicleOverallLength = vehicleOverallLength;
	}

	public void setCanVolume(Double canVolume) {
		this.canVolume = canVolume;
	}
	
	public Double getCanVolume() {
		return canVolume;
	}
	
	public void setCanWeight(Double canWeight) {
		this.canWeight = canWeight;
	}
	
	public Double getCanWeight() {
		return canWeight;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverMobile() {
		return driverMobile;
	}

	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	
    public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
    
    public String getVehicleId() {
		return vehicleId;
	}

	public String getVehicleNumberType() {
		return vehicleNumberType;
	}

	public void setVehicleNumberType(String vehicleNumberType) {
		this.vehicleNumberType = vehicleNumberType;
	}

	public String getCooperationModel() {
		return cooperationModel;
	}

	public void setCooperationModel(String cooperationModel) {
		this.cooperationModel = cooperationModel;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getInputMan() {
		return inputMan;
	}

	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
	}
}
