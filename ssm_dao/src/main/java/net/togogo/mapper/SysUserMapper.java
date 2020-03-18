package net.togogo.mapper;

import net.togogo.domain.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserMapper {

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from sys_user where username = #{username} ")
    SysUser findByUserName(String username);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from sys_user")
    List<SysUser> findAll();

    /**
     * 保存用户
     * @param sysUser
     */
    @Insert("insert into sys_user values(null,#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser sysUser);
}
