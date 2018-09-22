package daily.frameworkapi.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;


import daily.framework.exception.FrameWorkException;
import daily.framework.exception.ServiceException;
import daily.framework.exception.ValidException;
import daily.framework.response.model.ResultModel;

/**
 * 全局异常处理器,处理新增的异常，对于有特殊逻辑的返回直接定义个新方法，参考ServiceException
 */
@ControllerAdvice
@Component
@ResponseBody
public class GlobalExceptionHandler {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 异常处理
     */
    @ExceptionHandler(FrameWorkException.class)
    public ResultModel<String> handlerMagicCubeException(FrameWorkException e) {
        String message = e.getErrorInfo();
        return new ResultModel<String>("error", "", "", e.getCode(), message);
    }


    @ExceptionHandler(ValidException.class)
    public ResultModel<String> handlerValidException(ValidException e) {
        String message = e.getMessage();
        return new ResultModel<String>("error", "", "", e.getErrorCode(), message);
    }


	@ExceptionHandler(ServiceException.class)
	public ResultModel<String> handlerServiceException(ServiceException e){
		return new ResultModel<String>("error", "500", e.getMessage(), "", "");
	}
    /**
     * 处理绑定异常，用于处理自定义数据校验对外的提示信息
     * @param e 绑定异常
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultModel<String> handlerBindException(MethodArgumentNotValidException e) {
        FieldError fieldError = (FieldError) e.getBindingResult().getAllErrors().get(0);

        if (isIllegalisIllegalArgument(fieldError)) {
            return new ResultModel<String>("error", "参数" + fieldError.getField() + "格式错误", "", "", "500");
        }
        
        return new ResultModel<String>("error", fieldError.getDefaultMessage(), "", "", "500");
    }
    
    /**
     * 处理绑定异常，用于处理自定义数据校验对外的提示信息
     * @param e 绑定异常
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResultModel<String> handlerBindException(BindException e) {
        FieldError fieldError = (FieldError) e.getAllErrors().get(0);

        if (isIllegalisIllegalArgument(fieldError)) {
            return new ResultModel<String>("error", "参数" + fieldError.getField() + "格式错误", "", "", "500");
        }
        
        return new ResultModel<String>("error", fieldError.getDefaultMessage(), "", "", "500");
    }
    
    // spring在处理binding数据到bean的时候，如果出现NumberFormationExcepion等,会统一包装为BindException
    private boolean isIllegalisIllegalArgument(FieldError fieldError) {
        return isNumberFormatException(fieldError)
                || isIllegalArgumentException(fieldError);
    }

    private boolean isNumberFormatException(FieldError fieldError) {

        return fieldError.getDefaultMessage().contains(
                "java.lang.NumberFormatException");
    }

    private boolean isIllegalArgumentException(FieldError fieldError) {
        if (null == fieldError) {
            return false;
        }
        if (null == fieldError.getDefaultMessage()) {
            return false;
        }
        return fieldError.getDefaultMessage().contains(
                "java.lang.IllegalArgumentException");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResultModel<String> handlerNoHandlerFoundException(NoHandlerFoundException e){
        return new ResultModel<String>("error", "请求的url地址不存在", "", "", "500");

    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultModel<String> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return new ResultModel<String>("error", "请求方式错误", "", "", "500");

    }

	@ExceptionHandler(Exception.class)
	public ResultModel<String> handlerException(Exception e){
		LOGGER.error("Oops", e);
        return new ResultModel<String>("error", "服务器错误", "", "", "500");
	}
}
