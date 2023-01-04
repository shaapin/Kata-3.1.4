package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {

    void createRole(Role role);

    List<Role> getAllRoles();

    Role finedRoleByRoleName(String roleName);

}
