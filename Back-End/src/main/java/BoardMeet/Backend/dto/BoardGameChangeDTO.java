package BoardMeet.Backend.dto;
import org.springframework.web.multipart.MultipartFile;

public class BoardGameChangeDTO {
        private  Long id;
        private String name;
        private String authorsGame;
        private String genre;
        private String artists;
        private  String publisher;
        private int rangeOfPlayersMin;
        private int rangeOfPlayersMax;
        private int gameTime;
        private String description;
        private int agePlayer;
        private MultipartFile rule;
        private MultipartFile avatarGame;
        public String getName() {
                return name;
        }

        private String Publishers;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                id = id;
        }

        public void setName(String name) {
                name = name;
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

        public String getPublisher() {
                return publisher;
        }

        public void setPublisher(String publisher) {
                publisher = publisher;
        }

        public String getPublishers() {
                return Publishers;
        }

        public void setPublishers(String publishers) {
                Publishers = publishers;
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
