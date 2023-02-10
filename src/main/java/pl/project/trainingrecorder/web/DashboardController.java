package pl.project.trainingrecorder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.trainingrecorder.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DashboardController {
    private final UserService userService;

    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/app/dashboard")
    public String showApp(HttpServletResponse response,
                          Model model) {
        Cookie cookieName=new Cookie("cookieName",userService.findByLogged().getUserName());
        response.addCookie(cookieName);

        return "dashboard";
    }
}
