package BoardMeet.Backend.Controller;

import BoardMeet.Backend.DTO.AuthenticationRequestDTO;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Security.jwt.JwtTokenProvider;
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
    private  final JwtTokenProvider jwtTokenProvider;
    private  final UserService userService;
    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }
    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDTO requestDto){
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
            return  ResponseEntity.ok(response);
        }catch (AuthenticationException e){
            throw  new BadCredentialsException("invalid username or password");
        }

    }
}
