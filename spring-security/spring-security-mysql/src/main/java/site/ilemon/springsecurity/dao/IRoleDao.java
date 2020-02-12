package site.ilemon.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import site.ilemon.springsecurity.entity.Role;

import java.util.List;

/**
 * 角色数据访问接口
 */
@Repository
public interface IRoleDao extends JpaRepository<Role, Integer> {

    @Query(nativeQuery = true,
            value = "select * from t_role as r where exists (select user_id from t_user_role where  user_id = :userId AND role_id = r.id)")
    List<Role> findRoleByUserId(Integer userId);
}