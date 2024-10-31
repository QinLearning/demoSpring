package com.example.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author qin_xf 2024/10/31
 */
@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        // 设置数据库方言为MySQL，以适应特定的数据库操作
        p.setProperty("helperDialect", "mysql");
        // 启用合理化模式，优化SQL执行策略
        p.setProperty("reasonable", "true");
        // 开启支持方法参数，允许在SQL中使用方法参数
        p.setProperty("supportMethodsArguments", "true");
        // 设置参数映射，将特定的参数映射到SQL中
        p.setProperty("params", "count=countSql");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}