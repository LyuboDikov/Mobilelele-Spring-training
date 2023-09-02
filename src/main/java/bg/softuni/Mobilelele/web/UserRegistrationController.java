package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.models.dtos.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {

    @GetMapping("/users/register")
    public String register(){
        return "auth-register";
    }


    @PostMapping("/users/register")
    public String register(UserRegisterDto userRegisterDto) {

        return "redirect:/";
    }

//TODO Explain POST-redirect-GET
}
