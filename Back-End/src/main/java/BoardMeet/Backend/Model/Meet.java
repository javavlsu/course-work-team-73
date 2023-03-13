package BoardMeet.Backend.Model;

import BoardMeet.Backend.dto.MeetChangeDTO;
import BoardMeet.Backend.dto.MeetCreateDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
    @Column(name = "author_id")
    private Long authorId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "meet_user_players",
            joinColumns = @JoinColumn(name = "meet_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> players;

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
        this.peopleCount = 0;
        this.state = MeetState.STARTOPEN;
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
    public void refreshState() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.MINUTE,duration);
        if (now.compareTo(calendar.getTime())>0)
        {
            state = MeetState.FINISHED;
        }
        else if (peopleCount < peopleCountMax && now.compareTo(date)<0)
        {
            state = MeetState.RECRUITING;
        }
        else if (peopleCount >= peopleCountMax && now.compareTo(date)<0)
        {
            state = MeetState.RECRUITINGFULL;
        }
        else if (peopleCount < peopleCountMax && now.compareTo(date)> 0&& state != MeetState.STARTLOCK)
        {
            state = MeetState.STARTOPEN;
        }
        else if (peopleCount >= peopleCountMax && now.compareTo(date)>0)
        {
            state = MeetState.STARTFULL;

        }
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

    public Set<User> getPlayers() {
        return players;
    }

    public void setPlayers(Set<User> players) {
        this.players = players;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
