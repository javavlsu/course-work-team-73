package BoardMeet.Backend.Model;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String Body;
    @Column
    private  Integer Rating;
    @Column
    private  Integer WeightGame;
    @Column
    private  Integer GameTime;
    @Column
    private  Integer BestPlayerMin;
    @Column
    private  Integer BestPlayerMax;
    @Column
    private  Integer AgePlayer;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User Author;


    @ManyToOne
    @JoinColumn(name = "game_id")
    private BoardGame Game;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public Integer getRating() {
        return Rating;
    }

    public void setRating(Integer rating) {
        Rating = rating;
    }

    public Integer getWeightGame() {
        return WeightGame;
    }

    public void setWeightGame(Integer weightGame) {
        WeightGame = weightGame;
    }

    public Integer getGameTime() {
        return GameTime;
    }

    public void setGameTime(Integer gameTime) {
        GameTime = gameTime;
    }

    public Integer getBestPlayerMin() {
        return BestPlayerMin;
    }

    public void setBestPlayerMin(Integer bestPlayerMin) {
        BestPlayerMin = bestPlayerMin;
    }

    public Integer getBestPlayerMax() {
        return BestPlayerMax;
    }

    public void setBestPlayerMax(Integer bestPlayerMax) {
        BestPlayerMax = bestPlayerMax;
    }

    public Integer getAgePlayer() {
        return AgePlayer;
    }

    public void setAgePlayer(Integer agePlayer) {
        AgePlayer = agePlayer;
    }

    public User getAuthor() {
        return Author;
    }

    public void setAuthor(User Author) {
        this.Author = Author;
    }

    public BoardGame getGame() {
        return Game;
    }

    public void setGame(BoardGame Game) {
        this.Game = Game;
    }


}
