package net.togogo.service.impl;

import net.togogo.domain.SysUser;
import net.togogo.mapper.SysUserMapper;
import net.togogo.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    /**
     * 通过用户名得到用户对象
     * 创建详情对象，返回
     *
     * @param username
     * @return 用户详情
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.findByUserName(username);
        if (sysUser != null) {
            //        创建了一个角色集合对象
            Collection<GrantedAuthority> authorities = new ArrayList<>();
//        创建临时的角色对象
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            authorities.add(grantedAuthority);
            /*
             *  参数1 ： 用户名
             *  参数2 ：密码
             *  参数3 ：角色列表对象
             * */
            UserDetails user = new User(sysUser.getUsername(), "{noop}" + sysUser.getPassword(), authorities);
            return user;
        }
        return null;
    }
}
