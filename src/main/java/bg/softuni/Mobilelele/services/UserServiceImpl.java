package bg.softuni.Mobilelele.services;

import bg.softuni.Mobilelele.models.dtos.UserLoginDto;
import bg.softuni.Mobilelele.models.entities.User;
import bg.softuni.Mobilelele.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean login(UserLoginDto userLoginDto) {
        Optional<User> userOptional = userRepository.findByEmail(userLoginDto.getUsername());

        if (userOptional.isEmpty()) {
            LOGGER.debug("User with name [{}] not found.", userLoginDto.getUsername());
            return false;
        }

        return userOptional.get().getPassword().equals(userLoginDto.getPassword());
    }
}
