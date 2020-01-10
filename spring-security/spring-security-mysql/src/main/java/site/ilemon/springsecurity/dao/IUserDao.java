package site.ilemon.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ilemon.springsecurity.entity.User;

/**
 * 用户数据访问接口
 */
@Repository
public interface IUserDao extends JpaRepository<User,Integer> {
    /**
     * 根据{@code username}查询用户
     * @param username
     * @return
     */
    User findByUsername(String username);
}
