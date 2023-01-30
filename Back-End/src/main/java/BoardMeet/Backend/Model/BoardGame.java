package BoardMeet.Backend.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BoardGame {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private  String Name;
    @Column
    private  Integer RangeOfPlayersMin;
    @Column
    private  Integer RangeOfPlayersMax;
    @Column
    private Integer GameTime;
    @Column
    private  Double BestRangeOfPlayersMinUser;
    @Column
    private  Double BestRangeOfPlayersMaxUser;
    @Column
    private  Double GameTimeUser;
    @Column
    private  Double RatingUser;
    @Column
    private  String Description;
    @Column
    private Double WeightGameUser;
    @Column
    private  Integer AgePlayer;
    @Column
    private  Double AgePlayerUSer;
    @Column
    private  String Rule;
    @Column
    private String GameAvatar;
    @Column
    private String AuthorsGame;
    @Column
    private  String Artists;
    @Column
    private String Publishers;
    @Column
    private  Integer CountComment;
    @ManyToOne
    private  List<Comment> Comments;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User Author;


    public Integer getCountComment() {
        return CountComment;
    }

    public void setCountComment(Integer countComment) {
        CountComment = countComment;
    }


    public List<Comment> getComments() {
        return Comments;
    }

    public void setComments(List<Comment> comments) {
        Comments = comments;
    }




    public User getAuthor() {
        return Author;
    }

    public void setAuthor(User Author) {
        this.Author = Author;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getRangeOfPlayersMin() {
        return RangeOfPlayersMin;
    }

    public void setRangeOfPlayersMin(Integer rangeOfPlayersMin) {
        RangeOfPlayersMin = rangeOfPlayersMin;
    }

    public Integer getRangeOfPlayersMax() {
        return RangeOfPlayersMax;
    }

    public void setRangeOfPlayersMax(Integer rangeOfPlayersMax) {
        RangeOfPlayersMax = rangeOfPlayersMax;
    }

    public Integer getGameTime() {
        return GameTime;
    }

    public void setGameTime(Integer gameTime) {
        GameTime = gameTime;
    }

    public Double getBestRangeOfPlayersMinUser() {
        return BestRangeOfPlayersMinUser;
    }

    public void setBestRangeOfPlayersMinUser(Double bestRangeOfPlayersMinUser) {
        BestRangeOfPlayersMinUser = bestRangeOfPlayersMinUser;
    }

    public Double getBestRangeOfPlayersMaxUser() {
        return BestRangeOfPlayersMaxUser;
    }

    public void setBestRangeOfPlayersMaxUser(Double bestRangeOfPlayersMaxUser) {
        BestRangeOfPlayersMaxUser = bestRangeOfPlayersMaxUser;
    }

    public Double getGameTimeUser() {
        return GameTimeUser;
    }

    public void setGameTimeUser(Double gameTimeUser) {
        GameTimeUser = gameTimeUser;
    }

    public Double getRatingUser() {
        return RatingUser;
    }

    public void setRatingUser(Double ratingUser) {
        RatingUser = ratingUser;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getWeightGameUser() {
        return WeightGameUser;
    }

    public void setWeightGameUser(Double weightGameUser) {
        WeightGameUser = weightGameUser;
    }

    public Integer getAgePlayer() {
        return AgePlayer;
    }

    public void setAgePlayer(Integer agePlayer) {
        AgePlayer = agePlayer;
    }

    public Double getAgePlayerUSer() {
        return AgePlayerUSer;
    }

    public void setAgePlayerUSer(Double agePlayerUSer) {
        AgePlayerUSer = agePlayerUSer;
    }

    public String getRule() {
        return Rule;
    }

    public void setRule(String rule) {
        Rule = rule;
    }

    public String getGameAvatar() {
        return GameAvatar;
    }

    public void setGameAvatar(String gameAvatar) {
        GameAvatar = gameAvatar;
    }

    public String getAuthorsGame() {
        return AuthorsGame;
    }

    public void setAuthorsGame(String authorsGame) {
        AuthorsGame = authorsGame;
    }

    public String getArtists() {
        return Artists;
    }

    public void setArtists(String artists) {
        Artists = artists;
    }

    public String getPublishers() {
        return Publishers;
    }

    public void setPublishers(String publishers) {
        Publishers = publishers;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
