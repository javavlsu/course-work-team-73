package BoardMeet.Backend.Security.jwt;

import BoardMeet.Backend.Model.Role;
import BoardMeet.Backend.Model.Status;
import BoardMeet.Backend.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public  JwtUserFactory(){
    }
    public static  JwtUser create(User user){
        return  new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getStatus().equals(Status.ACTIVE),
                user.getPassword(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())),
                user.getUpdated()
        );
    }
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}
