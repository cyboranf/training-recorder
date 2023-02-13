package pl.project.trainingrecorder.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.trainingrecorder.domain.LoggedUser;
import pl.project.trainingrecorder.domain.User;
import pl.project.trainingrecorder.service.UserService;

@Controller
public class RegistrationController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLoginJSP(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/login/register")
    public String showRegisterJSP(@ModelAttribute("user") User user,
                                  Model model) {
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/login/register")
    public String createAnUser(@ModelAttribute("user") User user,
                               BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "registration";
        }
        if (userService.findByEmail(user.getEmail()) != null) {
            result.rejectValue("email", "error.user", "You already have an account");
            model.addAttribute("user", user);
            return "registration";
        }
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            result.rejectValue("password", "error.user", "Wrong password or matching password");
            model.addAttribute("user", user);
            return "registration";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);

        userService.save(user);
        model.addAttribute("registered", "true");

        return "registration";
    }

    @GetMapping("/login/redirect")
    public String redirect(@AuthenticationPrincipal LoggedUser loggedUser) {
        if (loggedUser.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
            return "redirect:/app/dashboard";
        } else {
            return "redirect:/";
        }
    }
}
