package net.togogo.service;

import net.togogo.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * UserDetailsService ： 提供了一个方法：loadUserByUserName
 */
public interface SysUserService extends UserDetailsService {


    /**
     * 查询所有用户
     * @return
     */
    List<SysUser> findAll();

    /**
     * 保存用户
     * @param sysUser
     */
    void save(SysUser sysUser);
}
