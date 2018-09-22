package daily.framework.exception;

public class ParameterException extends RuntimeException {

    private static final long serialVersionUID = -2502900562690729163L;

    private String parameterName;

    private Class<?> parameterType;

    /**
     * 指定参数名称 和 错误提示信息 构造一个参数异常
     *
     * @param parameterName 参数名称
     * @param message 错误信息
     */
    public ParameterException(String parameterName, String message){
        this(parameterName, null, message);
    }

    /**
     * 指定参数名称、参数类型、错误提示信息 构造一个参数异常
     * @param parameterName
     * @param parameterType
     * @param message
     */
    public ParameterException(String parameterName, Class<?> parameterType, String message){
        super(message);
        this.parameterName = parameterName;
    }

    /**
     * 获取参数类型
     * @return
     */
    public Class<?> getParameterType() {
        return parameterType;
    }

    /**
     * 获取参数名称
     * @return
     */
    public String getParameterName() {
        return parameterName;
    }
}
