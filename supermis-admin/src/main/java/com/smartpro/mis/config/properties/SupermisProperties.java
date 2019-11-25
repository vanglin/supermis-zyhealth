package com.smartpro.mis.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

import static com.smartpro.mis.core.util.ToolUtil.getTempPath;
import static com.smartpro.mis.core.util.ToolUtil.isEmpty;
import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * supermis项目配置
 *
 * @author mengiy
 * @Date 2017/5/23 22:31
 */
@Component
@ConfigurationProperties(prefix = SupermisProperties.PREFIX)
public class SupermisProperties {

    public static final String PREFIX = "supermis";

    private Boolean kaptchaOpen = false;

    private Boolean swaggerOpen = false;

    private String fileUploadPath;

    private Boolean haveCreatePath = false;

    private Boolean springSessionOpen = false;

    /**
     * session 失效时间（默认为30分钟 单位：秒）
     */
    private Integer sessionInvalidateTime = 30 * 60;

    /**
     * session 验证失效时间（默认为15分钟 单位：秒）
     */
    private Integer sessionValidationInterval = 15 * 60;

    public String getFileUploadPath() {
        String os = System.getProperty("os.name");
        //如果没有写文件上传路径,或者为Windows操作系统，保存到临时目录
        if (isEmpty(fileUploadPath)||os.toLowerCase().startsWith("win")) {
            return getTempPath();
        } else {
            //判断有没有结尾符,没有得加上
            if (!fileUploadPath.endsWith(File.separator)) {
                fileUploadPath = fileUploadPath + File.separator;
            }
            //判断目录存不存在,不存在得加上
            if (!haveCreatePath) {
                File file = new File(fileUploadPath);
                file.mkdirs();
                haveCreatePath = true;
            }
            try{
                String cmdStrs[] = new String[]{"chmod","-R","775",fileUploadPath};
                Process child = Runtime.getRuntime().exec(cmdStrs);
            }catch(Exception e){
                System.out.println("########################chmod error!!!!");
//                e.printStackTrace();
            }
            return fileUploadPath;
        }
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public Boolean getKaptchaOpen() {
        return kaptchaOpen;
    }

    public void setKaptchaOpen(Boolean kaptchaOpen) {
        this.kaptchaOpen = kaptchaOpen;
    }

    public Boolean getSwaggerOpen() {
        return swaggerOpen;
    }

    public void setSwaggerOpen(Boolean swaggerOpen) {
        this.swaggerOpen = swaggerOpen;
    }

    public Boolean getSpringSessionOpen() {
        return springSessionOpen;
    }

    public void setSpringSessionOpen(Boolean springSessionOpen) {
        this.springSessionOpen = springSessionOpen;
    }

    public Integer getSessionInvalidateTime() {
        return sessionInvalidateTime;
    }

    public void setSessionInvalidateTime(Integer sessionInvalidateTime) {
        this.sessionInvalidateTime = sessionInvalidateTime;
    }

    public Integer getSessionValidationInterval() {
        return sessionValidationInterval;
    }

    public void setSessionValidationInterval(Integer sessionValidationInterval) {
        this.sessionValidationInterval = sessionValidationInterval;
    }
}
