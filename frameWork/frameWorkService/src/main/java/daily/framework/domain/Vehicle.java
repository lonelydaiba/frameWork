package daily.framework.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * ClassName:Vehicle 车辆基本信息表
 *
 * @author tool
 * @version 1.0
 * @since v1.0
 * Date May 13, 2018 3:31:43 PM
 */
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 4926289806910542323L;

	/**
	 *  车辆Id
	 */
	private String vehicleId;

	/**
	 *  车牌号
	 */
	private String vehicleNumber;

	/**
	 *  车牌号类型：01=黄底黑字；02=蓝底白字；03=绿底黑字；09=其他
	 */
	private String vehicleNumberType;

	/**
	 *  车型 :0=厢车；1=高低板；2=平板；3=高栏；4=挂车；5=冷藏车
	 */
	private String vehicleType;

	/**
	 *  车长（单位：米） 4.2、5.2、6.2、6.8、7.2、7.6、8.2、9.6、12.5、13.5、16.5、17.5
	 */
	private java.math.BigDecimal vehicleOverallLength;

	/**
	 *  应用ID（所属应用ID,可包含多个）
	 */
	private String appId;

	/**
	 *  所属机构
	 */
	private String organization;

	/**
	 * 车辆状态
	 */
	private String vehicleStatus;

	/**
	 * 车辆异常信息
	 */
	private String reason;

	/**
	 * 车辆运载能力
	 */
	private String loadCapacity;


	/**
	 * 是否自有车辆  0：外部雇佣 1：自有
	 */
	private Integer   isOwn;

	/**
	 * 车辆出厂日期
	 */
	private Date productionDate;

	/**
	 * 车辆购入日期
	 */
	private Date purchaseDate;

	/**
	 * 车辆用途  0:长途 1:短途
	 */
	private String vehicleUse;

	/**
	 * 组织名称
	 */
	private String orgName;

	/**
	 * 组织id
	 */
	private String orgId;

	/**
	 * 合作模式 1=自营 |2=合作 |3=临调
	 */
	private String cooperationModel;


	/**
	 *  是否删除0=未删除；1=已删除
	 */
	private Byte isDeleted;

	/**
	 *  记录插入时间
	 */
	private Date inputDate;

	/**
	 *  记录插入人
	 */
	private String inputMan;

	/**
	 *  记录更新时间
	 */
	private Date updateDate;

	/**
	 *  记录更新人
	 */
	private String updateMan;


	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCooperationModel() {
		return cooperationModel;
	}

	public void setCooperationModel(String cooperationModel) {
		this.cooperationModel = cooperationModel;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleOverallLength(java.math.BigDecimal vehicleOverallLength) {
		this.vehicleOverallLength = vehicleOverallLength;
	}

	public java.math.BigDecimal getVehicleOverallLength() {
		return vehicleOverallLength;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppId() {
		return appId;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrganization() {
		return organization;
	}


	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(String loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Byte getIsDeleted() {
		return isDeleted;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
	}

	public String getInputMan() {
		return inputMan;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateMan(String updateMan) {
		this.updateMan = updateMan;
	}

	public String getUpdateMan() {
		return updateMan;
	}

	public String getVehicleNumberType() {
		return vehicleNumberType;
	}

	public void setVehicleNumberType(String vehicleNumberType) {
		this.vehicleNumberType = vehicleNumberType;
	}

	public Integer getIsOwn() {
		return isOwn;
	}

	public void setIsOwn(Integer isOwn) {
		this.isOwn = isOwn;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getVehicleUse() {
		return vehicleUse;
	}

	public void setVehicleUse(String vehicleUse) {
		this.vehicleUse = vehicleUse;
	}

    	
}