package BoardMeet.Backend.Model;

import BoardMeet.Backend.DTO.UserRegisterDTO;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

import java.util.Set;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@Entity
@Table(name="users")
public class User extends  BaseEntity{

    @Column
    private String email;
    @Column
    @JsonIgnore
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;
    @OneToMany(mappedBy = "authorId")

    private Set<BoardGame> CreateBoardGames;


    @ManyToMany(mappedBy = "players")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Set<Meet> JoinedMeets;
    @OneToMany(mappedBy = "authorId")

    private Set<Meet> CreatedMeets;


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
    public void setUsername(String username) {
        username = username;
    }
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @JsonIgnore
    @JsonProperty(value = "CreateBoardGames")
    public Set<BoardGame> getCreateBoardGames() {
        return CreateBoardGames;
    }

    public void setCreateBoardGames(Set<BoardGame> createBoardGames) {
        CreateBoardGames = createBoardGames;
    }
    @JsonIgnore
    @JsonProperty(value = "JoinedMeets")
    public Set<Meet> getJoinedMeets() {
        return JoinedMeets;
    }

    public void setJoinedMeets(Set<Meet> joinedMeets) {
        JoinedMeets = joinedMeets;
    }
    @JsonIgnore
    @JsonProperty(value = "CreatedMeets")
    public Set<Meet> getCreatedMeets() {
        return CreatedMeets;
    }
    public void setCreatedMeets(Set<Meet>createdMeets) {
        CreatedMeets = createdMeets;
    }
}

