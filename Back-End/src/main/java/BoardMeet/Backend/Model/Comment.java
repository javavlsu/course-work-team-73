package BoardMeet.Backend.Model;

import BoardMeet.Backend.dto.CommentCreateDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Comment extends  BaseEntity{

    @Column
    private String body;
    @Column
    private  Integer rating;
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

    public Long getAuthor() {
        return authorId;
    }

    public void setAuthor(Long authorId) {
        this.authorId = authorId;
    }

    public Long getGame() {
        return gameId;
    }

    public void setGame(Long gameId) {
        this.gameId = gameId;
    }
}
