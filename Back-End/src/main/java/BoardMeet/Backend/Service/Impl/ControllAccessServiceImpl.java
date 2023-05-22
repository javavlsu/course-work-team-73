package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Model.Role;
import BoardMeet.Backend.Security.jwt.JwtUser;
import BoardMeet.Backend.Service.ControllAccessService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Set;

@Service
public class ControllAccessServiceImpl implements ControllAccessService {

    @Override
    public void tryAccess(Long userId) throws NoAccessException {
        JwtUser principal = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Set<Role> roles = principal.getRole();
        for (Role role:
             roles) {
            if( role.getName().equals("ROLE_ADMIN") )
            {
                return;
            }
        }
        if(userId.compareTo(principal.getId()) != 0){
            throw  new NoAccessException("NOT ACCESS user by id : " + userId);
        }

    }

    @Override
    public Long getIdUser() {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            return 0L;
        }
       JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       return user.getId();
    }
}
