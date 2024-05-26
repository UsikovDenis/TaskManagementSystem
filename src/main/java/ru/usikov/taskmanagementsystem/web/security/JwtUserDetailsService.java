package ru.usikov.taskmanagementsystem.web.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.usikov.taskmanagementsystem.entities.user.User;
import ru.usikov.taskmanagementsystem.service.UserService;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        User user = userService.findByUsername(username);
        return JwtEntityFactory.create(user);
    }

}
