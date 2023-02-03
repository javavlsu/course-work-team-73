package BoardMeet.Backend.Security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Collection;

public class JwtUser implements UserDetails {
    private  final  Long id;
    private  final  String username;
    private  final String email;
    private  final  String password;
    private final boolean enabled;

    private final Date lastPasswordResetDate;
    private final Collection<? extends GrantedAuthority> authorities;



    public JwtUser(Long id, String username, String email, boolean enabled,String password,Collection<? extends GrantedAuthority> authorities,Date lastPasswordResetDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
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
