package bg.softuni.Mobilelele.models.mapper;

import bg.softuni.Mobilelele.models.dtos.UserRegisterDto;
import bg.softuni.Mobilelele.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    User userDtoToUser(UserRegisterDto userRegisterDto);

}
