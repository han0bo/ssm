package net.togogo.service;

import net.togogo.domain.Role;

import java.util.List;

public interface RoleService {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
