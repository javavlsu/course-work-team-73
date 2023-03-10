package BoardMeet.Backend.Model;

import BoardMeet.Backend.dto.MeetChangeDTO;
import BoardMeet.Backend.dto.MeetCreateDTO;

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
    @Enumerated(EnumType.STRING)
    private  MeetState state;
    @Column
    private  String location;
    @Column
    private  String games;
    @Column
    private  String city;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<User> players;
    private Long authorId;
    public  Meet(){}
    public  Meet(MeetCreateDTO meetCreateDTO){
        this.name = meetCreateDTO.getName();
        this.peopleCountMax = meetCreateDTO.getPeopleCountMax();
        this.duration = meetCreateDTO.getDuration();
        this.link = meetCreateDTO.getLink();
        this.date = meetCreateDTO.getDate();
        this.city = meetCreateDTO.getCity();
        this.authorId = meetCreateDTO.getAuthorId();
        this.games = meetCreateDTO.getGames();
        this.location = meetCreateDTO.getLocation();
    }
    public void change(MeetChangeDTO meetChangeDTO){
        this.name = meetChangeDTO.getName();
        this.location = meetChangeDTO.getLocation();
        this.games = meetChangeDTO.getGames();
        this.date = meetChangeDTO.getDate();
        this.link = meetChangeDTO.getLink();
        this.peopleCountMax = meetChangeDTO.getPeopleCountMax();
        this.city = meetChangeDTO.getCity();
        this.duration = meetChangeDTO.getDuration();
        this.players = meetChangeDTO.getPlayers();
    }

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

    public MeetState getState() {
        return state;
    }

    public void setState(MeetState state) {
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
