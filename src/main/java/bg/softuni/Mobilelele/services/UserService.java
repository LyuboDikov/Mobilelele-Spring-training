package bg.softuni.Mobilelele.services;

import bg.softuni.Mobilelele.models.dtos.UserLoginDto;

public interface UserService {

    boolean login(UserLoginDto userLoginDto);

    void logout();

}
