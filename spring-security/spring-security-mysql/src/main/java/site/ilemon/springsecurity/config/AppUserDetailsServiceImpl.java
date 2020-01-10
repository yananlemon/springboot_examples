package site.ilemon.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import site.ilemon.springsecurity.dao.IPermissionDao;
import site.ilemon.springsecurity.dao.IRoleDao;
import site.ilemon.springsecurity.dao.IUserDao;
import site.ilemon.springsecurity.entity.Permission;
import site.ilemon.springsecurity.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * UserDetailsService 实现类
 */
public class AppUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if( user == null )
            throw new UsernameNotFoundException(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        List<Permission> permissions = permissionDao.findPermissionByUserId(user.getId());
        for (Permission permission : permissions) {
            if (permission != null && permission.getPermissionCode()!=null) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionCode());
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
