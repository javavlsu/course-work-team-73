package BoardMeet.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@IdClass(RecommendationPK.class)
public class Recommendation {
    @Id
    private Long userId;
    @Id
    private Long boardGameId;
    private  long interest;

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

    public long getInterest() {
        return interest;
    }

    public void setInterest(long interest) {
        this.interest = interest;
    }
}
