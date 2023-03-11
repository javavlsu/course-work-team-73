package BoardMeet.Backend.Model;

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
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private BoardGame game;

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public BoardGame getGame() {
        return game;
    }

    public void setGame(BoardGame game) {
        this.game = game;
    }
}
