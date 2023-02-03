package BoardMeet.Backend.Model;

import BoardMeet.Backend.dto.UserRegisterDTO;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name="users")
public class User extends  BaseEntity{

    @Column
    private String email;
    @Column
    private  String password;
    @Column(name ="user_name")
    private  String username;
    @Column
    private   String name;
    @Column
    private  String avatarUrl;
    @Column
    private  String city;
    @Column
    private  String aboutMe;
    @Column
    @ManyToMany
    private List<Role> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }


    public User (UserRegisterDTO userDTO){
        email= userDTO.getEmail();
        password = userDTO.getPassword();
        username = userDTO.getUsername();
        name = userDTO.getName();
        city = userDTO.getCity();
        aboutMe = userDTO.getAboutMe();
        roles = userDTO.getRoles();
        super.setStatus(Status.ACTIVE);
    }
    public User (){}

    @OneToMany
    private List<BoardGame> CreateBoardGames;
    @ManyToMany
    private List<Meet> JoinedMeets;
    @OneToMany
    private List<Meet> CreatedMeets;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})



    public void setUsername(String username) {
        username = username;
    }



    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List  getCreateBoardGames() {
        return CreateBoardGames;
    }

    public void setCreateBoardGames(List createBoardGames) {
        CreateBoardGames = createBoardGames;
    }

    public List getJoinedMeets() {
        return JoinedMeets;
    }

    public void setJoinedMeets(List joinedMeets) {
        JoinedMeets = joinedMeets;
    }



    public List getCreatedMeets() {
        return CreatedMeets;
    }

    public void setCreatedMeets(List createdMeets) {
        CreatedMeets = createdMeets;
    }



}
