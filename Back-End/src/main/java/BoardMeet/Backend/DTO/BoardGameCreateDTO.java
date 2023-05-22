package BoardMeet.Backend.DTO;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BoardGameCreateDTO implements Serializable {

    @NotEmpty
    private String name;
    @NotEmpty
    private String genre;
    @NotNull
    private Integer rangeOfPlayersMin;
    @NotNull
    private Integer rangeOfPlayersMax;
    @NotNull
    private Integer gameTime;
    @NotEmpty
    private String description;
    @NotNull
    private Integer agePlayer;
    @NotEmpty
    private String authorsGame;
    @NotEmpty
    private String artists;
    @NotEmpty
    private String publishers;
    @NotNull
    private Long authorId;
    private MultipartFile rule;
    private MultipartFile avatarGame;

    public BoardGameCreateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAgePlayer() {
        return agePlayer;
    }

    public void setAgePlayer(Integer agePlayer) {
        this.agePlayer = agePlayer;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public MultipartFile getRule() {
        return rule;
    }

    public void setRule(MultipartFile rule) {
        this.rule = rule;
    }

    public MultipartFile getAvatarGame() {
        return avatarGame;
    }

    public void setAvatarGame(MultipartFile avatarGame) {
        this.avatarGame = avatarGame;
    }
}
