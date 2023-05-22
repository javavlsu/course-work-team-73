package BoardMeet.Backend.Model;

import BoardMeet.Backend.DTO.CommentCreateDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "comment")
public class Comment extends  BaseEntity{

    @Column
    private String body;
    @Column
    private  Integer rating;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column
    private Date date;
    @Column
    private  Integer weightGame;
    @Column
    private  Integer gameTime;
    @Column
    private  Integer bestPlayerMin;
    @Column
    private  Integer bestPlayerMax;
    @Column
    private  Integer agePlayer;

    @Column(name = "author_id")
    private Long authorId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", insertable=false, updatable=false)
    private User author;

    @Column(name = "game_id")
    private Long gameId;

    public  Comment (){}
    public  Comment (CommentCreateDTO comment){
        this.body = comment.getBody();
        this.rating = comment.getRating();
        this.weightGame = comment.getWeightGame();
        this.gameTime = comment.getGameTime();
        this.bestPlayerMax = comment.getBestPlayerMax();
        this.bestPlayerMin = comment.getBestPlayerMin();
        this.agePlayer = comment.getAgePlayer();
        this.authorId = comment.getAuthorId();
        this.gameId = comment.getGameId();
        this.date = comment.getDate();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getWeightGame() {
        return weightGame;
    }

    public void setWeightGame(Integer weightGame) {
        this.weightGame = weightGame;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getGameTime() {
        return gameTime;
    }

    public void setGameTime(Integer gameTime) {
        this.gameTime = gameTime;
    }

    public Integer getBestPlayerMin() {
        return bestPlayerMin;
    }

    public void setBestPlayerMin(Integer bestPlayerMin) {
        this.bestPlayerMin = bestPlayerMin;
    }

    public Integer getBestPlayerMax() {
        return bestPlayerMax;
    }

    public void setBestPlayerMax(Integer bestPlayerMax) {
        this.bestPlayerMax = bestPlayerMax;
    }

    public Integer getAgePlayer() {
        return agePlayer;
    }

    public void setAgePlayer(Integer agePlayer) {
        this.agePlayer = agePlayer;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
