package daily.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSON;


/**
 * 汇金平台错误号统一加载和获取工具类
 * 
 * @author admin
 */
public class ErrorUtils {

    static final String                     ERROR_FILE = "classpath:errorCode.properties";

    static final Logger                     logger     = LoggerFactory.getLogger(ErrorUtils.class);

    public static final Map<String, String> errorMaps  = new HashMap<String, String>();

    static {
    	InputStreamReader is = null; 
    	FileInputStream fi = null;
        try {
            File file = ResourceUtils.getFile(ERROR_FILE);
            if (file == null) {
                logger.warn("错误号定义文件" + ERROR_FILE + "不存在!");
            } else {
                Properties pps = new Properties();
                fi = new FileInputStream(file);
                is = new InputStreamReader(fi, "utf-8");
                pps.load(is);
                Enumeration<?> nameEnums = pps.propertyNames();
                while (nameEnums.hasMoreElements()) {
                    String strKey = (String) nameEnums.nextElement();
                    errorMaps.put(strKey, pps.getProperty(strKey));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				if (fi != null) {
					fi.close();
				}
			} catch (Exception e) {
				logger.error("输入流关闭失败");
			}
        	
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				logger.error("输入流关闭失败");
			}
		}
    }

    /**
     * 返回错误信息
     * 
     * @param code 错误编号, 必须定义在classpath:errorCode.properties中
     * @return 原始错误信息
     */
    public static String getMsg(String code) {
        return errorMaps.get(code);
    }

    /**
     * 返回上下文占位符替换后的错误信息
     * 
     * @param code 错误编号, 必须定义在classpath:errorCode.properties中
     * @param args 替换错误信息中{}的实际值
     * @return 占位符替换后的完整错误信息
     */
    public static String getMsg(String code, Object... args) {
        logger.debug(code + "->" + JSON.toJSONString(args));
        String msg = errorMaps.get(code);
        if (msg == null) {
            return msg;
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) continue;
            msg = StringUtils.replaceOnce(msg, "{}", args[i].toString());
        }
        return msg;
    }

    public static void main(String[] args) {
        System.out.println(getMsg("{}1{}f", new Object[] { "1", null }));
    }
}
