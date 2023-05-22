package BoardMeet.Backend.Security.jwt;

import BoardMeet.Backend.Model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class JwtUser implements UserDetails {
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    private  final  Long id;

    public Set<Role> getRole() {
        return role;
    }

    private  final Set<Role> role;
    private  final  String username;
    private  final String email;
    private  final  String password;
    private final boolean enabled;

    private final Date lastPasswordResetDate;
    private final Collection<? extends GrantedAuthority> authorities;



    public JwtUser(Long id, String username, String email, boolean enabled,String password,Collection<? extends GrantedAuthority> authorities,Date lastPasswordResetDate,Set<Role> role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.role = role;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
