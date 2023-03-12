package BoardMeet.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.util.List;
import java.util.Set;


@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class BoardGame extends  BaseEntity{

    @Column
    private  String name;
    @Column
    private  Integer rangeOfPlayersMin;
    @Column
    private  Integer rangeOfPlayersMax;
    @Column
    private Integer gameTime;
    @Column
    private  Double bestRangeOfPlayersMinUser;
    @Column
    private  Double bestRangeOfPlayersMaxUser;
    @Column
    private  Double gameTimeUser;
    @Column
    private  Double ratingUser;
    @Column
    private  String description;
    @Column
    private Double weightGameUser;
    @Column
    private  Integer agePlayer;
    @Column
    private  Double agePlayerUSer;
    @Column
    private  String rule;
    @Column
    private String gameAvatar;
    @Column
    private String authorsGame;
    @Column
    private  String artists;
    @Column
    private String publishers;
    @Column
    private  Integer countComment;
    @Column(name = "author_id")
    private Long authorId;
    @OneToMany(mappedBy = "gameId",fetch = FetchType.EAGER)
    private Set<Comment> comments;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRangeOfPlayersMin() {
        return rangeOfPlayersMin;
    }

    public void setRangeOfPlayersMin(Integer rangeOfPlayersMin) {
        this.rangeOfPlayersMin = rangeOfPlayersMin;
    }

    public Integer getRangeOfPlayersMax() {
        return rangeOfPlayersMax;
    }

    public void setRangeOfPlayersMax(Integer rangeOfPlayersMax) {
        this.rangeOfPlayersMax = rangeOfPlayersMax;
    }

    public Integer getGameTime() {
        return gameTime;
    }

    public void setGameTime(Integer gameTime) {
        this.gameTime = gameTime;
    }

    public Double getBestRangeOfPlayersMinUser() {
        return bestRangeOfPlayersMinUser;
    }

    public void setBestRangeOfPlayersMinUser(Double bestRangeOfPlayersMinUser) {
        this.bestRangeOfPlayersMinUser = bestRangeOfPlayersMinUser;
    }

    public Double getBestRangeOfPlayersMaxUser() {
        return bestRangeOfPlayersMaxUser;
    }

    public void setBestRangeOfPlayersMaxUser(Double bestRangeOfPlayersMaxUser) {
        this.bestRangeOfPlayersMaxUser = bestRangeOfPlayersMaxUser;
    }

    public Double getGameTimeUser() {
        return gameTimeUser;
    }

    public void setGameTimeUser(Double gameTimeUser) {
        this.gameTimeUser = gameTimeUser;
    }

    public Double getRatingUser() {
        return ratingUser;
    }

    public void setRatingUser(Double ratingUser) {
        this.ratingUser = ratingUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeightGameUser() {
        return weightGameUser;
    }

    public void setWeightGameUser(Double weightGameUser) {
        this.weightGameUser = weightGameUser;
    }

    public Integer getAgePlayer() {
        return agePlayer;
    }

    public void setAgePlayer(Integer agePlayer) {
        this.agePlayer = agePlayer;
    }

    public Double getAgePlayerUSer() {
        return agePlayerUSer;
    }

    public void setAgePlayerUSer(Double agePlayerUSer) {
        this.agePlayerUSer = agePlayerUSer;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getGameAvatar() {
        return gameAvatar;
    }

    public void setGameAvatar(String gameAvatar) {
        this.gameAvatar = gameAvatar;
    }

    public String getAuthorsGame() {
        return authorsGame;
    }

    public void setAuthorsGame(String authorsGame) {
        this.authorsGame = authorsGame;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public Integer getCountComment() {
        return countComment;
    }

    public void setCountComment(Integer countComment) {
        this.countComment = countComment;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


}
