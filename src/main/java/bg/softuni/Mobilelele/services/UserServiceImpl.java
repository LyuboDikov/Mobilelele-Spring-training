package bg.softuni.Mobilelele.services;

import bg.softuni.Mobilelele.models.dtos.UserLoginDto;
import bg.softuni.Mobilelele.models.dtos.UserRegisterDto;
import bg.softuni.Mobilelele.models.entities.User;
import bg.softuni.Mobilelele.models.mapper.UserMapper;
import bg.softuni.Mobilelele.repositories.UserRepository;
import bg.softuni.Mobilelele.users.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser,
                           PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public boolean registerAndLogin(UserRegisterDto userRegisterDto) {

        User newUser = userMapper.userDtoToUser(userRegisterDto);
        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        try {
            userRepository.save(newUser);
            login(newUser);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }

    }


    @Override
    public boolean login(UserLoginDto userLoginDto) {
        Optional<User> userOptional = userRepository.findByEmail(userLoginDto.getUsername());

        if (userOptional.isEmpty()) {
            LOGGER.debug("User with name [{}] not found.", userLoginDto.getUsername());
            return false;
        }

        String rawPassword = userLoginDto.getPassword();
        String encodedPassword =  userOptional.get().getPassword();

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
