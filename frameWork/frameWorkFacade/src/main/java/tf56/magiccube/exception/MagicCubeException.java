package tf56.magiccube.exception;

import tf56.magiccube.util.ErrorUtils;

public class MagicCubeException extends RuntimeException {

    private String errorCode;
    private String errorInfo;

    public String getCode() {
        return errorCode;
    }

    public void setCode(String code) {
        this.errorCode = code;
    }

    public MagicCubeException(String code){
        this.errorCode = code;
        this.errorInfo = ErrorUtils.getMsg(code);
    }

    public MagicCubeException(String code, String msg){
        this.errorCode = code;
        this.errorInfo = msg;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String msg) {
        this.errorInfo = msg;
    }

    public MagicCubeException(){
        super();
    }
}
