package tf56.magiccube.util.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tf56.magiccube.exception.ParameterException;
import tf56.magiccube.exception.ServiceException;


/**
 * Service 层对外暴露的异常统一处理
 *
 * @author dongda
 * @author zhuhanbing
 */
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
public class DubboExceptionFilter implements Filter {

    private final Logger LOGGER = LoggerFactory.getLogger(DubboExceptionFilter.class);

    @Override
    public com.alibaba.dubbo.rpc.Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        Result result = invoker.invoke(invocation);

        if (result.hasException()) {
            String serviceName = invocation.getAttachment("interface");
            String methodName = invocation.getMethodName();

            String url = serviceName + "." + methodName;
            Object[] params = invocation.getArguments();

            tf56.magiccube.util.dubbo.Result<Object> resultToReturn = null;

            Throwable ex = result.getException();
            if (ex instanceof ParameterException) {
                LOGGER.error(url + " >>>>>params=" + JSON.toJSONString(params)
                        + System.getProperty("line.separator") + ex.getMessage());
                resultToReturn = new tf56.magiccube.util.dubbo.Result<Object>("error", "500", ex.getMessage(), "", "");
            } else if (ex instanceof ServiceException) {
                LOGGER.error(url + " >>>>>params=" + JSON.toJSONString(params)
                        + System.getProperty("line.separator") + ex.getMessage());
                ServiceException se = (ServiceException) ex;
                resultToReturn = new tf56.magiccube.util.dubbo.Result<Object>("error", se.getCode(), ex.getMessage(), "", "");
            } else {
                LOGGER.error(url + " >>>>>params=" + JSON.toJSONString(params), ex);
                resultToReturn = new tf56.magiccube.util.dubbo.Result<Object>("error", "500", "服务器异常", "", "");
            }
            result = new RpcResult(resultToReturn);
        }
        return result;
    }
}
