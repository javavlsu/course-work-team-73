package BoardMeet.Backend.Model;

import BoardMeet.Backend.DTO.MeetChangeDTO;
import BoardMeet.Backend.DTO.MeetCreateDTO;
import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.time.DateUtils;

import javax.persistence.*;


import java.util.Calendar;
import java.util.Date;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", insertable=false, updatable=false)

    private User author;
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
        this.state = MeetState.RECRUITING;
        refreshState();
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
        refreshState();
    }
    public void refreshState() {
        Date now = DateUtils.addHours(new Date(),3);

        Calendar stop = Calendar.getInstance();

        stop.setTime(date);
        stop.add(stop.MINUTE,duration+60*3);

        if (now.compareTo(stop.getTime())>0)
        {
            state = MeetState.FINISHED;
        }
        else if (peopleCount < peopleCountMax && now.compareTo(this.date)<0)
        {
            state = MeetState.RECRUITING;
        }
        else if (peopleCount >= peopleCountMax && now.compareTo(this.date)<0)
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
