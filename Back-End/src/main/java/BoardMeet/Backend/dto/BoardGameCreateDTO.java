package BoardMeet.Backend.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

public class BoardGameCreateDTO {
    @Length(min = 1)
    @NotEmpty
    private String name;
    @NotEmpty
    private int rangeOfPlayersMin;
    @NotEmpty
    private int rangeOfPlayersMax;
    @NotEmpty
    private int gameTime;
    @NotEmpty
    private String description;
    @NotEmpty
    private int agePlayer;
    @NotEmpty

    private String authorsGame;
    @NotEmpty
    private String genre;
    @NotEmpty
    private String artists;
    @NotEmpty
    private String publishers;
    @NotEmpty
    private Long authorId;
    private MultipartFile rule;
    private MultipartFile avatarGame;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRangeOfPlayersMin() {
        return rangeOfPlayersMin;
    }

    public void setRangeOfPlayersMin(int rangeOfPlayersMin) {
        rangeOfPlayersMin = rangeOfPlayersMin;
    }

    public int getRangeOfPlayersMax() {
        return rangeOfPlayersMax;
    }

    public void setRangeOfPlayersMax(int rangeOfPlayersMax) {
        rangeOfPlayersMax = rangeOfPlayersMax;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        gameTime = gameTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public int getAgePlayer() {
        return agePlayer;
    }

    public void setAgePlayer(int agePlayer) {
        agePlayer = agePlayer;
    }

    public String getAuthorsGame() {
        return authorsGame;
    }

    public void setAuthorsGame(String authorsGame) {
        authorsGame = authorsGame;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        genre = genre;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        artists = artists;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        publishers = publishers;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        authorId = authorId;
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
