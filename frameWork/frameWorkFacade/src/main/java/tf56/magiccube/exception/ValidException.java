package tf56.magiccube.exception;

/**
 * 
 * 类ValidException.java的实现描述：参数验证异常
 * @author xie.hn 2016年7月12日 下午3:30:14
 */
public class ValidException extends RuntimeException{

    private static final long serialVersionUID = 4651026498901393483L;

    private String errorCode;  //异常业务编码



    public ValidException(String message){
        super(message);
    }
    
    public ValidException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
    
    public ValidException(String errorCode, String message, Throwable ex){
        super(message, ex);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}