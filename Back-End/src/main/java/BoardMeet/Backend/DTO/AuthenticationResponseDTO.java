package BoardMeet.Backend.DTO;

import BoardMeet.Backend.Model.User;

public class AuthenticationResponseDTO {
    private User authUser;
    private String token;
    public AuthenticationResponseDTO(User user,String token){
        this.token = token;
        this.authUser = user;
    }
    public User getAuthUser() {
        return authUser;
    }

    public void setAuthUser(User authUser) {
        this.authUser = authUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
