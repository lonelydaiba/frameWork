package daily.framework.util.dubbo;

import java.io.Serializable;

public class Result<T> implements Serializable {


    private static final long serialVersionUID = -1367076230052171115L;

    /** 结果： success 或  error */
    private String result;

    /** 响应码 800以上为业务错误码 */
    private String code;

    /** 提示的信息 */
    private String msg;

    /** 分页操作时的总行数 */
    private String count;

    /** 业务数据 */
    private T data;

    //---------------------------------------------------------
    //   setters and getters
    //---------------------------------------------------------
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    /**
     * 设置业务错误码，注意规范要求，如果是业务错误，应该大于 800
     *
     * @param code 错误码
     */
    public void setCode(String code) {
        this.code = code;
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

    public Result(){}

    public Result(String result, String msg, String count, T data, String code) {
        super();
        this.result = result;
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
