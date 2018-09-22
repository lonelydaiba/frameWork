package daily.framework.util;

import daily.framework.exception.ValidException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidateUtils {

    /**
     * 检验输入参数
     *
     * @param result
     * @throws Exception
     */
    public static void validParams(BindingResult result) throws Exception {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            throw new ValidException(list.get(0).getDefaultMessage());
        }
    }
}
