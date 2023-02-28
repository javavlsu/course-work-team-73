package BoardMeet.Backend.dto;
import org.springframework.web.multipart.MultipartFile;

public class BoardGameChangeDTO {
        public  String Name;
        public  String AuthorsGame;
        public  String Genre;
        public  String Artists;
        public  String Publishers;
        public int RangeOfPlayersMin;
        public int RangeOfPlayersMax;
        public int GameTime;
        public  String Description;
        public int AgePlayer;
        public MultipartFile rule;
        public MultipartFile avatarGame;

        public String getName() {
                return Name;
        }

        public void setName(String name) {
                Name = name;
        }

        public String getAuthorsGame() {
                return AuthorsGame;
        }

        public void setAuthorsGame(String authorsGame) {
                AuthorsGame = authorsGame;
        }

        public String getGenre() {
                return Genre;
        }

        public void setGenre(String genre) {
                Genre = genre;
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

        public int getRangeOfPlayersMin() {
                return RangeOfPlayersMin;
        }

        public void setRangeOfPlayersMin(int rangeOfPlayersMin) {
                RangeOfPlayersMin = rangeOfPlayersMin;
        }

        public int getRangeOfPlayersMax() {
                return RangeOfPlayersMax;
        }

        public void setRangeOfPlayersMax(int rangeOfPlayersMax) {
                RangeOfPlayersMax = rangeOfPlayersMax;
        }

        public int getGameTime() {
                return GameTime;
        }

        public void setGameTime(int gameTime) {
                GameTime = gameTime;
        }

        public String getDescription() {
                return Description;
        }

        public void setDescription(String description) {
                Description = description;
        }

        public int getAgePlayer() {
                return AgePlayer;
        }

        public void setAgePlayer(int agePlayer) {
                AgePlayer = agePlayer;
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
