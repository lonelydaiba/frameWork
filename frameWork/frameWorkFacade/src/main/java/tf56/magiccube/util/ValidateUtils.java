package tf56.magiccube.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import tf56.magiccube.exception.ValidException;

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
