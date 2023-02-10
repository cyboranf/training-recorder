package pl.project.trainingrecorder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.trainingrecorder.domain.User;
import pl.project.trainingrecorder.service.UserService;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
//    private final PasswordEncoder passwordEncoder;

//    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }

    @GetMapping("/login")
    public String showLoginJSP() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterJSP(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String createAnUser(@ModelAttribute("user") User user,
                               BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "registration";
        }
        if (userService.findByEmail(user.getEmail()) != null) {
            result.rejectValue("email", "error.user", "Taki Email już istnieje");
            model.addAttribute("user", user);
            return "registration";
        }
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            result.rejectValue("password", "error.user", "Podane hasłą są różne");
            model.addAttribute("user", user);
            return "registration";
        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        user.setActive(true);
        userService.save(user);

        return "dashboard";
    }
}
