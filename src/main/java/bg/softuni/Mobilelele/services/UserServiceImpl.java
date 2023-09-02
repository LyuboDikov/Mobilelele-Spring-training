package bg.softuni.Mobilelele.services;

import bg.softuni.Mobilelele.models.dtos.UserLoginDto;
import bg.softuni.Mobilelele.models.entities.User;
import bg.softuni.Mobilelele.repositories.UserRepository;
import bg.softuni.Mobilelele.users.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public boolean login(UserLoginDto userLoginDto) {
        Optional<User> userOptional = userRepository.findByEmail(userLoginDto.getUsername());

        if (userOptional.isEmpty()) {
            LOGGER.debug("User with name [{}] not found.", userLoginDto.getUsername());
            return false;
        }

        var rawPassword = userLoginDto.getPassword();
        var encodedPassword =  userOptional.get().getPassword();


        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(userOptional.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(User user) {
        currentUser.setLoggedIn(true);
        currentUser.setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }
}
