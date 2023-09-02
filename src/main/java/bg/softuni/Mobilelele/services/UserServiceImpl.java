package bg.softuni.Mobilelele.services;

import bg.softuni.Mobilelele.models.dtos.UserLoginDto;
import bg.softuni.Mobilelele.models.entities.User;
import bg.softuni.Mobilelele.repositories.UserRepository;
import bg.softuni.Mobilelele.users.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    public boolean login(UserLoginDto userLoginDto) {
        Optional<User> userOptional = userRepository.findByEmail(userLoginDto.getUsername());

        if (userOptional.isEmpty()) {
            LOGGER.debug("User with name [{}] not found.", userLoginDto.getUsername());
            return false;
        }

        boolean success = userOptional.get().getPassword().equals(userLoginDto.getPassword());

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
