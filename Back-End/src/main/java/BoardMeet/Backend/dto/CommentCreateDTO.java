package BoardMeet.Backend.dto;
import java.sql.Date;

public class CommentCreateDTO {
    private String body;
    private Date date;
    private int rating;
    private int weightGame;
    private int gameTime;
    private int bestPlayerMin;
    private int bestPlayerMax;
    private int agePlayer;
    private Long authorId;
    private Long gameId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public java.sql.Date getDate() {
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
