package net.togogo.mapper;

import net.togogo.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    /**
     * 查询所有角色
     * @return
     */
    @Select("select * from sys_role")
    List<Role> findAll();
}
