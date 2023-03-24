package BoardMeet.Backend.Model;

import BoardMeet.Backend.DTO.CommentCreateDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "recommendation")
@IdClass(RecommendationPK.class)
public class Recommendation {
    @Id
    private Long userId;
    @Id
    private Long boardGameId;
    private  long interest;

    public Recommendation(){}
    public Recommendation(CommentCreateDTO comment){
        userId = comment.getAuthorId();
        boardGameId = comment.getGameId();
        interest = 0;
    }
    public  Recommendation(Long boardGameId, Long userId){
        this.userId = userId;
        this.boardGameId = boardGameId;
        interest = 0;
    }

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
