package BoardMeet.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class RecommendationPK implements Serializable {
    private Long userId;
    private Long boardGameId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBoardGameId() {
        return boardGameId;
    }

    public void setBoardGameId(Long boardGameId) {
        this.boardGameId = boardGameId;
    }
}
