package net.togogo.mapper;

import net.togogo.domain.SysUser;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper {

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from sys_user where username = #{username} ")
    SysUser findByUserName(String username);
}
