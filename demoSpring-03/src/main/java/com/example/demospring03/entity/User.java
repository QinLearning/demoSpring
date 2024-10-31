package com.example.demospring03.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * user
 * @author 
 */
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
@Data
public class User implements Serializable, UserDetails {

    private String userId;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String fullname;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String phoneNumber;

    private static final long serialVersionUID = 1L;

    public User(String username, String encode, String fullname, String street, String city, String state, String zip, String phone) {
        this.username = username;
        this.password = encode;
        this.fullname = fullname;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phone;
    }


    /**
     * 返回用户拥有的权限集合
     *
     * 此方法返回的Collection对象包含了用户的角色或权限，这对于Spring Security框架来说非常重要
     * 它会根据这些权限来决定用户是否有访问特定资源的权限
     *
     * @return Collection<? extends GrantedAuthority> 用户拥有的权限集合，这里返回一个包含"ROLE_USER"角色的集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    /**
     * 判断用户账户是否未过期
     *
     * Spring Security使用此方法来确定用户的账户是否在有效期内
     * 如果返回false，表示用户账户已过期，不能访问受保护的资源
     *
     * @return boolean 始终返回true，表示用户账户未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 判断用户账户是否未锁定
     *
     * Spring Security使用此方法来检查用户的账户是否被锁定
     * 如果返回false，表示用户账户被锁定，不能进行访问
     *
     * @return boolean 始终返回true，表示用户账户未被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 判断用户的凭证是否未过期
     *
     * Spring Security使用此方法来验证用户的凭证（如密码）是否仍在有效期内
     * 如果返回false，表示用户的凭证已过期，不能用于认证
     *
     * @return boolean 始终返回true，表示用户的凭证未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断用户是否启用
     *
     * Spring Security使用此方法来判断用户是否被启用
     * 如果返回false，表示用户被禁用，不能访问受保护的资源
     *
     * @return boolean 始终返回true，表示用户已启用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
    
}