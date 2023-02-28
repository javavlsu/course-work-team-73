package BoardMeet.Backend.dto;
import java.sql.Date;

public class CommentCreateDTO {
    public String Body;
    public Date Date;
    public int Rating;
    public int WeightGame;
    public int GameTime;
    public int BestPlayerMin;
    public int BestPlayerMax;
    public int AgePlayer;
    public int AuthorId;
    public int GameId;

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public int getWeightGame() {
        return WeightGame;
    }

    public void setWeightGame(int weightGame) {
        WeightGame = weightGame;
    }

    public int getGameTime() {
        return GameTime;
    }

    public void setGameTime(int gameTime) {
        GameTime = gameTime;
    }

    public int getBestPlayerMin() {
        return BestPlayerMin;
    }

    public void setBestPlayerMin(int bestPlayerMin) {
        BestPlayerMin = bestPlayerMin;
    }

    public int getBestPlayerMax() {
        return BestPlayerMax;
    }

    public void setBestPlayerMax(int bestPlayerMax) {
        BestPlayerMax = bestPlayerMax;
    }

    public int getAgePlayer() {
        return AgePlayer;
    }

    public void setAgePlayer(int agePlayer) {
        AgePlayer = agePlayer;
    }

    public int getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(int authorId) {
        AuthorId = authorId;
    }

    public int getGameId() {
        return GameId;
    }

    public void setGameId(int gameId) {
        GameId = gameId;
    }
}
