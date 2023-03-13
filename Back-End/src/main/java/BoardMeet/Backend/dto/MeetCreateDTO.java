package BoardMeet.Backend.dto;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.sql.Date;

public class MeetCreateDTO implements Serializable {
    @NotNull
    @Length( min = 2)
    private String name;
    @NotNull
    @Min(1)
    private int peopleCountMax;
    @NotNull
    @Min(1)
    private int duration;
    private String link;
    @NotNull
    private Date date;
    @NotNull
    private String location;
    @NotNull
    @Length(min = 2)
    private String city;
    @NotNull
    private String games;
    @NotNull
    private Long authorId;

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
