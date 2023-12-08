package tn.enig.DappUnv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.enig.DappUnv.config.TokenProvider;
import tn.enig.DappUnv.model.AuthToken;
import tn.enig.DappUnv.model.User;
import tn.enig.DappUnv.repository.IUser;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider jwtTokenUtil;
    @Autowired
    IUser userRepo;

    public void setUserRepo(IUser dao) {
        this.userRepo=dao;
    }

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenProvider tokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = tokenProvider;
    }

    public boolean userExists(User user){
        return (!userRepo.findByUsername(user.getUsername()).isEmpty());
    }

    public void registerUser(User user) {
        String password = user.getPassword();

        String hashedPassword = passwordEncoder.encode(password);

        user.setPassword(hashedPassword);

        userRepo.save(user);
    }

    public AuthToken authenticateUser(User user){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(authentication);
            return new AuthToken(token);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}