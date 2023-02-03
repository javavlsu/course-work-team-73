package BoardMeet.Backend.Security;

import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Security.jwt.JwtUser;
import BoardMeet.Backend.Security.jwt.JwtUserFactory;
import BoardMeet.Backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private  final UserService userService;
    @Lazy
    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userService.findByUsername(username);
       if(user==null){
           throw  new UsernameNotFoundException(username);
       }
       JwtUser jwtUser = JwtUserFactory.create(user);

       return jwtUser;
    }
}
