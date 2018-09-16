package tf56.magiccubeapi.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import tf56.fastdfs.common.FastDFSException;
import tf56.fastdfs.util.FastDFSUtil;
import tf56.magiccube.exception.ServiceException;
import tf56.magiccube.response.model.ResultModel;

@Service
public class UploadFileService {

    public ResultModel<Map<String, Object>> uploadImage(DefaultMultipartHttpServletRequest request) {
        String receiptimgurl = "";
        try {
            MultipartFile file = null;
            Iterator<String> it = request.getFileNames();
           // String imgViewAddress = ReadPropertiesFile.getString("config/fdfs_client", "imgViewAddress");
            while (it.hasNext()) {
                // 根据文件名称取文件
                file = request.getFile(it.next());
                String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

                // 上传图片
                List<String> returnId = FastDFSUtil.uploadImage(file.getInputStream(), file.getSize(), extName, null,
                                                                -1, false);
                //receiptimgurl = receiptimgurl + imgViewAddress + returnId.get(0) + ",";
            }
        } catch (FastDFSException e1) {
            throw new ServiceException("500", e1.getMessage());
        } catch (Exception e2) {
            throw new ServiceException("500", "图片上传失败");
        }
        if (StringUtils.isBlank(receiptimgurl)) {
            throw new ServiceException("500", "图片上传失败");
        }
        receiptimgurl = receiptimgurl.substring(0, receiptimgurl.length() - 1);

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("imgurl", receiptimgurl);
        return ResultModel.successResult(returnMap);
    }
}
