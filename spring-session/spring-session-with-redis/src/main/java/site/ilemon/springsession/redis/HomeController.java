package site.ilemon.springsession.redis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    /**
     * 跳转到首页
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> msgs = (List<String>) session.getAttribute("MY_MESSAGES");

        if (msgs == null) {
            msgs = new ArrayList<>();
        }
        model.addAttribute("messages", msgs);

        return "index";
    }

    /**
     * 将{@code msg}保存到session中，key为：MY_MESSAGES,value为消息的二进制表示
     * @param msg
     * @param request
     * @return
     */
    @PostMapping("/message")
    public String saveMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<String> msgs = (List<String>) request.getSession().getAttribute("MY_MESSAGES");
        if (msgs == null) {
            msgs = new ArrayList<>();
            request.getSession().setAttribute("MY_MESSAGES", msgs);
        }
        msgs.add(msg);
        request.getSession().setAttribute("MY_MESSAGES", msgs);
        return "redirect:/";
    }


    /**
     * 销毁消息
     * @param request
     * @return
     */
    @PostMapping("/messages")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
