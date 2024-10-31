package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;




  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Configure HTTP security settings
    http
      .authorizeRequests()
        // Allow all OPTIONS requests for Angular/CORS
//        .antMatchers(HttpMethod.OPTIONS).permitAll()
            //.access("hasRole('USER')")
// Allow all requests to any URL without authentication
        .antMatchers(HttpMethod.POST, "/register").access("permitAll")
        .antMatchers(HttpMethod.OPTIONS, "/api/*").authenticated()
//        .anyRequest().permitAll()


//这段代码的功能是配置HTTP安全设置中的表单登录功能：
//启用表单登录：通过调用 .formLogin() 方法启用表单登录。
//指定登录页面URL：通过调用 .loginPage("/login") 方法，指定用户登录时访问的页面URL为 /login。
      .and()
        // Configure form login settings
        .formLogin()
          // Specify the login page URL
          .loginPage("/login")
//这段代码的功能是启用HTTP Basic认证并设置认证的领域名称。
//启用HTTP Basic认证：通过调用 httpBasic() 方法启用HTTP Basic认证。
//设置领域名称：通过调用 realmName("Taco Cloud") 方法设置HTTP Basic认证的领域名称为 "Taco Cloud"。
/*      .and()
        // Enable HTTP Basic authentication
        .httpBasic()
          // Set the realm name for HTTP Basic authentication
          .realmName("Taco Cloud")*/
//这段代码的功能是配置HTTP安全设置中的注销功能：
//配置注销设置：通过调用 logout() 方法来配置注销功能。
//指定成功注销后的重定向URL：通过调用 logoutSuccessUrl("/") 方法，指定用户成功注销后将被重定向到根路径 /。
      .and()
        // Configure logout settings
        .logout()
          // Specify the URL to redirect to after successful logout
          .logoutSuccessUrl("/")
//启用CSRF保护：
//.csrf()：启用CSRF保护，防止跨站请求伪造攻击。
//忽略特定URL的CSRF保护：
//.ignoringAntMatchers("**", "/api/**")：忽略所有路径（**）和/api/**路径下的CSRF保护。这意味着这些路径不会受到CSRF保护的限制，通常用于API接口，以便外部系统可以更方便地调用这些接口。
      .and()
        // Configure CSRF protection
        .csrf()
          // Ignore CSRF protection for URLs matching the pattern
          .ignoringAntMatchers("**", "/api/**")

//这段代码的功能是配置HTTP响应头，具体来说：
//.headers()：启用HTTP响应头配置。
//.frameOptions()：配置X-Frame-Options响应头，用于防止点击劫持（Clickjacking）攻击。
//.sameOrigin()：设置X-Frame-Options为SAMEORIGIN，允许页面在同源的框架中加载
// Allow pages to be loaded in frames from the same origin; needed for H2-Console
      .and()
        .headers()
          .frameOptions()
            .sameOrigin()
    ;
  }

  @Bean
  public PasswordEncoder encoder() {
    // StandardPasswordEncoder 是一个密码编码器，它使用一个指定的盐值（在这里是 "53cr3t"）来对密码进行编码。
//    return new StandardPasswordEncoder("53cr3t");
    // NoOpPasswordEncoder 是一个不进行任何密码编码的密码编码器
    return NoOpPasswordEncoder.getInstance();
  }


  /**
   * 配置认证管理器
   *
   * 在这个方法中，我们定义了如何构建AuthenticationManager，这是Spring Security用于认证用户的关键组件
   * 我们通过告诉AuthenticationManager如何检索用户数据以及如何编码密码来配置它
   *
   * @param auth AuthenticationManagerBuilder的实例，用于配置认证管理器
   * @throws Exception 如果配置过程中出现错误，将抛出异常
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {

//    基于内存的用户认证
    auth.inMemoryAuthentication()
            .withUser("user").password(encoder().encode("password")).roles("USER")
            .and()
            .withUser("admin").password(encoder().encode("admin")).roles("ADMIN");

    // 设置用户详情服务和密码编码器
    auth
      .userDetailsService(userDetailsService) // 使用哪个UserDetailsService实现来获取用户详情
      .passwordEncoder(encoder()); // 使用哪种密码编码器来编码密码

  }

}
