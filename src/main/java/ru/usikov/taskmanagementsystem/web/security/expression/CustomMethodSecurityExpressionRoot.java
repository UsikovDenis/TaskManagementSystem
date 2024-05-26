package ru.usikov.taskmanagementsystem.web.security.expression;


import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.usikov.taskmanagementsystem.entities.user.UserRole;
import ru.usikov.taskmanagementsystem.service.UserService;
import ru.usikov.taskmanagementsystem.web.security.JwtEntity;

import java.util.UUID;

@Setter
@Getter
public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot
        implements MethodSecurityExpressionOperations {

    private Object filterObject;
    private Object returnObject;
    private Object target;
    private HttpServletRequest request;

    private UserService userService;

    public CustomMethodSecurityExpressionRoot(
            final Authentication authentication
    ) {
        super(authentication);
    }

    public boolean canAccessUser(final UUID id) {
        JwtEntity user = (JwtEntity) this.getPrincipal();
        UUID userId = user.getId();
        return userId == id || hasAnyRole(UserRole.ROLE_ADMIN);
    }

    private boolean hasAnyRole(final UserRole... roles) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (UserRole role : roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
            if (authentication.getAuthorities().contains(authority)) {
                return true;
            }
        }
        return false;
    }

    public boolean canAccessTask(final UUID taskId) {
        JwtEntity user = (JwtEntity) this.getPrincipal();
        return userService.isTaskOwner(user.getId(), taskId);
    }

    @Override
    public Object getThis() {
        return target;
    }

}
