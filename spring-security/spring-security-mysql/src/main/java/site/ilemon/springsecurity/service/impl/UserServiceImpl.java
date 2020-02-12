package site.ilemon.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import site.ilemon.springsecurity.dao.IUserDao;
import site.ilemon.springsecurity.entity.User;
import site.ilemon.springsecurity.service.IUserService;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 保存用户到数据库
     *
     * @param user
     */
    @Override
    public void save(User user) {
        // 使用Bcrypt对密码进行加密
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
