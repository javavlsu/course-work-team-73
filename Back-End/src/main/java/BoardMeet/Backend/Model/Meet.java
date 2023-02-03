package BoardMeet.Backend.Model;

import javax.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
public class Meet extends  BaseEntity{

    @Column
    private  String name;
    @Column
    private  Integer peopleCount;
    @Column
    private  Integer peopleCountMax;
    @Column
    private  Integer duration;
    @Column
    private  String link;
    @Column
    private Date date;
    @Column
    private  String state;
    @Column
    private  String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getPeopleCountMax() {
        return peopleCountMax;
    }

    public void setPeopleCountMax(Integer peopleCountMax) {
        this.peopleCountMax = peopleCountMax;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Column
    private  String city;
    @Column
    private  String games;
    @ManyToMany
    private List<User> players;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;




}
