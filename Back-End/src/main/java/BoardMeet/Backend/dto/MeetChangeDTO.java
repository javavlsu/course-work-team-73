package BoardMeet.Backend.dto;

import BoardMeet.Backend.Model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class MeetChangeDTO implements Serializable {
    private  Long Id;
    private String name;
    private int peopleCountMax;
    private int duration;
    private String link;
    private java.sql.Date date;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private String location;
    private String city;
    private String games;
    private Set<User> players;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeopleCountMax() {
        return peopleCountMax;
    }

    public void setPeopleCountMax(int peopleCountMax) {
        this.peopleCountMax = peopleCountMax;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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

    public Set<User> getPlayers() {
        return players;
    }

    public void setPlayers(Set<User> players) {
        this.players = players;
    }
}
