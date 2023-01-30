package BoardMeet.Backend.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private  String Name;
    @Column
    private  Integer PeopleCount;
    @Column
    private  Integer PeopleCountMax;
    @Column
    private  Integer Duration;
    @Column
    private  String Link;
    @Column
    private Date Date;
    @Column
    private  String State;
    @Column
    private  String Location;
    @Column
    private  String City;
    @Column
    private  String Games;
    @ManyToMany
    private List<User> Players;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User Author;



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getPeopleCount() {
        return PeopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        PeopleCount = peopleCount;
    }

    public Integer getPeopleCountMax() {
        return PeopleCountMax;
    }

    public void setPeopleCountMax(Integer peopleCountMax) {
        PeopleCountMax = peopleCountMax;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer duration) {
        Duration = duration;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getGames() {
        return Games;
    }

    public void setGames(String games) {
        Games = games;
    }


    public List<User> getPlayers() {
        return Players;
    }

    public void setPlayers(List<User> players) {
        Players = players;
    }

    public User getAuthor() {
        return Author;
    }

    public void setAuthor(User Author) {
        this.Author = Author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
