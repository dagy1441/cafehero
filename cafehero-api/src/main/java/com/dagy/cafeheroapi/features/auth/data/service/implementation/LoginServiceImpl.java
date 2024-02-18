package com.dagy.cafeheroapi.features.auth.data.service.implementation;

import com.dagy.cafeheroapi.configuration.security.JwtAuthenticationTokenUtil;
import com.dagy.cafeheroapi.features.auth.data.dto.LoginUser;
import com.dagy.cafeheroapi.features.auth.data.dto.Menu;
import com.dagy.cafeheroapi.features.auth.data.dto.response.LoginResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.LoginRequest;
import com.dagy.cafeheroapi.features.auth.data.service.abstracts.ILoginService;
import com.dagy.cafeheroapi.features.auth.domaine.entity.User;
import com.dagy.cafeheroapi.features.auth.domaine.enums.AppModuleEnum;
import com.dagy.cafeheroapi.features.auth.domaine.usecase.IUserUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements ILoginService {

    public static final String USER_NOT_FOUND = " %s not found";
    private static final String INVALID_USERNAME = "Invalid login credentials";
    private static final String ACCOUNT_EXPIRED = "Error! Account Is Expired";
    private static final String ACCOUNT_DISABLED = "Error! Account Is Currently Disabled";
    private static final String INVALID_LOGIN = "Invalid Login Credentials";

    private final IUserUsecase userUsecase;
    private final JwtAuthenticationTokenUtil jwtAuthenticationTokenUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest request) {
        User user = findByUsernameOrThrow(request.getUsername());
        LoginResponse loginResponse = this.authenticateUser(user, request.getPassword());
        return ResponseEntity.ok().body(loginResponse);
    }

    private User findByUsernameOrThrow(String username) {
        Optional<User> optional = this.userUsecase.findByUsername(username);
        return optional.orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, INVALID_USERNAME));
    }

    private LoginResponse authenticateUser(User user, String password) {
        this.validateUserAccount(user, password);
        String token = this.jwtAuthenticationTokenUtil.generateToken(user);
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, token, user.getGrantedAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return this.setLoginResponse(user, token);
    }

    private void validateUserAccount(User user, String password) {
        this.throwsInvalidIfPasswordNotMatch(password, user);
        this.throwsInvalidIfAccountIsExpired(user);
        this.throwsInvalidIfAccountIsDisabled(user);
    }

    private void throwsInvalidIfPasswordNotMatch(String password, User user) {
        if (isEmpty(password) || !this.passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(BAD_REQUEST, INVALID_LOGIN);
        }
    }

    private void throwsInvalidIfAccountIsExpired(User user) {
        if (user.isAccountExpired()) {
            throw new ResponseStatusException(BAD_REQUEST, ACCOUNT_EXPIRED);
        }
    }

    private void throwsInvalidIfAccountIsDisabled(User user) {
        if (!user.getIsActiveStatus()) {
            throw new ResponseStatusException(BAD_REQUEST, ACCOUNT_DISABLED);
        }
    }

    private LoginResponse setLoginResponse(User user, String token) {
        LoginResponse response = new LoginResponse();
        response.setUser(this.user(user, token));
        response.setMenu(this.menu(user.getPermissionsTitleAsMap()));
        response.setApp(this.app());
        return response;
    }

    private LoginUser user(User user, String token) {
        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(user.getUsername());
        loginUser.setEnabled(user.getIsActiveStatus());
        loginUser.setToken(token);
        loginUser.setId(user.getId());
        loginUser.setAccess(new ArrayList<>(user.getPermissionsTitleAsSet()));
        return loginUser;
    }

    private List<Menu> menu(Map<String, String> usersPermissions) {
        Menu main = new Menu("MENU", true);
        for (AppModuleEnum module : AppModuleEnum.values()) {
            Menu sub = Menu.parentWithChildren(module.name(), module.pageIcon(), usersPermissions, module.pageRoute());
            if (sub.getChildren() != null && sub.getChildren().size() > 0) {
                Menu.appendChild(main, sub);
            }
        }
        return List.of(main);
    }

    private Map<String, String> app() {
        Map<String, String> details = new HashMap<>();
        details.put("name", "Cafehero");
        details.put("description", "Cafehero, A store management software");
        details.put("version", "1.0.0");
        return details;
    }

}
