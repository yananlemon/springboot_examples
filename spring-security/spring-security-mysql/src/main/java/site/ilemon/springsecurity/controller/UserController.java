package site.ilemon.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.ilemon.springsecurity.entity.User;
import site.ilemon.springsecurity.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转到注册页面
     * @param model
     * @return
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String registration(User user) {
        userService.save(user);
        return "redirect:/login";
    }
}
