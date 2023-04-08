package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.DTO.AuthenticationRequestDTO;
import BoardMeet.Backend.DTO.AuthenticationResponseDTO;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Security.jwt.JwtTokenProvider;
import BoardMeet.Backend.Service.AuthenticationService;
import BoardMeet.Backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private  final AuthenticationManager authenticationManager;
    private  final JwtTokenProvider jwtTokenProvider;
    private  final UserService userService;
    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }
    @Override
    public AuthenticationResponseDTO login(AuthenticationRequestDTO requestDto) {
        try{
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,requestDto.getPassword()));
            User user = userService.findByUsername(username);

            if(user == null){
                throw  new UsernameNotFoundException(username);
            }
            String token = jwtTokenProvider.createToken(username);
            Map<Object,Object> response = new HashMap<>();
            response.put("authUser",user);
            response.put("token",token);
            return  new AuthenticationResponseDTO(user,token);
        }catch (AuthenticationException e){
            throw  new BadCredentialsException("invalid username or password");
        }
    }
}
