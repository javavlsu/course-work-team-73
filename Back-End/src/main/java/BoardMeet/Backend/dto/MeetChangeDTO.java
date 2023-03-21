package BoardMeet.Backend.dto;

import BoardMeet.Backend.Model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class MeetChangeDTO implements Serializable {
    @NotEmpty
    private  Long Id;
    @Length(min = 2)
    private String name;
    @Min(2)
    private int peopleCountMax;
    @Min(1)
    private int duration;
    private String link;
    @NotEmpty
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    @NotEmpty
    private String location;
    @NotEmpty
    private String city;
    private String games;
    @NotNull
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
