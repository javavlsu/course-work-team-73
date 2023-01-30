package BoardMeet.Backend.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String Email;
    @Column
    private  String Password;
    @Column
    private  String UserName;
    @Column
    private   String Name;
    @Column
    private  String Role;
    @Column
    private  String AvatarUrl;
    @Column
    private  String City;
    @Column
    private  String AboutMe;
    @OneToMany
    private List<BoardGame> CreateBoardGames;
    @ManyToMany
    private List<Meet> JoinedMeets;
    @OneToMany
    private List<Meet> CreatedMeets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setPassword(String password) {
        Password = password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setAvatarUrl(String avatarUrl) {
        AvatarUrl = avatarUrl;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setAboutMe(String aboutMe) {
        AboutMe = aboutMe;
    }

    public String getPassword() {
        return Password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getName() {
        return Name;
    }

    public String getRole() {
        return Role;
    }

    public String getAvatarUrl() {
        return AvatarUrl;
    }

    public String getCity() {
        return City;
    }

    public String getAboutMe() {
        return AboutMe;
    }



    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public List<BoardGame> getCreateBoardGames() {
        return CreateBoardGames;
    }

    public void setCreateBoardGames(List<BoardGame> createBoardGames) {
        CreateBoardGames = createBoardGames;
    }

    public List<Meet> getJoinedMeets() {
        return JoinedMeets;
    }

    public void setJoinedMeets(List<Meet> joinedMeets) {
        JoinedMeets = joinedMeets;
    }



    public List<Meet> getCreatedMeets() {
        return CreatedMeets;
    }

    public void setCreatedMeets(List<Meet> createdMeets) {
        CreatedMeets = createdMeets;
    }




}
