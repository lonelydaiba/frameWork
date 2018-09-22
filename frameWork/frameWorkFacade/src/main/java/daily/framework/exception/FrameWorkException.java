package daily.framework.exception;

import daily.framework.util.ErrorUtils;

public class FrameWorkException extends RuntimeException {

    private String errorCode;
    private String errorInfo;

    public String getCode() {
        return errorCode;
    }

    public void setCode(String code) {
        this.errorCode = code;
    }

    public FrameWorkException(String code){
        this.errorCode = code;
        this.errorInfo = ErrorUtils.getMsg(code);
    }

    public FrameWorkException(String code, String msg){
        this.errorCode = code;
        this.errorInfo = msg;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String msg) {
        this.errorInfo = msg;
    }

    public FrameWorkException(){
        super();
    }
}
