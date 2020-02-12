package site.ilemon.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import site.ilemon.springsecurity.entity.Permission;
import site.ilemon.springsecurity.entity.Role;

import java.util.List;

/**
 * 权限数据访问接口
 */
@Repository
public interface IPermissionDao extends JpaRepository<Permission, Integer> {

    /**
     * 根据用户查询权限
     *
     * @param userId
     * @return
     */
    @Query(nativeQuery = true,
            value = "SELECT * FROM t_permissions AS p WHERE EXISTS\n" +
                    "(SELECT permission_code FROM t_role_permissions \n" +
                    "WHERE permission_code = p.permission_code AND EXISTS\n" +
                    "(\n" +
                    "SELECT * FROM t_role AS r WHERE EXISTS \n" +
                    "(SELECT user_id FROM t_user_role WHERE  user_id = :userId AND role_id = r.id)\n" +
                    "))")
    List<Permission> findPermissionByUserId(Integer userId);

    /**
     * 根据用户查询权限
     *
     * @param username
     * @return
     */
    @Query(nativeQuery = true,
            value = "SELECT * FROM t_permissions AS p WHERE EXISTS\n" +
                    "(SELECT permission_code FROM t_role_permissions \n" +
                    "WHERE permission_code = p.permission_code AND EXISTS\n" +
                    "(\n" +
                    "SELECT * FROM t_role AS r WHERE EXISTS \n" +
                    "(SELECT user_id FROM t_user_role WHERE  user_id = (select id from t_user where username = :username) AND role_id = r.id)\n" +
                    "))")
    List<Permission> findPermissionByUsername(String username);
}