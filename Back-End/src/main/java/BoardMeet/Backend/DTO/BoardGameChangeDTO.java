package BoardMeet.Backend.DTO;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BoardGameChangeDTO {
        @NotNull
        private  Long id;
        @NotEmpty
        @Length(min = 1)
        private String name;
        @NotEmpty
        private String authorsGame;
        @NotEmpty
        private String genre;
        @NotEmpty
        private String artists;
        @NotEmpty
        private  String publishers;
        @NotNull
        private int rangeOfPlayersMin;
        @NotNull
        private int rangeOfPlayersMax;
        @NotNull
        private int gameTime;
        @NotEmpty
        private String description;
        @NotNull
        private int agePlayer;
        private MultipartFile rule;
        private MultipartFile avatarGame;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAuthorsGame() {
                return authorsGame;
        }

        public void setAuthorsGame(String authorsGame) {
                this.authorsGame = authorsGame;
        }

        public String getGenre() {
                return genre;
        }

        public void setGenre(String genre) {
                this.genre = genre;
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

        public void setPublishers(String publisher) {
                this.publishers = publisher;
        }

        public int getRangeOfPlayersMin() {
                return rangeOfPlayersMin;
        }

        public void setRangeOfPlayersMin(int rangeOfPlayersMin) {
                this.rangeOfPlayersMin = rangeOfPlayersMin;
        }

        public int getRangeOfPlayersMax() {
                return rangeOfPlayersMax;
        }

        public void setRangeOfPlayersMax(int rangeOfPlayersMax) {
                this.rangeOfPlayersMax = rangeOfPlayersMax;
        }

        public int getGameTime() {
                return gameTime;
        }

        public void setGameTime(int gameTime) {
                this.gameTime = gameTime;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public int getAgePlayer() {
                return agePlayer;
        }

        public void setAgePlayer(int agePlayer) {
                this.agePlayer = agePlayer;
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
