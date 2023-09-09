package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.models.dtos.UserRegisterDto;
import bg.softuni.Mobilelele.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    // Creating model attribute, based on object, which we can later
    // add to the binding result and the redirect attributes.
    // No matter which mapping is using the Model it will override the instance.
    // We can add another model attribute with different name
    // and different object, so we can use it too
    @ModelAttribute("userModel")
    public UserRegisterDto initUserModel() {
        return new UserRegisterDto();
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto, // The binding result must be right after the DTO we validate.
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

         // If there are any errors in the user input
        // we are simply showing the fields,
        // where the error occurred, while redirecting them to the same page.
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userModel", userRegisterDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:register";
        }

        //If there were no errors upon validation, we register and login the user.
        userService.registerAndLogin(userRegisterDto);

        return "redirect:/";
    }

}
