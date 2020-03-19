package net.togogo.mapper;

import net.togogo.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from sys_permission")
    List<Permission> findAll();

    /**
     * 添加权限
     * @param permission
     */
    @Insert("insert into sys_permission values(null,#{permissionName},#{url},#{pid})")
    void save(Permission permission);

}
