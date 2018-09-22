package daily.frameworkapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;





import daily.framework.response.model.ResultModel;
import daily.frameworkapi.service.UploadFileService;


@Api(tags = "文件上传控制器")
@RestController
@RequestMapping("/uploadFile")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    @ApiOperation(value = "上传图片", notes = "上传图片")
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public ResultModel<Map<String, Object>> uploadImage(DefaultMultipartHttpServletRequest request,
                                                     HttpServletResponse response) {
        // 获取所有参数
        Map<String, Object> params = new HashMap<String, Object>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            params.put(name, request.getParameter(name));
        }
        return uploadFileService.uploadImage(request);
    }
}
