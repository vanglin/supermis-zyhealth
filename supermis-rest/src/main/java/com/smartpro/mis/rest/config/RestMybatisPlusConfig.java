package com.smartpro.mis.rest.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author smartpro
 * @Date 2017年8月23日12:51:41
 */
@Configuration
@MapperScan(basePackages = {"com.smartpro.mis.rest.*.dao", "com.smartpro.mis.rest.common.persistence.dao"})
public class RestMybatisPlusConfig {

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
