package BoardMeet.Backend.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CommentCreateDTO {

    @NotNull
    private String body;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    @Min(1)
    @Max(5)
    @NotNull
    private Integer rating;
    @Min(1)
    @Max(5)
    @NotNull
    private Integer weightGame;
    @NotNull
    private Integer gameTime;
    @Min(1)
    @NotNull
    private Integer bestPlayerMin;
    @NotNull
    private Integer bestPlayerMax;
    @NotNull
    private Integer agePlayer;
    @NotNull
    private Long authorId;
    @NotNull
    private Long gameId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getWeightGame() {
        return weightGame;
    }

    public void setWeightGame(int weightGame) {
        this.weightGame = weightGame;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }

    public int getBestPlayerMin() {
        return bestPlayerMin;
    }

    public void setBestPlayerMin(int bestPlayerMin) {
        this.bestPlayerMin = bestPlayerMin;
    }

    public int getBestPlayerMax() {
        return bestPlayerMax;
    }

    public void setBestPlayerMax(int bestPlayerMax) {
        this.bestPlayerMax = bestPlayerMax;
    }

    public int getAgePlayer() {
        return agePlayer;
    }

    public void setAgePlayer(int agePlayer) {
        this.agePlayer = agePlayer;
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
}
