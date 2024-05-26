package ru.usikov.taskmanagementsystem.web.security.expression;


import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import ru.usikov.taskmanagementsystem.service.UserService;

public class CustomSecurityExceptionHandler
        extends DefaultMethodSecurityExpressionHandler {

    private final AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
    private ApplicationContext applicationContext;

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
            final Authentication authentication,
            final MethodInvocation invocation
    ) {
        CustomMethodSecurityExpressionRoot root = new CustomMethodSecurityExpressionRoot(authentication);
        root.setTrustResolver(trustResolver);
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setRoleHierarchy(getRoleHierarchy());
        root.setUserService(applicationContext.getBean(UserService.class));
        return root;
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) {
        super.setApplicationContext(applicationContext);
        this.applicationContext = applicationContext;
    }
}
