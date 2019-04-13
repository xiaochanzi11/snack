package com.snack.service;

import com.snack.model.Admin;
import com.snack.model.AdminMenu;
import com.snack.model.AdminMenuChild;
import com.snack.model.Permission;

import java.util.List;

public interface adminLoginService {
    List<Admin> adminLogin(Admin admin);

    List<AdminMenu> selectAllAdminMenu();

    List<AdminMenuChild> selectAllAdminMenuChild();

    List<Permission> selectAllPermission();

    List<Permission> selectRolePermission(int roleId);
}
