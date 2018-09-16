package tf56.magiccube.response.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;


public class ResultModel<T> implements Serializable {

    private static final long serialVersionUID = -4844341672260819348L;
    @ApiModelProperty(value="返回结果：success|error")
    private String result;
    @ApiModelProperty(value="返回结果描述")
    private String msg;
    @ApiModelProperty(value="返回数据数量")
    private String count;
    @ApiModelProperty(value="返回码")
    private String code;
    @ApiModelProperty(value="返回数据")
    private T data;

    public ResultModel(String result, T data, String count, String code, String msg){
        super();
        this.result = result;
        this.data = data;
        this.count = count;
        this.code = code;
        this.msg = msg;
    }
	public ResultModel(){
    }

	@JsonIgnore
    public boolean isSuccess() {
        return SUCCESS.equals(result);
    }
    
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

	public static String SUCCESS = "success";
	public static String SUCCESS_CODE = "200";
	public static String SUCCESS_DEFAULT_COUNT = "1";
	public static String SUCCESS_DEFAULT_MSG = "成功";
    
	public static String ERROR = "error";
	public static String ERROR_CODE = "500";
	public static String ERROR_DEFAUL_COUNT = "0";
	public static String ERROR_DEFAULT_MSG = "失败";

    /**
     * 成功返回
     * 
     * @param count
     * @param data
     * @param msg
     * @return
     */
    public static <T> ResultModel<T> successResult(String count, T data, String msg) {
        return new ResultModel<T>(ResultModel.SUCCESS, data, count, ResultModel.SUCCESS_CODE, msg);
    }
    public static <T> ResultModel<T> successResult(Long count, T data) {
        return new ResultModel<T>(ResultModel.SUCCESS, data, String.valueOf(count), ResultModel.SUCCESS_CODE, SUCCESS_DEFAULT_MSG);
    }
    public static <T> ResultModel<T> successResult(T data) {
        return new ResultModel<T>(ResultModel.SUCCESS, data, SUCCESS_DEFAULT_COUNT, 
        		ResultModel.SUCCESS_CODE, SUCCESS_DEFAULT_MSG);
    }

    /**
     * 失败返回
     * 
     * @param count
     * @param data
     * @param msg
     * @return
     */
    public static <T> ResultModel<T> errorResult(String errorCode, String errorMsg) {
        return new ResultModel<T>(ResultModel.ERROR, null, ResultModel.ERROR_DEFAUL_COUNT, errorCode, errorMsg);
    }

}
