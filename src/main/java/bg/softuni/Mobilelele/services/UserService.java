package bg.softuni.Mobilelele.services;

import bg.softuni.Mobilelele.models.dtos.UserLoginDto;
import bg.softuni.Mobilelele.models.dtos.UserRegisterDto;

public interface UserService {

    boolean login(UserLoginDto userLoginDto);
    void logout();
    void registerAndLogin(UserRegisterDto userRegisterDto);

}
