package ru.usikov.taskmanagementsystem.web.mapper;

import org.mapstruct.Mapper;
import ru.usikov.taskmanagementsystem.entities.user.User;
import ru.usikov.taskmanagementsystem.web.dto.user.UserDto;

@Mapper
public interface UserMapper extends Mappable<User, UserDto> {

}
