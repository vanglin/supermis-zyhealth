package com.smartpro.mis.config.properties;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * flowable工作流的的配置
 *
 * @author mengiy
 * @date 2017-12-02 23:18
 */
@Configuration
@ConfigurationProperties(prefix = SupermisFlowableProperties.SUPERMIS_FLOWABLE_DATASOURCE)
public class SupermisFlowableProperties {

    public static final String SUPERMIS_FLOWABLE_DATASOURCE = "supermis.flowable.datasource";

    /**
     * 默认多数据源的链接
     */
    private String url = "jdbc:mysql://140.143.142.224:3306/supermis_flowable?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false";

    /**
     * 默认多数据源的数据库账号
     */
    private String username = "root";

    /**
     * 默认多数据源的数据库密码
     */
    private String password = "ZYlk@2018";

    public void config(DruidDataSource dataSource) {
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
