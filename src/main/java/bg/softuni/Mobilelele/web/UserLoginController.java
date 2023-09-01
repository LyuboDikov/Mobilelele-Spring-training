package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.models.dtos.UserLoginDto;
import bg.softuni.Mobilelele.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/user/login")
    public String login(UserLoginDto userLoginDto) {
        System.out.println("User is logged: " + userService.login(userLoginDto));
        return "redirect:/";
    }
}
