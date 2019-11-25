package com.smartpro.mis;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Supermis Web程序启动类
 *
 * @author mengiy
 * @date 2017-05-21 9:43
 */
public class SupermisServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SupermisApplication.class);
    }
}
