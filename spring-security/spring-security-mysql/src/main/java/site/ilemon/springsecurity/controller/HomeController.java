package site.ilemon.springsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import site.ilemon.springsecurity.dao.IPermissionDao;
import site.ilemon.springsecurity.entity.Permission;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IPermissionDao permissionDao;

    @GetMapping("/")
    public String redirectLogin2() {
        return "login";
    }

    @GetMapping("/login")
    public String redirectLogin() {
        return "login";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("currUser");
        session.removeAttribute("username");
        session.removeAttribute("permissions");
        return "redirect:/login";
    }

    /**
     * 跳转到欢迎页面
     * 需要加载权限菜单
     *
     * @param request
     * @return
     */
    @GetMapping("/welcome")
    public String index(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        logger.debug(String.format("redirect to welcome page for user:%s", username));
        if (username != null && !username.trim().equals("")) {
            List<Permission> permissions = permissionDao.findPermissionByUsername(username);
            request.getSession().setAttribute("permissions", permissions);
            request.getSession().setAttribute("username", username);
        }
        return "welcome";
    }
}
