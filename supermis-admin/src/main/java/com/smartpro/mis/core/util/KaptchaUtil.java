package com.smartpro.mis.core.util;

import com.smartpro.mis.config.properties.SupermisProperties;
import com.smartpro.mis.config.properties.SupermisProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(SupermisProperties.class).getKaptchaOpen();
    }
}