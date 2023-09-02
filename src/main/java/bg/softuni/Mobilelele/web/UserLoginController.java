package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.models.dtos.UserLoginDto;
import bg.softuni.Mobilelele.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto) {
        userService.login(userLoginDto);
        return "redirect:/";
    }
}
