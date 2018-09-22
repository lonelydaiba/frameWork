package daily.framework.exception;

public class ServiceException extends RuntimeException {


    private static final long serialVersionUID = 386798794644048211L;

    private String code;

    /**
     * 构造一个业务异常类
     *
     * @param code 错误码,注意约定的业务错误码都是大于800的
     * @param message 错误信息
     */
    public ServiceException(String code, String message){
        super(message);
        this.code = code;
    }

    /**
     * 返回错误码
     * @return 错误码
     */
    public String getCode() {
        return code;
    }
}
