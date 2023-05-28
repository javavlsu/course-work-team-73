package BoardMeet.Backend.Controller;

import BoardMeet.Backend.DTO.AuthenticationRequestDTO;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/auth/")
public class AuthenticationController {
    private  final AuthenticationManager authenticationManager;
    private  final AuthenticationService authenticationService;
    private  final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, AuthenticationService authenticationService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDTO requestDto){

        try{
            return  ResponseEntity.ok(authenticationService.login(requestDto));
        }catch (BadCredentialsException e){
            throw  e;
        }

    }
}
