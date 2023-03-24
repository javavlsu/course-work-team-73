package BoardMeet.Backend.Config;
import BoardMeet.Backend.Security.jwt.JwtConfigurer;
import BoardMeet.Backend.Security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
public class SecurityConfig extends  WebSecurityConfigurerAdapter{
    private  final JwtTokenProvider jwtTokenProvider;
    private  static final String ADMIN_ENDPOINT = "/api/admin/**";

    private  static final String STATIC_ENDPOINT = "/api/static/**";
    private static  final String LOGIN_ENDPOINT ="/api/auth/login";
    private static  final String USER_ENDPOINT = "/api/users/**";
    private  static final  String MEET_ENDPOINT = "/api/meets/**";
    private  static  final  String BOARDGAME_ENDPOINT = "/api/boardGame/**";
    private  static final  String COMMENT_ENDPOINT = "/api/comment/**";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return  super.authenticationManagerBean();
    }
    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(MEET_ENDPOINT).permitAll()
                .antMatchers(BOARDGAME_ENDPOINT).permitAll()
                .antMatchers(COMMENT_ENDPOINT).permitAll()
                .antMatchers(USER_ENDPOINT).permitAll()
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(STATIC_ENDPOINT).permitAll()
                .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
