package com.dagy.cafeheroapi.features.auth.data.principal;

import com.dagy.cafeheroapi.features.auth.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component()
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String NO_USER_FOUND = "No user found ";

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.dagy.cafeheroapi.features.auth.domaine.entity.User> optionalUser
                = this.userRepository.findByUsernameEqualsIgnoreCase(username);
        return optionalUser.map(UserPrincipalImpl::new).orElseThrow(
                () -> new UsernameNotFoundException(NO_USER_FOUND + username));
    }

}
