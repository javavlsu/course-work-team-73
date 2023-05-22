package BoardMeet.Backend.Model;

import BoardMeet.Backend.DTO.BoardGameChangeDTO;
import BoardMeet.Backend.DTO.BoardGameCreateDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.Set;


//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@Entity
@Table(name = "board_game")
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
    private  String genre;
    @Column
    private  Double bestRangeOfPlayersMinUser;
    @Column
    private  Double bestRangeOfPlayersMaxUser;
    @Column
    private  Double gameTimeUser;
    @Column
    private  Double ratingUser;

    @Column
    @Type(type = "text")
    private  String description;
    @Column
    private Double weightGameUser;
    @Column
    private  Integer agePlayer;
    @Column
    private  Double agePlayerUser;
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
    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", insertable=false, updatable=false)
    private User author;
    @OneToMany(mappedBy = "gameId",fetch = FetchType.EAGER)
    private Set<Comment> comments;
    public  BoardGame(){}
    public  BoardGame (BoardGameCreateDTO boardGame){
        this.agePlayer = boardGame.getAgePlayer();
        this.gameTime = boardGame.getGameTime();
        this.authorsGame = boardGame.getAuthorsGame();
        this.authorId = boardGame.getAuthorId();
        this.artists = boardGame.getArtists();
        this.description = boardGame.getDescription();
        this.name = boardGame.getName();
        this.genre = boardGame.getGenre();
        this.rangeOfPlayersMin = boardGame.getRangeOfPlayersMin();
        this.rangeOfPlayersMax = boardGame.getRangeOfPlayersMax();
        this.publishers = boardGame.getPublishers();
        this.countComment = 0;
        this.gameTimeUser = 0D;
        this.ratingUser = 0D;
        this.bestRangeOfPlayersMaxUser = 0D;
        this.bestRangeOfPlayersMinUser = 0D;
        this.weightGameUser = 0D;
        this.agePlayerUser = 0D;
    }
    public  void change(BoardGameChangeDTO boardGame){
        this.agePlayer = boardGame.getAgePlayer();
        this.gameTime = boardGame.getGameTime();
        this.authorsGame = boardGame.getAuthorsGame();
        this.artists = boardGame.getArtists();
        this.description = boardGame.getDescription();
        this.name = boardGame.getName();
        this.genre = boardGame.getGenre();
        this.rangeOfPlayersMin = boardGame.getRangeOfPlayersMin();
        this.rangeOfPlayersMax = boardGame.getRangeOfPlayersMax();
        this.publishers = boardGame.getPublishers();
    }
    public void addRatingData(Comment comment)
    {
        ratingUser = (ratingUser * countComment + comment.getRating()) / (countComment + 1);
        weightGameUser = (weightGameUser * countComment + comment.getWeightGame()) / (countComment + 1);
        agePlayerUser = (agePlayerUser * countComment + comment.getAgePlayer()) / (countComment + 1);
        gameTimeUser = (gameTimeUser * countComment + comment.getGameTime()) / (countComment + 1);
        bestRangeOfPlayersMaxUser = (bestRangeOfPlayersMaxUser * countComment + comment.getBestPlayerMax()) / (countComment + 1);
        bestRangeOfPlayersMinUser = (bestRangeOfPlayersMinUser * countComment + comment.getBestPlayerMin()) / (countComment + 1);
        countComment++;
    }
    public void removeRatingData(Comment comment)
    {
        if (countComment <= 1)
        {
            countComment--;
            return;
        }
        ratingUser = (ratingUser * countComment - comment.getRating()) / (countComment - 1);
        weightGameUser = (weightGameUser * countComment - comment.getWeightGame()) / (countComment - 1);
        agePlayerUser = (agePlayerUser * countComment - comment.getAgePlayer()) / (countComment - 1);
        gameTimeUser = (gameTimeUser * countComment - comment.getGameTime()) / (countComment - 1);
        bestRangeOfPlayersMaxUser = (bestRangeOfPlayersMaxUser * countComment - comment.getBestPlayerMax()) / (countComment - 1);
        bestRangeOfPlayersMinUser = (bestRangeOfPlayersMinUser * countComment - comment.getBestPlayerMin()) / (countComment - 1);
        countComment--;
    }

    public BoardGame roundUserRating()
    {
        agePlayerUser = (double)Math.round(agePlayerUser);
        gameTimeUser = (double)Math.round(gameTimeUser);
        bestRangeOfPlayersMaxUser = (double)Math.round(bestRangeOfPlayersMaxUser);
        bestRangeOfPlayersMinUser = (double)Math.round(bestRangeOfPlayersMinUser);
        weightGameUser = (double)Math.round(weightGameUser * 100) / 100;
        ratingUser = (double)Math.round(ratingUser * 100) / 100;
        return this;
    }
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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

    public Double getAgePlayerUser() {
        return agePlayerUser;
    }

    public void setAgePlayerUser(Double agePlayerUser) {
        this.agePlayerUser = agePlayerUser;
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
