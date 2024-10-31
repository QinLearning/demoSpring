package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author qin_xf 2024/10/31
 */
@Configuration
public class druidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource",ignoreUnknownFields = false) // 读取配置文件中的数据源信息。Druid会以此建立数据库连接
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters("stat"); // 开启
        return druidDataSource;
    }

    /**
     * （非必要）开启前台监控页面对应的 Servlet，并设置密码（通过 http://域名/druid/index.html 即可访问监控页面）
     * http://127.0.0.1:8080/druid/index.html
     * 此 Servlet 是由 Druid 提供的 StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet(){
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","root");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","root");
        return statViewServletServletRegistrationBean;
    }

    /**
     * （非必要）配置Druid的Filter，用于记录 web 请求记录。
     * 此 Filter 是由 Druid 提供的 WebStatFilter
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        // 除以下路径的访问不记录，其它都会进行记录
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        // 记录 session 时，记录下 session 中记录的用户名
        webStatFilterFilterRegistrationBean.addInitParameter("principalSessionName","userName");
        return webStatFilterFilterRegistrationBean;
    }

}
