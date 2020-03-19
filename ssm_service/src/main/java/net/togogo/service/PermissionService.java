package net.togogo.service;

import net.togogo.domain.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 查询所有
     * @return
     */
    List<Permission> findAll();

    /**
     * 添加权限
     * @param permission
     */
    void save(Permission permission);
}
