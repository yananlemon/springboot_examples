package site.ilemon.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.ilemon.springsecurity.dao.IRoleDao;
import site.ilemon.springsecurity.entity.Role;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringSecurityMysqlApplicationTests {

    @Autowired
    private IRoleDao roleDao;

    @Test
    void testCreateUser() {

    }

    @Test
    void testFindRoleByUserId() {
        List<Role> roles = roleDao.findRoleByUserId(2);
        assertNotNull(roles);
    }


}
