package site.ilemon.springsecurity.service;

import site.ilemon.springsecurity.entity.User;

/**
 * 用户服务接口
 */
public interface IUserService {
    void save(User user);

    User findByUsername(String username);
}
